package com.simtech.sim.workingnodes.controller;


import com.simtech.sim.workingnodes.WorkingNodesApplication;
import com.simtech.sim.workingnodes.entity.JobInfoEntity;
import com.simtech.sim.workingnodes.service.impl.JobExecutorServiceImpl;
import com.simtech.sim.quartzclustercommon.utils.Result;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/JobAccepter")
public class JobAcceptController {

    @Autowired
    private JobExecutorServiceImpl jobExecutorService;

    private static final Logger log = getLogger(WorkingNodesApplication.class);


    @RequestMapping("/workingThreads")
    public void getWorkingThreads(){

    }


    @RequestMapping("/addJob")
    public Result<JobInfoEntity> addJob(@RequestBody JobInfoEntity jobInfo) throws SchedulerException {

        log.info("Job instance " + jobInfo.getJobName() + " received" + jobInfo.toString());

        jobExecutorService.jobExecutionHelper(jobInfo);

        return new Result<JobInfoEntity>().ok(jobInfo);
    }
}
