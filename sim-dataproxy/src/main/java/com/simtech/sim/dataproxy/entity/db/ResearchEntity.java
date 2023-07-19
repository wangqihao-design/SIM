package com.simtech.sim.dataproxy.entity.db;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("research_table")
public class ResearchEntity {

    @TableId("stuff_id")
    private String stuff_id;
    private String research_id;
}
