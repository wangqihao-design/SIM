import pika
from flask import Flask

app = Flask(__name__)


def consume_message(queue, key, response):
    # RabbitMQ 连接参数
    connection_params = pika.ConnectionParameters(host='localhost', port=5674)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # 定义队列
    queue_name = queue

    def callback(ch, method, properties, body):
        # 处理接收到的消息
        print("Received message:", body)

        # 构造响应消息
        # 发布响应消息
        channel.basic_publish(
            exchange='',
            routing_key=str(properties.reply_to),  # 使用 reply_to 属性中指定的队列作为 routing_key
            body=response,
            properties=pika.BasicProperties(
                correlation_id=properties.correlation_id  # 设置 correlation_id，用于关联请求和响应
            )
        )

    # 绑定队列和交换机
    channel.queue_declare(queue=queue_name, durable=True)
    channel.queue_bind(queue=queue_name, exchange="algorithm." + queue, routing_key=key)

    # 注册回调函数
    channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

    # 开始消费消息
    channel.start_consuming()

    return 'Consuming messages from RabbitMQ'

