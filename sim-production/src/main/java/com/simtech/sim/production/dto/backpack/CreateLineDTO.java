package com.simtech.sim.production.dto.backpack;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLineDTO {
    private Long teamId;
    private String productionLineId;
}
