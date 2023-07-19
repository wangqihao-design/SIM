package com.simtech.sim.dataproxy.entity.db;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;



@Data

@TableName("mine_table")
public class MineEntity implements Serializable {

    @TableId("stuff_id")
    private String stuff_id;

    private int a;
    private int b;
    private int c;

}
