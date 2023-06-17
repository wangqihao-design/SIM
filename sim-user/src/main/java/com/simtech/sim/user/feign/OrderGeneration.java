package com.simtech.sim.user.feign;


import com.simtech.sim.common.utils.R;
import com.simtech.sim.user.entity.OrderinfoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("sim-order")
public interface OrderGeneration {

    @RequestMapping("order/orderinfo/save")
    R save(@RequestBody OrderinfoEntity orderinfo);
}
