package com.simtech.sim.dataproxy.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 生产时间表
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-08 20:54:09
 */
@Data
@TableName("pms_product")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 创建时间
     */
    private String name;
    /**
     * HH:MM:SS
     */
    private String productionTime;

}
