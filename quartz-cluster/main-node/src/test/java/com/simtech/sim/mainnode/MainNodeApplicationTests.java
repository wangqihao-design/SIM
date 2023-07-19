package com.simtech.sim.mainnode;

import com.simtech.sim.mainnode.service.JobAcceptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainNodeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private JobAcceptor jobAcceptor;

    @Test
    void test(){
    }

}
