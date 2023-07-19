package com.simtech.sim.dataproxy.service;


import com.simtech.sim.dataproxy.entity.MachineEntity;
import com.simtech.sim.dataproxy.entity.ProductionLineEntity;

import java.util.List;
import java.util.Optional;

public interface ProductionLineService {

    ProductionLineEntity createProductionLine(ProductionLineEntity PL);

    List<ProductionLineEntity> getAllProductionLine();

    void deleteProductionLineById(String id);

    Optional<ProductionLineEntity> getProductionLineById(String id);

    void AddMachineToProductionLine(String PLName, List<MachineEntity> machine);
}
