import grpc
import file_pb2
import file_pb2_grpc


def retrieve_file():
    channel = grpc.insecure_channel('localhost:10002')

    # 创建 gRPC 客户端存根
    stub = file_pb2_grpc.FileServiceStub(channel)

    request = file_pb2.Request()
    print(type(request))
    request.message = "1e3c"

    response = stub.loadAlgorithm(request)
