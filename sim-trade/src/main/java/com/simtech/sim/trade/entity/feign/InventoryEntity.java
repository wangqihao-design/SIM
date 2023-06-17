package com.simtech.sim.trade.entity.feign;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class InventoryEntity implements Serializable {


    private int a;
    private int b;
    private int c;

    private double money;

    private List<Object[]> products;

    public void removeNullVal(){

        if(products == null){
            this.products = new ArrayList<>();
        }
    }

}
