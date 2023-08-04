package com.simtech.sim.dataproxy.entity.db;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("research_recipe_table")
public class ResearchRecipeEntity {

    @TableId("stuff_id")
    private String stuff_id;
    private String research_id;
}
