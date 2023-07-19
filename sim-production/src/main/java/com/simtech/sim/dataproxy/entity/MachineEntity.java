package com.simtech.sim.dataproxy.entity;


import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class MachineEntity implements Serializable {

    @Id @Generated
    private String id;

    private String machineName;

    private Integer workersOnLine;

    private List<Map<String ,Integer>> ResourcePerProduct;
}
