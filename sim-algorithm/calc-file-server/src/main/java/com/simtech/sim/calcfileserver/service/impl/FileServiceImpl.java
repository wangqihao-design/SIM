package com.simtech.sim.calcfileserver.service.impl;


import com.google.protobuf.ByteString;
import com.simtech.sim.calcfileserver.config.GrpcService;
import com.simtech.sim.calcfileserver.service.DownloadFileResponse;
import com.simtech.sim.calcfileserver.service.FileService;
import com.simtech.sim.calcfileserver.service.FileServiceGrpc;
import com.simtech.sim.calcfileserver.util.MinioUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Service
@GrpcService
public class FileServiceImpl extends FileServiceGrpc.FileServiceImplBase implements FileService {

    @Autowired
    private MinioUtils minioUtils;

    @Override
    public void downloadFile(com.simtech.sim.calcfileserver.service.DownloadFileRequest request,
                             io.grpc.stub.StreamObserver<com.simtech.sim.calcfileserver.service.DownloadFileResponse> responseObserver) {
        InputStream fileContent = minioUtils.getObject(request.getAlgorithmType(), request.getInstanceId());
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                responseObserver.onNext(com.simtech.sim.calcfileserver.service.DownloadFileResponse.newBuilder()
                        .setContent(ByteString.copyFrom(buffer, 0, bytesRead))
                        .build());
            }
        }
        catch (IOException exception){
            System.out.println("No such File");
        }
        responseObserver.onCompleted();
    }

}
