package com.simtech.sim.dataproxy.service.internalcall.impl;

import com.simtech.sim.dataproxy.entity.JobInfoTable;
import com.simtech.sim.dataproxy.entity.db.MineEntity;
import com.simtech.sim.dataproxy.entity.db.ProductEntity;
import com.simtech.sim.dataproxy.entity.db.ResearchEntity;
import com.simtech.sim.dataproxy.service.db.JobInfoStorage;
import com.simtech.sim.dataproxy.service.db.MineStorage;
import com.simtech.sim.dataproxy.service.db.ProductStorage;
import com.simtech.sim.dataproxy.service.db.ResearchStorage;
import com.simtech.sim.dataproxy.service.internalcall.InternalCallService;
import com.simtech.sim.dataproxy.service.internalcall.feign.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InternalCallServiceImpl implements InternalCallService {


    @Autowired
    private BackpackService backpackService;

    @Autowired
    private JobInfoStorage jobInfoStorage;

    @Autowired
    private ProductStorage productStorage;

    @Autowired
    private MineStorage mineStorageImpl;

    @Autowired
    private ResearchStorage researchStorage;

    @Override
    public void addMine(String id){

        System.out.println(id);
        JobInfoTable jobInfoTable = jobInfoStorage.getById(id);

        String addStuffId = jobInfoTable.getAddStuffId();

        System.out.println(addStuffId);
        MineEntity stuff = mineStorageImpl.getById(addStuffId);

        System.out.println(stuff);

    }

    @Override
    public void addProduct(String id) {
        JobInfoTable jobInfoTable = jobInfoStorage.getById(id);

        String addStuffId = jobInfoTable.getAddStuffId();

        ProductEntity product = productStorage.getById(addStuffId);

        System.out.println(product);

    }

    @Override
    public void addResearch(String id) {

        JobInfoTable jobInfoTable = jobInfoStorage.getById(id);

        String addStuffId = jobInfoTable.getAddStuffId();

        ResearchEntity research = researchStorage.getById(addStuffId);

        System.out.println(research);
    }

}
