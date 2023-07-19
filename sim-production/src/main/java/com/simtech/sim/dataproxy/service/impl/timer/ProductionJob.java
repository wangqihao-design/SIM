package com.simtech.sim.dataproxy.service.impl.timer;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service


public class ProductionJob implements Job {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("testing");
    }

    public void generateJobInfo(String period, String name) throws SchedulerException {

        JobDataMap map = new JobDataMap();


        JobDetail job = JobBuilder.newJob(ProductionJob.class)
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
