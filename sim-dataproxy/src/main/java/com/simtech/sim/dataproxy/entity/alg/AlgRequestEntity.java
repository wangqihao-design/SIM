package com.simtech.sim.dataproxy.entity.alg;


import lombok.Data;

@Data
public class AlgRequestEntity {
    public AlgRequestEntity(){
        this.requestId = java.util.UUID.randomUUID().toString();
    }

    private String requestId;

    private String instanceId;

    private String algType;
}
