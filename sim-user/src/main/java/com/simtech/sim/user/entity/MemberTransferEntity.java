package com.simtech.sim.user.entity;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberTransferEntity {

    private long payerId;
    private long receiverId;

    private BigDecimal transferred;
}
