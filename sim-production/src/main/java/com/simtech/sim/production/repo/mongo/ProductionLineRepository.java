package com.simtech.sim.production.repo.mongo;

import com.simtech.sim.production.entity.ProductionLineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductionLineRepository extends MongoRepository<ProductionLineEntity, String> {
}
