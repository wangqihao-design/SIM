package com.simtech.sim.mainnode.service.impl;


import com.simtech.sim.mainnode.entity.JobReceiverEntity;
import com.simtech.sim.quartzclustercommon.utils.DefaultMQMessageProcess;
import org.springframework.stereotype.Service;

@Service
public class JobInfoAccepter {

    private final DefaultMQMessageProcess<JobReceiverEntity, Object> sender = new DefaultMQMessageProcess<>();

}


// cluster A -> cluster B  -> cluster A
//           MQ            MQ