package com.simtech.sim.production.feign;

import com.simtech.sim.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sim-technology", url = "127.0.0.1:8090/findTechnology")

public interface GetResearchBonus {
    @RequestMapping("/findTechnology")
    Result GetTechnology(@RequestBody Long technology);
}