package com.simtech.sim.dataproxy.service.receiver.impl;

import com.google.gson.Gson;
import com.simtech.sim.dataproxy.entity.JobInfoEntity;
import com.simtech.sim.dataproxy.entity.JobInfoTable;
import com.simtech.sim.dataproxy.service.db.JobInfoStorage;
import com.simtech.sim.dataproxy.service.internalcall.InternalCallService;
import com.simtech.sim.dataproxy.service.internalcall.impl.InternalCallServiceImpl;
import com.simtech.sim.dataproxy.service.receiver.ReceiverProxy;
import org.quartz.Job;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;


@Service
public class ReceiverProxyImpl implements ReceiverProxy {

    private final Gson gson = new Gson();

    @Autowired
    private InternalCallService internalCallService;

    @Autowired
    private JobInfoStorage jobInfoStorage;

    @RabbitHandler
    @RabbitListener(queues = "receiver")
    @Override
    public void receiveConnection(byte[] body) {

        String response = new String(body, StandardCharsets.UTF_8);


        System.out.println(response);

        JobInfoEntity job = gson.fromJson(response, JobInfoEntity.class);


        JobInfoTable jobInfoTable = jobInfoStorage.getById(job.getTeamId());
        if(jobInfoTable.getAddStuffId().contains("m")){
            internalCallService.addMine(jobInfoTable.getAddStuffId());
        }
        else if(jobInfoTable.getAddStuffId().contains("p")){
            internalCallService.addProduct(jobInfoTable.getAddStuffId());
        }
        else if(jobInfoTable.getAddStuffId().contains("r")){
            internalCallService.addResearch(jobInfoTable.getAddStuffId());
        }
        else{
            System.out.println("invalid Id");
        }

        internalCallService.addMine(job.getTeamId());

    }
}
