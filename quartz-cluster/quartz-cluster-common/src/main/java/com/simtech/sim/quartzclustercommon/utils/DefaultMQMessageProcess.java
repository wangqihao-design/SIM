package com.simtech.sim.quartzclustercommon.utils;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import com.simtech.sim.quartzclustercommon.config.mq.RabbitMQConnectionPool;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


@Component
public class DefaultMQMessageProcess<T, M>  {

    @Autowired
    private RabbitMQConnectionPool connectionPool;

    private String res;

    public String getResponse(){
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
        // 设置reply_to属性为临时队列的名称
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .replyTo(replyQueueName)
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
                res = response;
                System.out.println(response);
            }
        };
        channel.basicConsume(replyQueueName, true, consumer);

        channel.close();
        connectionPool.releaseConnection(connection);
    }



}