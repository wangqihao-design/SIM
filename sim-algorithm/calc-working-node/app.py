from flask import Flask
import model
from concurrent.futures import ThreadPoolExecutor, as_completed
import json
import pika
import uuid

app = Flask(__name__)

# 创建一个包含5条线程的线程池
pool = ThreadPoolExecutor(max_workers=5)
thread_list = []
response = {
    "applicationId": uuid.uuid1().int,
    "response": None
}


def calculate(instanceId, algType):
    futureTask = pool.submit(model.DownloadAndLoad, instanceId, algType)
    thread_list.append(futureTask)
    print(instanceId, algType)

    for future in as_completed(thread_list, timeout=10):
        global response
        response['response'] = future.result()
    return "success"


@app.route("/")
def consume_message(queue = "production", key = "production"):
    # RabbitMQ 连接参数
    connection_params = pika.ConnectionParameters(host='localhost', port=5672)
    connection = pika.BlockingConnection(connection_params)
    channel = connection.channel()

    # 定义队列
    queue_name = queue

    def callback(ch, method, properties, body):
        # 处理接收到的消息
        print("Received message:", body)

        requests = json.loads(body)
        calculate(requests['instanceId'], requests['algType'])

        print(properties.reply_to)

        # 构造响应消息
        # 发布响应消息
        print(properties.correlation_id)

        print(bytes(json.dumps(response), encoding="utf-8"))
        channel.basic_publish(
            exchange="algorithm.replyQueue",
            routing_key="replyTo",  # 使用 reply_to 属性中指定的队列作为 routing_key
            body=bytes(json.dumps(response), encoding="utf-8"),
            properties=pika.BasicProperties(
                correlation_id=properties.correlation_id  # 设置 correlation_id，用于关联请求和响应
            )
        )

        print("Publish complete")

    # 绑定队列和交换机
    channel.queue_declare(queue=queue_name, durable=True)
    channel.queue_bind(queue=queue_name, exchange="algorithm." + queue, routing_key=key)

    # 注册回调函数
    channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

    # 开始消费消息
    channel.start_consuming()




if __name__ == '__main__':
    app.run(port=5000)
