package com.simtech.sim.workingnodes.feign;

import com.simtech.sim.quartzclustercommon.entity.SchedulerMetaDataCopier;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerMetaData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "quartz-main-node")
public interface StatusSender {
    @RequestMapping("/WorkingNodeStatus/getStatus")
    String getStatus(@RequestBody SchedulerMetaDataCopier contextList);
}
