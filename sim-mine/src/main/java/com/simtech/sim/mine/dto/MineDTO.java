package com.simtech.sim.mine.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * @author Charlie wan2901@dcds.edu
 * @since 1.0.0 2023-03-09
 */
@Data
@ApiModel(value = "")
public class MineDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "矿井id")
    private Long id;

    @ApiModelProperty(value = "矿井名称")
    private String name;

    @ApiModelProperty(value = "产出物品1")
    private String productid1;

    @ApiModelProperty(value = "产出物品2")
    private String productid2;

    @ApiModelProperty(value = "产出物品3【最多产出3种，不够再改】")
    private String productid3;

    @ApiModelProperty(value = "矿井价格")
    private BigDecimal cost;

    @ApiModelProperty(value = "矿井位置")
    private String location;

    @ApiModelProperty(value = "所有公司的id")
    private long OwnerId;

}