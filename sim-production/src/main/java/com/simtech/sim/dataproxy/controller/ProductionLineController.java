package com.simtech.sim.dataproxy.controller;


import com.simtech.sim.common.utils.Result;
import com.simtech.sim.dataproxy.entity.dto.AddMachineDTO;
import com.simtech.sim.dataproxy.entity.ProductionLineEntity;
import com.simtech.sim.dataproxy.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/production/productionLine")
public class ProductionLineController {

    @Autowired
    private ProductionLineService productionLineService;


    @RequestMapping("/createLine")
    public Result<ProductionLineEntity> CreateProductionLine(@RequestBody ProductionLineEntity PL){
        productionLineService.createProductionLine(PL);
        return new Result<ProductionLineEntity>().ok(PL);
    }

    @RequestMapping("/addMachineToLine")
    public Result<AddMachineDTO> AddMachineToLine(@RequestBody AddMachineDTO addMachine){
        productionLineService.AddMachineToProductionLine(addMachine.getId(), addMachine.getMachine());
        return new Result<AddMachineDTO>().ok(addMachine);
    }



}
