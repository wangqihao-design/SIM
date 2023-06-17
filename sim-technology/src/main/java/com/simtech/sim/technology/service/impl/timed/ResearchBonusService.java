package com.simtech.sim.technology.service.impl.timed;

import com.simtech.sim.common.utils.Result;
import com.simtech.sim.technology.config.mq.connection.RabbitMQConnectionPool;
import com.simtech.sim.technology.entity.param.ResearchParamEntity;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ResearchBonusService implements Job {

    @Autowired
    private RabbitMQConnectionPool connectionPool;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }

    public Result ResearchAdder(ResearchParamEntity params) throws SchedulerException {


        String period = "0/20 * * * * ?";

        JobDataMap map = new JobDataMap();

        JobDetail job = JobBuilder.newJob(ResearchBonusService.class)
                .setJobData(map).build();

        // initialize scheduler and the trigger
        // 获取scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("name", "production")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(period))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        return null;
    }

}
