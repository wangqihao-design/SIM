package com.simtech.sim.workingnodes.service;

import com.simtech.sim.quartzclustercommon.entity.SchedulerMetaDataCopier;
import org.quartz.SchedulerException;


public interface JobExecutionMonitor {

    SchedulerMetaDataCopier getWorkingThread() throws SchedulerException;

}
