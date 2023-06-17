package com.simtech.sim.trade.dto;

import com.simtech.sim.trade.entity.feign.CommonEntity;
import com.simtech.sim.trade.entity.feign.InventoryEntity;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class CommonDTO implements Serializable {
    @Generated
    private String teamId;

    private List<CommonEntity> players;

    private List<CommonEntity> productionLine;

    private List<CommonEntity> mine;

    private List<CommonEntity> technology;

    private InventoryEntity inventory;


    public void removeNullVal(){
        if(productionLine == null){
            this.productionLine = new ArrayList<>();
        }

        if(mine == null){
            this.mine = new ArrayList<>();
        }

        if(technology == null){
            this.technology = new ArrayList<>();
        }

        if(inventory != null) {
            inventory.removeNullVal();
        }
    }

    public Double getMoney(){
        return this.getInventory().getMoney();
    }
}
