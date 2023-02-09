package com.simtech.sim.operator.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("sim-production")
public interface ProductionFeignService {

}
