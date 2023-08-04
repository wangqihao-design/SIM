package com.simtech.sim.calcfileserver;

import com.simtech.sim.calcfileserver.util.MinioUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalcFileServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MinioUtils minioUtils;

    @Test
    public void sometest(){
        minioUtils.getObject("researchset", "test");
    }

}
