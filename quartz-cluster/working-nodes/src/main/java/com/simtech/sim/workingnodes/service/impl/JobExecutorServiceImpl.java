package com.simtech.sim.workingnodes.service.impl;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.simtech.sim.quartzclustercommon.entity.SchedulerMetaDataCopier;
import com.simtech.sim.workingnodes.WorkingNodesApplication;
import com.simtech.sim.workingnodes.config.mq.RabbitMQConnectionPool;
import com.simtech.sim.workingnodes.entity.JobInfoEntity;
import com.simtech.sim.workingnodes.service.JobExecutionMonitor;
import com.simtech.sim.workingnodes.service.JobExecutorService;
import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class JobExecutorServiceImpl implements Job, JobExecutorService, JobExecutionMonitor {

    @Autowired
    private RabbitMQConnectionPool rabbitMQConnectionPool;

    private static final Logger log = getLogger(WorkingNodesApplication.class);

    private final Scheduler scheduler;

    private final Gson gson = new Gson();

    public JobExecutorServiceImpl() throws Exception {

        scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
    }

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String exchange = "quartz-cluster.receiver";
        String queue = "receiver";
        String routingKey = "receiver";

        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .contentType("application/json")
                .build();

        Connection connection = rabbitMQConnectionPool.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(exchange, "direct", true);

        Object message = jobExecutionContext.getJobDetail().getJobDataMap().get("message");
        log.info(gson.toJson(message));


        channel.basicPublish(exchange, routingKey, props, gson.toJson(message).getBytes(StandardCharsets.UTF_8));

        channel.close();

        rabbitMQConnectionPool.releaseConnection(connection);
    }



    public void jobExecutionHelper(JobInfoEntity jobInfo) throws SchedulerException {
        JobDataMap map = new JobDataMap();

        map.put("message", jobInfo);



        JobDetail job = JobBuilder.newJob(JobExecutorServiceImpl.class)
                .setJobData(map).build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobInfo.getJobName(), jobInfo.getGroup())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(jobInfo.getPeriod()))
                .build();


        scheduler.scheduleJob(job, trigger);
    }


    @Override
    public SchedulerMetaDataCopier getWorkingThread() throws SchedulerException {
        return scheduler.isStarted() ? new SchedulerMetaDataCopier().copier(scheduler.getMetaData()) : null;
    }
}
