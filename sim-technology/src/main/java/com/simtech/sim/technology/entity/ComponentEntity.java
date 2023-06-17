package com.simtech.sim.technology.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Data
public class ComponentEntity implements Serializable {

    private Integer A;
    private Integer B;
    private Integer C;


}
