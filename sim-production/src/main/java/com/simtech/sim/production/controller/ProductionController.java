package com.simtech.sim.production.controller;


import com.simtech.sim.production.service.ProductionCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simtech.sim.common.utils.R;


@RestController


@RequestMapping("/production")
public class ProductionController {
    @Autowired
    private ProductionCalculation productionCalculation;


    // 测试openfeign调用
    @RequestMapping("/update")
    public R testUpdate(){
        return R.ok().put("",1);
    }

}
