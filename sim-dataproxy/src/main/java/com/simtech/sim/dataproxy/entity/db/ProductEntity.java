package com.simtech.sim.dataproxy.entity.db;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_table")
public class ProductEntity {

    @TableId("stuff_id")
    private String stuff_id;

    private String product_id;
}
