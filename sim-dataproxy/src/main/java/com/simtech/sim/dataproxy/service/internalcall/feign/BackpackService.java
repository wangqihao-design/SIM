package com.simtech.sim.dataproxy.service.internalcall.feign;

import com.simtech.sim.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("sim-backpack")
public interface BackpackService {
    @RequestMapping("/backpack/productionLine/findLineOwner")
    Result FindLineOwner(Long productionLineId);
}
