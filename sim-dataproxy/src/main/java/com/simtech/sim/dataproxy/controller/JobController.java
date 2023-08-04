package com.simtech.sim.dataproxy.controller;

import com.simtech.sim.common.utils.Result;
import com.simtech.sim.dataproxy.entity.JobInfoEntity;
import com.simtech.sim.dataproxy.entity.JobInfoTable;
import com.simtech.sim.dataproxy.entity.alg.AlgRequestEntity;
import com.simtech.sim.dataproxy.entity.alg.AlgResponseEntity;
import com.simtech.sim.dataproxy.service.db.JobInfoStorage;
import com.simtech.sim.dataproxy.service.sender.AlgSenderProxy;
import com.simtech.sim.dataproxy.service.sender.QuartzSenderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataproxy")
public class JobController {

    @Autowired
    private QuartzSenderProxy<JobInfoEntity> sender;

    @Autowired
    private AlgSenderProxy algSenderProxy;

    @Autowired
    private JobInfoStorage jobInfoStorage;

    @RequestMapping("/newJob")
    public void submitJob(@RequestParam String stuffId, @RequestBody JobInfoEntity jobInfo) throws Exception {

        sender.messageSender(jobInfo);
    }

    @RequestMapping("/something")
    public void test() {
        AlgRequestEntity algRequestEntity = new AlgRequestEntity();
        algRequestEntity.setAlgType("researchset");
        algRequestEntity.setInstanceId("hello");
        
        algSenderProxy.getResult(algRequestEntity);

    }


    @RequestMapping("/calculateInstance")
    public Result<String> calculator(@RequestParam String algType, @RequestParam String instanceId){

        AlgRequestEntity algRequestEntity = new AlgRequestEntity();
        algRequestEntity.setInstanceId(instanceId);
        algRequestEntity.setAlgType(algType);

        AlgResponseEntity response = algSenderProxy.getResult(algRequestEntity);

        return new Result<String>().ok(response.getResponse());
    }



}
