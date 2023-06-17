package com.simtech.sim.mine.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Charlie wan2901@dcds.edu
 * @since 1.0.0 2023-03-09
 */
@Data
@ApiModel(value = "")
public class SourceMaterialDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原料id")
    private Long id;

    @ApiModelProperty(value = "原料名称")
    private String name;

    @ApiModelProperty(value = "原料品质【0-错误 1-顶级 2-高级 3-中级 4-低级 5-差】")
    private Integer quality;

    @ApiModelProperty(value = "生产需要的时间(s)")
    private Long produceTime;


}