package com.simtech.sim.quartzclustercommon.config.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;


public class ConnectionFactoryPoolableObjectFactory implements PooledObjectFactory<Connection> {

    private final ConnectionFactory connectionFactory;

    public ConnectionFactoryPoolableObjectFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public PooledObject<Connection> makeObject() throws Exception {
        Connection connection = connectionFactory.newConnection();
        return new DefaultPooledObject<Connection>(connection);
    }

    public void destroyObject(PooledObject<Connection> pooledObject) throws Exception {
        Connection connection = pooledObject.getObject();
        connection.close();
    }

    public boolean validateObject(PooledObject<Connection> pooledObject) {
        Connection connection = pooledObject.getObject();
        return connection.isOpen();
    }

    public void activateObject(PooledObject<Connection> pooledObject) throws Exception {
    }

    public void passivateObject(PooledObject<Connection> pooledObject) throws Exception {
    }
}
