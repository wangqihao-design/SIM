package com.simtech.sim.technology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableMongoRepositories
@SpringBootApplication
@EnableNeo4jRepositories
public class SimTechnologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimTechnologyApplication.class, args);
    }

}
