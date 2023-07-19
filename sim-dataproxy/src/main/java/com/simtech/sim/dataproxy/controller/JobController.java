package com.simtech.sim.dataproxy.controller;

import com.simtech.sim.dataproxy.entity.JobInfoEntity;
import com.simtech.sim.dataproxy.entity.JobInfoTable;
import com.simtech.sim.dataproxy.service.sender.SenderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataproxy")
public class JobController {

    @Autowired
    private SenderProxy<JobInfoEntity> sender;



    @RequestMapping("/newJob")
    public void createMiningJob(@RequestParam String stuffId, @RequestBody JobInfoTable jobInfo) throws Exception {
        JobInfoEntity jobInfoEntity = new JobInfoEntity().transferor(jobInfo, stuffId);

        sender.messageSender(jobInfoEntity);

    }


}
