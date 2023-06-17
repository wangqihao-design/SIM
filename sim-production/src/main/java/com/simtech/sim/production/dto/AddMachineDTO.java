package com.simtech.sim.production.dto;

import com.simtech.sim.production.entity.MachineEntity;
import lombok.Data;

import java.util.List;
import java.io.Serializable;


@Data
public class AddMachineDTO implements Serializable {
    private String id;
    private List<MachineEntity> machine;

}
