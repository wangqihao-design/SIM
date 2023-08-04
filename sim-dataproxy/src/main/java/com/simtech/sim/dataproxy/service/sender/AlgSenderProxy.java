package com.simtech.sim.dataproxy.service.sender;

import com.simtech.sim.dataproxy.entity.alg.AlgRequestEntity;
import com.simtech.sim.dataproxy.entity.alg.AlgResponseEntity;

public interface AlgSenderProxy {
    AlgResponseEntity getResult(AlgRequestEntity requestParam);

}
