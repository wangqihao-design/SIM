package com.simtech.sim.dataproxy.service.sender.senderImpl;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simtech.sim.common.utils.Result;
import com.simtech.sim.dataproxy.config.RabbitMQConnectionPool;
import com.simtech.sim.dataproxy.service.sender.SenderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderProxyImpl<T, M> implements SenderProxy<T, M> {

    @Autowired
    private RabbitMQConnectionPool connectionPool;

    @Override
    public Result<T> messageSender(M message) throws Exception {

        Connection connection = connectionPool.getConnection();

        Channel channel = connection.createChannel();



        return null;
    }
}
