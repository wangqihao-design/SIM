package com.simtech.sim.mine.repo;

import com.simtech.sim.mine.entity.basic.MineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MineRepository extends MongoRepository<MineEntity, String> {
}
