package com.simtech.sim.production.service.impl;

import com.simtech.sim.production.utils.equations.basicEquation;
import com.simtech.sim.production.service.ProductionCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO 公式需要解释清楚

@Service
public class ProductionCalculationImpl implements ProductionCalculation {

    @Autowired
    public basicEquation basicEquation;

    // Mode Productivity
    public double MP(double x, double u, double l, double a, double w){
        return basicEquation.modSig(x, u, l , a, w);
    }

    // IDE Individual production enthusiasm
    public double IDE(double k, double x, double u, double l, double a, double w){
        return k * this.MP(x, u, l ,a ,w);
    }
}

