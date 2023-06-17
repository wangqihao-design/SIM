package com.simtech.sim.technology.service.impl.algorithm;

import com.simtech.sim.technology.util.DefaultMQMessageProcess;
import com.simtech.sim.technology.config.mq.connection.RabbitMQConnectionPool;
import com.simtech.sim.technology.entity.param.ResearchParamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class EfficiencyCalculator {

    @Autowired
    private RabbitMQConnectionPool connectionPool;

    @Autowired
    private DefaultMQMessageProcess defaultClient;


    public void bonusResearchEfficiencyGrabber(ResearchParamEntity param) throws Exception {
    }



}
