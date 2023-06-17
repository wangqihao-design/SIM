package com.simtech.sim.trade.feign;

import com.simtech.sim.common.utils.Result;
import com.simtech.sim.trade.dto.CommonDTO;
import com.simtech.sim.trade.entity.feign.InventoryEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "sim-backpack", url = "127.0.0.1:8091")
public interface BackpackService {

    @RequestMapping("/backpack/addInventoryToTeam")
    Result<InventoryEntity> addInventory(@RequestParam String teamId, @RequestBody InventoryEntity inventory);

    @RequestMapping("/backpack/removeInventoryFromTeam")
    Result<InventoryEntity> removeInventory(@RequestParam String teamId, @RequestBody InventoryEntity inventory);

    @RequestMapping("/backpack/moneyOperation")
    Result<Double> moneyOperator(@RequestParam String teamId, @RequestParam Double money);

    @RequestMapping("/backpack/generalRemoveController")
    Result<CommonDTO> generalRemoveController(@RequestParam String teamId, @RequestBody CommonDTO common);

    @RequestMapping("/backpack/generalAdditionController")
    Result<CommonDTO> generalAdditionController(@RequestParam String teamId, @RequestBody CommonDTO common);

}
