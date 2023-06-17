package com.simtech.sim.technology.dto;

import com.simtech.sim.technology.entity.ResearchEntity;
import lombok.Data;

import java.io.Serializable;


@Data
public class AddTechDTO implements Serializable {

    private Long parentId;
    private ResearchEntity research;
}
