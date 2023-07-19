package com.simtech.sim.mainnode.config.loadbalancing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collectors;

public class QuartzServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    @Autowired
    private DiscoveryClient discoveryClient;

    private final String serviceId;


    public QuartzServiceInstanceListSupplier(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {

        List<ServiceInstance> instances = discoveryClient.getInstances("quartz-working-node");

        List<ServiceInstance> instanceInfo = instances.stream().map(obj ->
                new DefaultServiceInstance(obj.getInstanceId(),
                        obj.getServiceId(),
                        obj.getHost(),
                        obj.getPort(), false)).collect(Collectors.toList());


        return Flux.just(instanceInfo);
    }
}
