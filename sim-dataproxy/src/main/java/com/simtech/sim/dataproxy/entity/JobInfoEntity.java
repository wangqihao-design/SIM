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

    @Override
    public String toString(){
        return "Job Name " + jobName + " in " + group + " with period " + period;
    }

    public JobInfoEntity transferor(JobInfoTable jobInfoTable, String addStuffId){
        this.period = jobInfoTable.getJobPeriod();
        this.group = jobInfoTable.getJobGroup();
        this.teamId = jobInfoTable.getId();

        return this;
    }
}
