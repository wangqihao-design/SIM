package com.simtech.sim.backpack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableFeignClients
@EnableMongoRepositories
@SpringBootApplication
public class BackpackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackpackApplication.class, args);
    }

}

