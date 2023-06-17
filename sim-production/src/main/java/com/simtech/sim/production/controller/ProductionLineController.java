package com.simtech.sim.production.controller;


import com.google.gson.Gson;
import com.simtech.sim.common.utils.R;
import com.simtech.sim.common.utils.Result;
import com.simtech.sim.production.dto.AddMachineDTO;
import com.simtech.sim.production.entity.MachineEntity;
import com.simtech.sim.production.entity.ProductionLineEntity;
import com.simtech.sim.production.entity.param.ProductionParamEntity;
import com.simtech.sim.production.service.ProductionLineService;
import com.simtech.sim.production.service.impl.efficiency.EfficiencyCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
