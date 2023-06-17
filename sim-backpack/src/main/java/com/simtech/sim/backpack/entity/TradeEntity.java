package com.simtech.sim.backpack.entity;

import com.simtech.sim.backpack.dto.CommonDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TradeEntity implements Serializable {

    public TradeEntity(){
        this.id = UUID.randomUUID().toString();
    }
    @Id
    private String id;

    private String teamAId;
    private String teamBId;

    private CommonDTO tradeInfo; // tradeStuff

    private Double tradePrice;
}
