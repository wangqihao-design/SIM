package com.simtech.sim.dataproxy.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class StaffRequestEntity implements Serializable {
    private double MonthlyTrainingCost;
    private double AverageSalary;
    private int StaffNum;
}
