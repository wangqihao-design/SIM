package com.simtech.sim.backpack.repo;

import com.simtech.sim.backpack.entity.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<TeamEntity, String> {
}


