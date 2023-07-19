package com.simtech.sim.dataproxy.controller;


import com.simtech.sim.common.utils.Result;
import com.simtech.sim.dataproxy.entity.param.ProductionParamEntity;
import com.simtech.sim.dataproxy.service.impl.efficiency.EfficiencyCalculator;
import com.simtech.sim.dataproxy.service.impl.timer.ProductionJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
