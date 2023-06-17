package com.simtech.sim.trade.controller;


import com.simtech.sim.common.utils.Result;
import com.simtech.sim.trade.entity.TradeEntity;
import com.simtech.sim.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/trade")
public class TradeRequestController {

    @Autowired
    private TradeService tradeService;

    @RequestMapping("/submitRequest")
    public Result<TradeEntity> SubmitTradeRequests(@RequestBody TradeEntity trade){
        tradeService.SubmitTradeRequests(trade);
        return new Result<TradeEntity>().ok(trade);
    }

    @RequestMapping("/acceptRequest")
    public void AcceptTradeRequests(){

    }

}
