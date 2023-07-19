package com.simtech.sim.dataproxy.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "ProductionLine")
public class ProductionLineEntity implements Serializable {

    public ProductionLineEntity(){
        this.id = java.util.UUID.randomUUID().toString(); // 自动生成唯一id
    }
    @Id
    private String id;

    private String ownerId;
    private String name;
    private List<MachineEntity> Machines;
}
