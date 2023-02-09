package com.simtech.sim.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SimGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimGatewayApplication.class, args);
    }

}
