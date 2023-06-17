package com.simtech.sim.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SimTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimTradeApplication.class, args);
    }

}
