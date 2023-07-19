package com.simtech.sim.calcfileserver;

import com.simtech.sim.calcfileserver.controller.FileController;
import com.simtech.sim.calcfileserver.service.FileReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class CalcFileServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private FileController fileController;

    @Test
    void reader() throws IOException {
        fileController.retrieve("test.py");
    }

}
