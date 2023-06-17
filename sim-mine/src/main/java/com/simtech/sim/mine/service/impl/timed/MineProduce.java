package com.simtech.sim.mine.service.impl.timed;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MineProduce implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }


    public void ProductionHelper(String period) throws SchedulerException {

        JobDataMap map = new JobDataMap();

        JobDetail job = JobBuilder.newJob(GenerateMine.class)
                .setJobData(map).build();

        // initialize scheduler and the trigger
        // 获取scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("Produce", "MineProduction")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(period))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();
    }
}
