package com.simtech.sim.trade.service;

import com.simtech.sim.trade.entity.TradeEntity;

public interface TradeService {
    void AcceptRequests(String id);

    void SubmitTradeRequests(TradeEntity trade);

    void testService();
}
