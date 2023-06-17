package com.simtech.sim.dataproxy.service.sender;


import com.simtech.sim.common.utils.Result;

public interface SenderProxy<T, M> {

    Result<T> messageSender(M message) throws Exception;
}
