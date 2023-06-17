package com.simtech.sim.workingnodes.service;

import org.quartz.SchedulerException;

public interface JobExecutorService {
    void jobExecutionHelper(String period, String name) throws SchedulerException;
}
