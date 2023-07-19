package com.simtech.sim.dataproxy.repo.mongo;

import com.simtech.sim.dataproxy.entity.ProductionLineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductionLineRepository extends MongoRepository<ProductionLineEntity, String> {
}
