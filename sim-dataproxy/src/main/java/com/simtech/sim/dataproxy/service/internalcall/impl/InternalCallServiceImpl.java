package com.simtech.sim.dataproxy.service.internalcall.impl;

import com.simtech.sim.dataproxy.service.db.JobInfoStorage;
import com.simtech.sim.dataproxy.service.db.ProductStorage;
import com.simtech.sim.dataproxy.service.db.ResearchStorage;
import com.simtech.sim.dataproxy.service.internalcall.InternalCallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalCallServiceImpl implements InternalCallService {


    @Autowired
    private JobInfoStorage jobInfoStorage;

    @Autowired
    private ProductStorage productStorage;

    @Autowired
    private ResearchStorage researchStorage;


    @Override
    public void addMine(String id){

        log.info(String.format("addMine %s Triggered", id));

    }

    @Override
    public void addProduct(String id) {
        log.info(String.format("add Product %s Triggered", id));


    }

    @Override
    public void addResearch(String id) {

        log.info(String.format("addResearch %s Triggered", id));

    }

}
