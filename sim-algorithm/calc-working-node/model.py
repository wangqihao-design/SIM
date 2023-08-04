import time

import grpc
import File_pb2
import File_pb2_grpc
import fcntl

import importlib


def download_file(instanceId, algType):

    # 创建gRPC channel
    channel = grpc.insecure_channel("localhost:50051")

    # 创建gRPC stub
    stub = File_pb2_grpc.FileServiceStub(channel)

    # 创建请求消息
    request = File_pb2.DownloadFileRequest()
    request.InstanceId = instanceId
    request.algorithmType = algType

    # 调用下载文件方法
    response_iterator = stub.DownloadFile(request)
    # file = open('temp.py', 'wb')
    # fd = file.fileno()

    # 获取文件锁
    # fcntl.flock(fd, fcntl.LOCK_EX)

    # for response in response_iterator:
    #    file.write(response.Content)

    # 释放文件锁
    # fcntl.flock(fd, fcntl.LOCK_UN)
    # file.close()

    return response_iterator


def DynamicLoader(response_iterator):
    # importlib.import_module("temp")
    print(type(response_iterator))
    return


def DownloadAndLoad(instanceId, algType):
    res = download_file(instanceId, algType)
    code_block = ""
    scope = {}
    for response in res:
        code_block += response.Content.decode()
    exec(code_block, scope)
    response = scope['result']
    return response
