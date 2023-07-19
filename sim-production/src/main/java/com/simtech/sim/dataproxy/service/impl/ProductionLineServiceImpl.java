package com.simtech.sim.dataproxy.service.impl;

import com.simtech.sim.dataproxy.entity.MachineEntity;
import com.simtech.sim.dataproxy.entity.ProductionLineEntity;
import com.simtech.sim.dataproxy.feign.backpack.BackPackService;
import com.simtech.sim.dataproxy.repo.mongo.ProductionLineRepository;
import com.simtech.sim.dataproxy.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductionLineServiceImpl implements ProductionLineService {

    private final ProductionLineRepository Repository;

    @Autowired
    public ProductionLineServiceImpl(ProductionLineRepository Repository) {
        this.Repository = Repository;
    }

    @Autowired
    private BackPackService backPackService;

    @Override
    public ProductionLineEntity createProductionLine(ProductionLineEntity PL) {
        // addProductionLine.AddProductionLine(new CreateLineDTO(Long.parseLong(PL.getOwnerId()), PL.getId()));
        if(PL.getId() == null){
            PL.setMachines(new ArrayList<>());
        }
        return Repository.save(PL);
    }

    @Override
    public List<ProductionLineEntity> getAllProductionLine() {
        return Repository.findAll();
    }

    @Override
    public Optional<ProductionLineEntity> getProductionLineById(String id) {
        return Repository.findById(id);
    }

    @Override
    public void deleteProductionLineById(String id) {
        Repository.deleteById(id);
    }

    @Override
    public void AddMachineToProductionLine(String PLid, List<MachineEntity> machines) {
        Optional<ProductionLineEntity> productEntityOptional = Repository.findById(PLid);
        if (productEntityOptional.isPresent()) {
            ProductionLineEntity product = productEntityOptional.get();
            List<MachineEntity> existingMachines = product.getMachines();
            if (existingMachines != null) {
                existingMachines.addAll(machines);
            } else {
                product.setMachines(machines);
            }
            Repository.save(product);
        } else {
            System.out.println("Product not found for id: " + PLid);
        }
    }


}

