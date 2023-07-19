package com.simtech.sim.dataproxy.entity.dto;

import com.simtech.sim.dataproxy.entity.MachineEntity;
import lombok.Data;

import java.util.List;
import java.io.Serializable;


@Data
public class AddMachineDTO implements Serializable {
    private String id;
    private List<MachineEntity> machine;

}
