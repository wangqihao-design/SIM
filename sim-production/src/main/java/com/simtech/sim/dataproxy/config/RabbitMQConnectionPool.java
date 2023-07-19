package com.simtech.sim.dataproxy.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConnectionPool {

    private final ObjectPool<Connection> connectionPool;


    public RabbitMQConnectionPool() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5674);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        GenericObjectPoolConfig<Connection> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(20);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxIdle(10);
        this.connectionPool = new GenericObjectPool<>(new ConnectionFactoryPoolableObjectFactory(connectionFactory), poolConfig);
    }

    public Connection getConnection() throws Exception {
        return connectionPool.borrowObject();
    }

    public void releaseConnection(Connection connection) throws Exception {
        connectionPool.returnObject(connection);
    }

    public void destroy() throws Exception {
        connectionPool.close();
    }
}
