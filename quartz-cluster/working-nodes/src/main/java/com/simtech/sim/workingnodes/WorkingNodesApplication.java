package com.simtech.sim.workingnodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkingNodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkingNodesApplication.class, args);
	}

}
