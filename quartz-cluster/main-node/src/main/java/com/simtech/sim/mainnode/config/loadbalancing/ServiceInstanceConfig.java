package com.simtech.sim.mainnode.config.loadbalancing;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ServiceInstanceConfig {

    @Bean
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new QuartzServiceInstanceListSupplier("quartz-working-node");
    }

}