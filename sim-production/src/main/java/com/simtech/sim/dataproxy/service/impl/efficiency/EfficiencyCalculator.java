package com.simtech.sim.dataproxy.service.impl.efficiency;

import com.google.gson.Gson;
import com.simtech.sim.dataproxy.config.RabbitMQConnectionPool;
import com.simtech.sim.dataproxy.entity.param.ProductionParamEntity;
import com.simtech.sim.dataproxy.entity.param.ProductionResponseEntity;
import com.simtech.sim.dataproxy.repo.mongo.ProductionLineRepository;
import com.simtech.sim.dataproxy.service.impl.timer.ProductionJob;
import com.simtech.sim.dataproxy.utils.DefaultMQMessageProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class EfficiencyCalculator {

    @Autowired
    private RabbitMQConnectionPool pool;

    @Autowired
    private ProductionJob job;

    @Autowired
    private ProductionLineRepository repository;

    @Autowired
    private DefaultMQMessageProcess<ProductionParamEntity, ProductionResponseEntity> messager;


    public ProductionParamEntity getParam(Long UID){

        repository.findById("10");
        return null;
    }

    public void production(ProductionParamEntity param) throws Exception {
        CompletableFuture<ProductionResponseEntity> responseFuture = new CompletableFuture<>();

        messager.send(param, ProductionResponseEntity.class, "algorithm.production", "production", responseFuture);
        String message = messager.getResponse();
        Gson gson = new Gson();
        ProductionResponseEntity res = gson.fromJson(message, ProductionResponseEntity.class);
        job.generateJobInfo(res.getPeriod(), res.getName());
    }
}
