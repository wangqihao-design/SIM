package com.simtech.sim.production.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.production.entity.MachineEntity;
import com.simtech.sim.production.entity.ProductionLineEntity;

import java.util.List;
import java.util.Optional;

public interface ProductionLineService {

    ProductionLineEntity createProductionLine(ProductionLineEntity PL);

    List<ProductionLineEntity> getAllProductionLine();

    void deleteProductionLineById(String id);

    Optional<ProductionLineEntity> getProductionLineById(String id);

    void AddMachineToProductionLine(String PLName, List<MachineEntity> machine);
}
