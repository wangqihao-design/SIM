package com.simtech.sim.trade.service.impl;

import com.google.gson.Gson;
import com.simtech.sim.trade.dto.CommonDTO;
import com.simtech.sim.trade.entity.TradeEntity;
import com.simtech.sim.trade.entity.feign.InventoryEntity;
import com.simtech.sim.trade.feign.BackpackService;
import com.simtech.sim.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private BackpackService backpackService;

    private final StringRedisTemplate stringRedisTemplate;

    private final Gson gson = new Gson();

    @Autowired
    public TradeServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    @Transactional
    public void AcceptRequests(String id) {
        String json = stringRedisTemplate.opsForValue().get(id);
        TradeEntity tradeEntity = gson.fromJson(json, TradeEntity.class);

        System.out.println(json);
        System.out.println(tradeEntity);
        backpackService.moneyOperator(tradeEntity.getTeamAId(), tradeEntity.getTradePrice());
        backpackService.moneyOperator(tradeEntity.getTeamBId(), - tradeEntity.getTradePrice());

        if(tradeEntity.getTradeInfo().getInventory() == null){
            tradeEntity.getTradeInfo().setInventory(new InventoryEntity());
        }
        backpackService.generalRemoveController(tradeEntity.getTeamAId(), tradeEntity.getTradeInfo());
        backpackService.generalAdditionController(tradeEntity.getTeamBId(), tradeEntity.getTradeInfo());

        System.out.println("order generated and saved");
    }

    @Override
    public void SubmitTradeRequests(TradeEntity trade) {

        String json = gson.toJson(trade);
        stringRedisTemplate.opsForValue().append(trade.getId(), json);
    }


    @Override
    public void testService(){

        InventoryEntity inventory = new InventoryEntity();

        inventory.setA(1);
        inventory.setB(2);
        inventory.setC(3);

        inventory.setMoney(20D);

        List<Object[]> products = new ArrayList<>();
        products.add(new Object[]{"3245", "Car2", 10});
        inventory.setProducts(products);

        backpackService.addInventory("83243089-c2e7-484c-a883-90fe9ad30641", inventory);
    }
}
