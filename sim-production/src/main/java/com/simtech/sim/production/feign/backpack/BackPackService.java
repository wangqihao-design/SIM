package com.simtech.sim.production.feign.backpack;

import com.simtech.sim.common.utils.Result;
import com.simtech.sim.production.dto.backpack.CreateLineDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "sim-backpack", url = "127.0.0.1:8091")
public interface BackPackService {
    @RequestMapping("/backpack/productionLine")
    Result AddProductionLine(@RequestBody CreateLineDTO line);

    @RequestMapping("/backpack/productionLine/findLineOwner")
    Result FindLineOwner(Long productionLineId);
}
