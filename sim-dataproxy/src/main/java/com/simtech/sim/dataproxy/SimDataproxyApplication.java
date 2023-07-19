package com.simtech.sim.dataproxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = {"com.simtech.sim.dataproxy.mapper"})

@EnableFeignClients
@SpringBootApplication
public class SimDataproxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimDataproxyApplication.class, args);
    }

}
