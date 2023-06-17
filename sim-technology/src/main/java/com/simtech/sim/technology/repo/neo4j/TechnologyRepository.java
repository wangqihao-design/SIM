package com.simtech.sim.technology.repo.neo4j;

import com.simtech.sim.technology.entity.ResearchEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TechnologyRepository extends Neo4jRepository<ResearchEntity, Long> {
}
