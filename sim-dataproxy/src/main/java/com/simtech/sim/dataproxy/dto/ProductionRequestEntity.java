package com.simtech.sim.dataproxy.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class ProductionRequestEntity implements Serializable {
    private Long id;
    // CommandID 1 : start production
    // CommandID 2 : cancel production
    // CommandID 3 : pause production
    private Double employeeRatioConfig;
    private Integer commandId;
    private Integer productionLimit;
    private Integer dailyManagementCost;

}
/*
▪	当前员工数量
        ▪	输入 员工数量占比配置（增减）
        ▪	每日产量
        ▪	输入 产能限制（由员工数量及其效率决定）
        ▪	输入 每日最高产量（在产能限制下）
        ▪	输入 每日管理费用
*/
