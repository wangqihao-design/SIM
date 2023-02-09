package com.simtech.sim.operator.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;


@Data
public class EventEntity implements Serializable {

    private Date eventDate;

    private String eventName;

    private String eventDescription;

    private Boolean status;

}
