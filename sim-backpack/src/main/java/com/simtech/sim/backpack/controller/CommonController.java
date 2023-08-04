package com.simtech.sim.backpack.controller;

import com.simtech.sim.backpack.dto.CommonDTO;
import com.simtech.sim.backpack.entity.CommonEntity;
import com.simtech.sim.backpack.entity.InventoryEntity;
import com.simtech.sim.backpack.entity.ProductEntity;
import com.simtech.sim.backpack.entity.TradeEntity;
import com.simtech.sim.backpack.service.CommonService;
import com.simtech.sim.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/backpack/")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/addPlayerToTeam")
    public Result<List<CommonEntity>> addPlayer(@RequestParam String teamId, @RequestBody List<CommonEntity> players) {
        String info = commonService.addPlayerToTeam(teamId, players);
        Result<List<CommonEntity>> res = new Result<List<CommonEntity>>().ok(players);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/addTechnologyToTeam")
    public Result<List<CommonEntity>> addTechnology(@RequestParam String teamId, @RequestBody List<CommonEntity> technology) {
        String info = commonService.addTechToTeam(teamId, technology);
        Result<List<CommonEntity>> res = new Result<List<CommonEntity>>().ok(technology);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/addProductionLineToTeam")
    public Result<List<CommonEntity>> addProductionLine(@RequestParam String teamId, @RequestBody List<CommonEntity> productionLine) {
        String info = commonService.addProductionLineToTeam(teamId, productionLine);
        Result<List<CommonEntity>> res = new Result<List<CommonEntity>>().ok(productionLine);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/addMineToTeam")
    public Result<List<CommonEntity>> addMine(@RequestParam String teamId, @RequestBody List<CommonEntity> mine) {
        String info = commonService.addMineToTeam(teamId, mine);
        Result<List<CommonEntity>> res = new Result<List<CommonEntity>>().ok(mine);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/addInventoryToTeam")
    public Result<InventoryEntity> addInventory(@RequestParam String teamId, @RequestBody InventoryEntity inventory) {
        String info = commonService.addInventoryToTeam(teamId, inventory);
        Result<InventoryEntity> res = new Result<InventoryEntity>().ok(inventory);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/removeInventoryFromTeam")
    public Result<InventoryEntity> removeInventory(@RequestParam String teamId, @RequestBody InventoryEntity inventory) {
        String info = commonService.removeInventoryFromTeam(teamId, inventory);
        Result<InventoryEntity> res = new Result<InventoryEntity>().ok(inventory);
        res.setMsg(info);
        return res;
    }

    @RequestMapping("/generalAdditionController")
    public Result<CommonDTO> generalController(@RequestParam String teamId, @RequestBody CommonDTO common){
        if(common.getMine() != null) {
            commonService.addMineToTeam(teamId, common.getMine());
        }
        if(common.getProductionLine() != null) {
            commonService.addProductionLineToTeam(teamId, common.getProductionLine());
        }
        if(common.getTechnology() != null) {
            commonService.addTechToTeam(teamId, common.getTechnology());
        }
        if(common.getInventory() != null) {
            commonService.addInventoryToTeam(teamId, common.getInventory());
        }
        return new Result<CommonDTO>().ok(common);
    }

    @RequestMapping("/generalRemoveController")
    public Result<CommonDTO> generalRemoveController(@RequestParam String teamId, @RequestBody CommonDTO common){
        if(common.getMine() != null) {
            commonService.removeMineToTeam(teamId, common.getMine());
        }
        if(common.getProductionLine() != null) {
            commonService.removeProductionLineToTeam(teamId, common.getProductionLine());
        }
        if(common.getTechnology() != null) {
            commonService.removeTechToTeam(teamId, common.getTechnology());
        }
        if(common.getInventory() != null) {
            commonService.removeInventoryToTeam(teamId, common.getInventory());
        }
        return new Result<CommonDTO>().ok(common);
    }

    @RequestMapping("/moneyOperation")
    public Result<Double> moneyOperator(@RequestParam String teamId, @RequestParam Double money){
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setMoney(money);
        inventoryEntity.setProducts(new ArrayList<ProductEntity>());
        commonService.addInventoryToTeam(teamId, inventoryEntity);

        return new Result<Double>().ok(money);
    }


}
