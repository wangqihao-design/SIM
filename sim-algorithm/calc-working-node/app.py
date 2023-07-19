from flask import Flask
from nacos import NacosClient
import model

app = Flask(__name__)


def nacos_initialize(port):
    client = NacosClient("localhost:8848", username="nacos", password="nacos")

    # 获取Flask应用的主机和端口
    host = 'localhost'
    client.add_naming_instance("calc-working-node", host, port)


@app.route("/")
def calculate():
    model.retrieve_file()

nacos_initialize(5000)

if __name__ == '__main__':
    app.run(port=5000)
