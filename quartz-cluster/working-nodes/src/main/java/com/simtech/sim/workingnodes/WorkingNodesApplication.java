package com.simtech.sim.workingnodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

import static org.slf4j.LoggerFactory.*;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkingNodesApplication {



	public static void main(String[] args) {
		SpringApplication.run(WorkingNodesApplication.class, args);
	}

}
