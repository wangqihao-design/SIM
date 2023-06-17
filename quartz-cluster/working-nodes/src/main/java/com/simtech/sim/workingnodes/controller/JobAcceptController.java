package com.simtech.sim.workingnodes.controller;


import com.simtech.sim.workingnodes.entity.JobInfoEntity;
import com.simtech.sim.workingnodes.service.impl.JobExecutorServiceImpl;
import com.simtech.sim.quartzclustercommon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JobAccepter")
public class JobAcceptController {

    @Autowired
    private JobExecutorServiceImpl jobExecutorService;

    @RequestMapping("/workingThreads")
    public void getWorkingThreads(){

    }


    @RequestMapping("/newJob")
    public Result<JobInfoEntity> addJob(@RequestBody JobInfoEntity jobInfo){

        return new Result<JobInfoEntity>().ok(jobInfo);
    }
}
