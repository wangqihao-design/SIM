package com.simtech.sim.dataproxy.service.sender.impl;

import com.google.gson.Gson;
import com.simtech.sim.dataproxy.entity.alg.AlgRequestEntity;
import com.simtech.sim.dataproxy.entity.alg.AlgResponseEntity;
import com.simtech.sim.dataproxy.service.sender.AlgSenderProxy;
import com.simtech.sim.dataproxy.utils.MQUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
@Slf4j
public class AlgSenderProxyImpl implements AlgSenderProxy {

    private final Logger logger = log;

    @Autowired
    private MQUtils<AlgRequestEntity, AlgResponseEntity> messager;

    @Override
    public AlgResponseEntity getResult(AlgRequestEntity requestParam) {
        // 创建一个 CompletableFuture 对象
        CompletableFuture<String> responseFuture = new CompletableFuture<>();
        try {
            responseFuture = messager.send(requestParam,
                    AlgResponseEntity.class,
                    "algorithm.production",
                    "production");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 等待响应结果
        String response = null;
        try {
            response = responseFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        log.info(response);
        Gson gson = new Gson();
        return gson.fromJson(response, AlgResponseEntity.class);
    }

}
