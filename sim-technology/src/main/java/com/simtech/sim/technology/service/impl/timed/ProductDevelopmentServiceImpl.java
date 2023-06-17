package com.simtech.sim.technology.service.impl.timed;


import com.simtech.sim.technology.entity.ProductEntity;
import com.simtech.sim.technology.service.impl.algorithm.EfficiencyCalculator;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductDevelopmentServiceImpl implements Job {

    @Autowired
    private EfficiencyCalculator efficiencyCalculator;

    public static List<ProductEntity> researchPool;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }


    public void productDevelopHelper(String period) throws SchedulerException {




        JobDataMap map = new JobDataMap();

        JobDetail job = JobBuilder.newJob(ProductDevelopmentServiceImpl.class)
                .setJobData(map).build();

        // initialize scheduler and the trigger
        // 获取scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("researchService", "Product Development")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(period))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

    }
}
