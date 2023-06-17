package com.simtech.sim.backpack.entity;


import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;


@Data
@Document("playerInfo")
public class TeamEntity {

    public TeamEntity(){
        this.id = java.util.UUID.randomUUID().toString();
    }

    @Id
    private String id;

    private String TeamName;

    private List<CommonEntity> players;

    private List<CommonEntity> productionLine;

    private List<CommonEntity> mine;

    private List<CommonEntity> technology;

    private InventoryEntity inventory;
}
