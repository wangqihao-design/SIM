package com.simtech.sim.dataproxy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class JobInfoEntity {

    public JobInfoEntity(){
        this.jobName = UUID.randomUUID().toString();
    }

    private String period;
    private String group;
    private String jobName;
    private String teamId;

    private String jobInfo;

    @Override
    public String toString(){
        return "Job Name " + jobName + " in " + group + " with period " + period;
    }

}
