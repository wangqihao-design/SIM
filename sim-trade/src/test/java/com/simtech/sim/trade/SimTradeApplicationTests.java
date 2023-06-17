package com.simtech.sim.trade;

import com.simtech.sim.trade.dto.CommonDTO;
import com.simtech.sim.trade.entity.TradeEntity;
import com.simtech.sim.trade.entity.feign.CommonEntity;
import com.simtech.sim.trade.entity.feign.InventoryEntity;
import com.simtech.sim.trade.service.TradeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class SimTradeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TradeService tradeService;

    @Test
    void test(){
        tradeService.testService();
    }

    @Test
    void tradeTest(){
        tradeService.AcceptRequests("00907c0b-29b0-4ba0-ab57-06dce88060f4");
    }

    @Test
    void redisTest(){
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setTradePrice(20D);

        tradeEntity.setTeamAId("83243089-c2e7-484c-a883-90fe9ad30641");
        tradeEntity.setTeamBId("7e6c6915-ad88-4a6d-b28a-1e2e8db7bf3f");

        CommonDTO commonDTO = new CommonDTO();


        List<CommonEntity> mine = new ArrayList<>();
        CommonEntity commonEntity = new CommonEntity();
        commonEntity.setId("113223a4-8af8-492c-be8b-c1b200c239e4");
        mine.add(commonEntity);

        List<CommonEntity> PL = new ArrayList<>();
        CommonEntity commonEntity2 = new CommonEntity();
        commonEntity2.setId("eb0867b4-9a30-469a-831a-d07cfd660bdd");
        PL.add(commonEntity2);


        InventoryEntity inventoryEntity = new InventoryEntity();

        inventoryEntity.setA(1);
        inventoryEntity.setB(2);

        commonDTO.setMine(mine);
        commonDTO.setProductionLine(PL);
        commonDTO.setInventory(inventoryEntity);

        tradeEntity.setTradeInfo(commonDTO);



        tradeService.SubmitTradeRequests(tradeEntity);
    }
}
