package com.simtech.sim.mine;

import com.simtech.sim.mine.controller.MineController;
import com.simtech.sim.mine.service.PurchaseMine;
import com.simtech.sim.mine.service.impl.timed.GenerateMine;
import com.simtech.sim.mine.util.name.NameGenerator;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimMineApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private NameGenerator name;

    @Autowired
    private MineController mineController;

    @Test
    void MineGenTest() throws SchedulerException {
        mineController.startGen();
    }

    @Autowired
    private PurchaseMine purchaseMine;



}
