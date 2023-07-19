package com.simtech.sim.dataproxy;


import com.simtech.sim.dataproxy.controller.ProductionLineController;
import com.simtech.sim.dataproxy.entity.dto.AddMachineDTO;
import com.simtech.sim.dataproxy.entity.MachineEntity;
import com.simtech.sim.dataproxy.entity.ProductionLineEntity;
import com.simtech.sim.dataproxy.entity.param.ProductionParamEntity;
import com.simtech.sim.dataproxy.service.ProductionLineService;
import com.simtech.sim.dataproxy.service.impl.efficiency.EfficiencyCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import java.util.ArrayList;

@SpringBootTest

public class SimProductionApplicationTests {

    @Autowired
    private ProductionLineController productionLineController;

    @Autowired
    private ProductionLineService productionLineService;

    @Test

    public void initialize(){
        ProductionLineEntity productionLine = new ProductionLineEntity();
        productionLine.setName("Car ProductionLine");
        productionLine.setId("1");

        // create Machine
        MachineEntity m1 = new MachineEntity();
        m1.setMachineName("Car1");
        m1.setId("2");

        List<MachineEntity> machineEntityList = new ArrayList<>();
        machineEntityList.add(m1);
        productionLine.setMachines(machineEntityList);

        productionLineController.CreateProductionLine(productionLine);


    }

    @Test

    public void AddMachine() {
        AddMachineDTO addMachineDTO = new AddMachineDTO();
        addMachineDTO.setId("1");

        MachineEntity m2 = new MachineEntity();
        m2.setMachineName("Car2");
        m2.setId("3");
        List<MachineEntity> machineList = new ArrayList<>();
        machineList.add(m2);

        addMachineDTO.setMachine(machineList);

        productionLineController.AddMachineToLine(addMachineDTO);
    }


    @Autowired
    private EfficiencyCalculator calculator;

    @Test
    public void mq() throws Exception {
        ProductionParamEntity param = new ProductionParamEntity();

        param.setA(1);
        param.setB(1);
        calculator.production(param);
    }

    @Test
    public void addProductionLine(){

        ProductionLineEntity pl = new ProductionLineEntity();
        pl.setName("Plane Production Line");
        pl.setOwnerId("2");
        pl.setId("4");
        pl.setMachines(new ArrayList<MachineEntity>());
        productionLineController.CreateProductionLine(pl);
    }


}
