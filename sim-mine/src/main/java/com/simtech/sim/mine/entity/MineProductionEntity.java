package com.simtech.sim.mine.entity;


import lombok.Data;

import java.text.DecimalFormat;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

@Data
public class MineProductionEntity {

    public MineProductionEntity(){
        RandomGenerator randomGenerator = RandomGeneratorFactory.getDefault().create();
        this.MineNumber = randomGenerator.nextInt(5);
        this.ProduceTime = MineNumber * 1.5 - randomGenerator.nextInt(3);
    }

    private int MineNumber;

    private Double ProduceTime;
}
