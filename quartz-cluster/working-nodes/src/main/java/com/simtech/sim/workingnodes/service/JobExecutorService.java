package com.simtech.sim.workingnodes.service;

import com.simtech.sim.workingnodes.entity.JobInfoEntity;
import org.quartz.SchedulerException;

public interface JobExecutorService {
    void jobExecutionHelper(JobInfoEntity jobInfoEntity) throws SchedulerException;
}
