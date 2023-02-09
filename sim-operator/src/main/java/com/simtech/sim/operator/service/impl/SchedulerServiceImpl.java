package com.simtech.sim.operator.service.impl;

import com.simtech.sim.operator.service.SchedulerService;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class SchedulerServiceImpl implements SchedulerService {

    private int tick = 20; // tick = 模拟时间 / 现实时间


    /*
    * 后端工程所在的真实时间
     */
    public String SystemDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String dateStr = dateFormat.format(new Date());
        return dateStr;
    }




}
