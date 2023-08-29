package com.simtech.sim.workingnodes.service.impl;

import com.simtech.sim.quartzclustercommon.entity.SchedulerMetaDataCopier;
import com.simtech.sim.workingnodes.feign.StatusSender;
import com.simtech.sim.workingnodes.service.JobExecutionMonitor;
import com.simtech.sim.workingnodes.service.ReportingService;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private JobExecutionMonitor monitor;
    
    @Autowired 
    private StatusSender sender;

    public String pushThreadStatus(){
        SchedulerMetaDataCopier threads = null;
        try {
            threads = monitor.getWorkingThread();
        }
        catch (SchedulerException exception){
            exception.printStackTrace();
        }
        return sender.getStatus(threads);



    }
}
