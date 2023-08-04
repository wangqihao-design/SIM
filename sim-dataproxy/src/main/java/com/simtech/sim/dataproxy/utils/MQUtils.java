package com.simtech.sim.dataproxy.utils;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import com.simtech.sim.dataproxy.config.RabbitMQConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;


@Component
public class MQUtils<T, M>  {

    @Autowired
    private RabbitMQConnectionPool connectionPool;

    private String res;

    public String getResponse(){
        return this.res;
    }

    private final Gson gson = new Gson();
    public CompletableFuture<String> send(T request, Class<M> responseType, String exchangeName, String queueName) throws Exception {
        CompletableFuture<String> responseFuture = new CompletableFuture<>();

        Connection connection = connectionPool.getConnection();
        Channel channel = connection.createChannel();

        String exchangeType = "topic";
        channel.exchangeDeclare(exchangeName, exchangeType, true);

        String routingKey = queueName;
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);


        // 设置reply_to属性为临时队列的名称
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .replyTo("algorithm.replyQueue")
                .build();


        String message = gson.toJson(request);
        channel.basicPublish(exchangeName, routingKey, props, message.getBytes());

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String response = new String(body);

                System.out.printf("[X-Client]\ndeliveryTag:%s\nexchange:%s\nroutingKey:%s\ncorrelationId:%s\nreplyTo:%s\ncontent:%s\n%n",
                        envelope.getDeliveryTag(), envelope.getExchange(), envelope.getRoutingKey(), properties.getCorrelationId(),
                        properties.getReplyTo(), new String(body, StandardCharsets.UTF_8));
                System.out.println(response);
                responseFuture.complete(response);
            }
        };


        Thread.sleep(5);    //等待reply消息到达

        channel.basicConsume("replyTo", true, consumer);

        channel.close();
        connectionPool.releaseConnection(connection);



        return responseFuture;
    }




}