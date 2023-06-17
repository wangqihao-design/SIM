package com.simtech.sim.technology.entity;


import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
public class ProductEntity {

    @Id @Generated
    private Long id;

    private ComponentEntity components;

    private Double quality;

    private String productionTime;
}
