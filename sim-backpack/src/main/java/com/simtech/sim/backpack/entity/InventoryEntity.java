package com.simtech.sim.backpack.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InventoryEntity implements Serializable {


    private int a;
    private int b;
    private int c;

    private double money;

    private List<Object[]> products;


}
