package com.simtech.sim.dataproxy.service.sender.impl;


import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simtech.sim.dataproxy.config.RabbitMQConnectionPool;
import com.simtech.sim.dataproxy.service.sender.QuartzSenderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class QuartzSenderProxyImpl<M> implements QuartzSenderProxy<M> {

    @Autowired
    private RabbitMQConnectionPool connectionPool;


    @Override
    public void messageSender(M message) throws Exception {
        String exchangeName = "quartz-cluster.sender";
        String routingKey = "sender";
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .contentType("application/json")
                .build();

        Connection connection = connectionPool.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(exchangeName, "direct", true);

        channel.basicPublish(exchangeName, routingKey, props, new Gson().toJson(message).getBytes(StandardCharsets.UTF_8));

        channel.close();

        connectionPool.releaseConnection(connection);
    }

}
