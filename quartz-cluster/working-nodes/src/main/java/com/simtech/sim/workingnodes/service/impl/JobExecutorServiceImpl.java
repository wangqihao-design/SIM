package com.simtech.sim.workingnodes.service.impl;

import com.simtech.sim.workingnodes.service.JobExecutorService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class JobExecutorServiceImpl implements Job, JobExecutorService {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }


    public void jobExecutionHelper(String period, String name) throws SchedulerException {

        JobDataMap map = new JobDataMap();


        JobDetail job = JobBuilder.newJob(JobExecutorServiceImpl.class)
                .setJobData(map).build();

        // initialize scheduler and the trigger
        // 获取scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(name, "production")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(period))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();
    }

}
