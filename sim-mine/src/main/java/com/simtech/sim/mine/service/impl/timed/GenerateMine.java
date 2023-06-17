package com.simtech.sim.mine.service.impl.timed;


import com.simtech.sim.mine.entity.basic.MineEntity;
import com.simtech.sim.mine.entity.basic.SourceEntity;
import com.simtech.sim.mine.repo.mysql.CityNameRepo;
import com.simtech.sim.mine.util.name.NameGenerator;
import com.simtech.sim.mine.util.name.NameGeneratorImpl;
import lombok.Getter;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Service
@Getter
public class GenerateMine implements Job {

    private HashSet<MineEntity> MineInfo = new HashSet<>();

    @Autowired
    private CityNameRepo cityNameRepo;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Integer bound = (Integer) jobExecutionContext.getJobDetail().getJobDataMap().get("bound");
        Integer origin = (Integer) jobExecutionContext.getJobDetail().getJobDataMap().get("origin");

        NameGenerator nameGenerator = new NameGeneratorImpl();

        for(int i=0; i<10; i++) {
            SourceEntity sourceEntity = SourceEntity.SourceFactory(origin, bound);
            CityNameRepo cityNameRepo = (CityNameRepo) jobExecutionContext.getJobDetail().getJobDataMap().get("cityRepo");
            MineEntity mineEntity = MineEntity.CreateNewMine(nameGenerator.getNewName(cityNameRepo), sourceEntity);
            MineInfo.add(mineEntity);
        }
    }

    public void MineGenerationHelper(String period) throws SchedulerException {


        JobDataMap map = new JobDataMap();

        map.put("bound", 5);
        map.put("origin", 1);
        map.put("cityRepo", cityNameRepo);
        JobDetail job = JobBuilder.newJob(GenerateMine.class)
                .setJobData(map).build();



        // initialize scheduler and the trigger
        // 获取scheduler对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("generationService", "MineGeneration")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(period))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();
    }

}
