package com.simtech.sim.technology.util;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import com.simtech.sim.technology.config.mq.connection.RabbitMQConnectionPool;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
@Component
public class DefaultMQMessageProcess<T, M> {

    @Autowired
    private RabbitMQConnectionPool connectionPool;

    private M res;

    public M getResponse() {
        return this.res;
    }

    private final Gson gson = new Gson();

    public void send(T request, Class<M> responseType, String exchangeName, String queueName, CompletableFuture<M> responseFuture) throws Exception {
        Connection connection = connectionPool.getConnection();
        Channel channel = connection.createChannel();

        String exchangeType = "topic";
        channel.exchangeDeclare(exchangeName, exchangeType, true);

        String routingKey = queueName;
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        String replyQueueName = channel.queueDeclare().getQueue();
        // 设置 reply_to 属性为临时队列的名称
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .replyTo(replyQueueName)
                .contentType("application/json")
                .build();

        String message = gson.toJson(request);
        channel.basicPublish(exchangeName, routingKey, props, message.getBytes());

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String response = new String(body);
                M parsedResponse = gson.fromJson(response, responseType);
                responseFuture.complete(parsedResponse);
                res = parsedResponse;
            }
        };
        channel.basicConsume(replyQueueName, true, consumer);

        channel.close();
        connectionPool.releaseConnection(connection);
    }
}