package com.simtech.sim.backpack.dto;

import com.simtech.sim.backpack.entity.CommonEntity;

import com.simtech.sim.backpack.entity.InventoryEntity;
import lombok.Data;
import lombok.Generated;

import java.util.List;
import java.io.Serializable;


@Data
public class CommonDTO implements Serializable {
    @Generated
    private String teamId;

    private List<CommonEntity> players;

    private List<CommonEntity> productionLine;

    private List<CommonEntity> mine;

    private List<CommonEntity> technology;

    private InventoryEntity inventory;
}
