package com.simtech.sim.mainnode.service.impl;


import com.simtech.sim.mainnode.service.ServiceDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDiscoveryImpl implements ServiceDiscovery {


    @Autowired
    private DiscoveryClient discoveryClient;


    @Override
    public List<String> availableClient(){
        return discoveryClient.getServices();
    }


    public void LoadBalancer(){

    }

}

