package com.simtech.sim.dataproxy.service.sender;


import com.simtech.sim.common.utils.Result;

public interface QuartzSenderProxy<M> {

    void messageSender(M message) throws Exception;
}
