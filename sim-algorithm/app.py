from flask import Flask
from production.routes import routes

app = Flask(__name__)

# 注册蓝图
app.register_blueprint(routes)

if __name__ == '__main__':
    app.run()
