package com.simtech.sim.mainnode;

import com.simtech.sim.mainnode.service.impl.ServiceDiscoveryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainNodeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ServiceDiscoveryImpl discovery;

    @Test
    void discovery(){
        discovery.availableClient();
    }

}
