package com.simtech.sim.mainnode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainNodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainNodeApplication.class, args);
    }

}
