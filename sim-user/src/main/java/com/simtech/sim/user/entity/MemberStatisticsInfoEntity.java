package com.simtech.sim.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户资产信息
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-08 20:54:09
 */
@Data
@TableName("ums_member_statistics_info")
public class MemberStatisticsInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 总资产
     */
    private BigDecimal totalAsset;
    /**
     * 总负债
     */
    private BigDecimal totalDebt;
    /**
     * 排名
     */
    private Integer ranking;

}
