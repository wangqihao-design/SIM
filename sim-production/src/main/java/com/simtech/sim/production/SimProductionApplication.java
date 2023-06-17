package com.simtech.sim.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient

public class SimProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimProductionApplication.class, args);
    }

}
