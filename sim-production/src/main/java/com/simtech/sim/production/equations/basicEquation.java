package com.simtech.sim.production.equations;

import org.springframework.stereotype.Component;

@Component
public class basicEquation{
    //  1/(1 + e-x)
    public double sigmoid(double x){
        return 1/(1+Math.pow(Math.E, -x));
    }

    public double modSig(double x, double u, double l, double a, double w){
        return (u-l) * this.sigmoid((x-a)/w) + l;
    }
}