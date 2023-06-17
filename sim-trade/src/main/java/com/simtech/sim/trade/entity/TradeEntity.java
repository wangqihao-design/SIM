package com.simtech.sim.trade.entity;

import com.simtech.sim.trade.dto.CommonDTO;
import com.simtech.sim.trade.entity.feign.InventoryEntity;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.*;

@Data
public class TradeEntity implements Serializable {

    public TradeEntity(){
        this.id = java.util.UUID.randomUUID().toString();
    }
    @Id
    private String id;

    private String teamAId; // seller
    private String teamBId; // buyer

    private CommonDTO tradeInfo; // tradeStuff

    private Double tradePrice;

}
