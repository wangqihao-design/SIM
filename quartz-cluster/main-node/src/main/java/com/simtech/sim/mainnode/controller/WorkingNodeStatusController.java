package com.simtech.sim.mainnode.controller;


import com.simtech.sim.quartzclustercommon.entity.SchedulerMetaDataCopier;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerMetaData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/WorkingNodeStatus")
@Slf4j
public class WorkingNodeStatusController {

    @RequestMapping("/getStatus")
    public String getStatus(@RequestBody SchedulerMetaDataCopier metaData){
        System.out.println(metaData.toString());
        return "ok";
    }

}
