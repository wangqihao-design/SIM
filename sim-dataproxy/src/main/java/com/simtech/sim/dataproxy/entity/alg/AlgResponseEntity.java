package com.simtech.sim.dataproxy.entity.alg;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class AlgResponseEntity {

    public AlgResponseEntity(){
        this.responseTime = Calendar.getInstance().getTime();
    }

    private String applicationId;
    private Date responseTime;
    private String response;


}
