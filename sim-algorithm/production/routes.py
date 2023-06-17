from flask import Blueprint
from production.service import consume_message

# 创建蓝图对象
routes = Blueprint('routes', __name__)


@routes.route('/')
def index():
    return consume_message("techRecipe", "recipe", '{"id":"123","a":1,"b":2,"c":3,"quality":3.0,"productionTime":20}')


@routes.route('/test')
def get_users():
    return 'User list'


@routes.route("/production")
def getProductionCalc():
    return 0
