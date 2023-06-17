package com.simtech.sim.production.controller;


import com.simtech.sim.common.utils.Result;
import com.simtech.sim.production.entity.param.ProductionParamEntity;
import com.simtech.sim.production.service.impl.efficiency.EfficiencyCalculator;
import com.simtech.sim.production.service.impl.timer.ProductionJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simtech.sim.common.utils.R;


@RestController


@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionJob productionJob;

    @Autowired
    private EfficiencyCalculator efficiencyCalculator;


    @RequestMapping("/test")
    public Result test() throws Exception {
        ProductionParamEntity param = new ProductionParamEntity();
        param.setA(1);
        param.setB(1);
        efficiencyCalculator.production(param);

        return null;
    }
}
