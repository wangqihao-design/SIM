package com.simtech.sim.workingnodes.controller;


import com.simtech.sim.workingnodes.WorkingNodesApplication;
import com.simtech.sim.workingnodes.entity.JobInfoEntity;
import com.simtech.sim.workingnodes.service.JobExecutionMonitor;
import com.simtech.sim.workingnodes.service.JobExecutorService;
import com.simtech.sim.workingnodes.service.impl.JobExecutorServiceImpl;
import com.simtech.sim.quartzclustercommon.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@Slf4j
@RestController
@RequestMapping("/JobAccepter")
public class JobAcceptController {

    @Autowired
    private JobExecutorService jobExecutorService;

    @Autowired
    private JobExecutionMonitor monitor;

    @RequestMapping("/workingThreads")
    public void getWorkingThreads(){
        try {
            monitor.getWorkingThread();
        }
        catch (SchedulerException exception){
            log.error(exception.toString());
        }
    }


    @RequestMapping("/addJob")
    public Result<JobInfoEntity> addJob(@RequestBody JobInfoEntity jobInfo) throws SchedulerException {

        log.info("Job instance " + jobInfo.getJobName() + " received" + jobInfo.toString());

        jobExecutorService.jobExecutionHelper(jobInfo);

        return new Result<JobInfoEntity>().ok(jobInfo);
    }
}
