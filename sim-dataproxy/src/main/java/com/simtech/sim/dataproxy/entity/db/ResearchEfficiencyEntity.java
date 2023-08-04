package com.simtech.sim.dataproxy.entity.db;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("research_eff_table")
public class ResearchEfficiencyEntity {

    @TableId
    private String id;

    private String eff_tech_id;

    private String tech_name;

}
