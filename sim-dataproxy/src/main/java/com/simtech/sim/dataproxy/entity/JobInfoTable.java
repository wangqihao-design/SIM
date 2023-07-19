package com.simtech.sim.dataproxy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName("job_info_table")
@Data
public class JobInfoTable implements Serializable {


    private static final long serialVersionUID = 1L;

    private String id;

    private String groupId;

    private String jobPeriod;

    private String jobGroup;

    private String addStuffId;

    @Override
    public String toString() {
        return "JobInfoTable{" +
                "id=" + id +
                ", jobPeriod=" + jobPeriod +
                ", jobGroup=" + jobGroup +
                ", addStuffId=" + addStuffId +
                "}";
    }
}
