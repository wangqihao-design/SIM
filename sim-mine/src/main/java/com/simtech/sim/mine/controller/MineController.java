package com.simtech.sim.mine.controller;


import com.simtech.sim.mine.entity.basic.MineEntity;
import com.simtech.sim.mine.service.impl.timed.GenerateMine;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController

public class MineController {

    @Autowired
    private GenerateMine generateMine;

    @RequestMapping("/startGen")
    public void startGen() throws SchedulerException {
        generateMine.MineGenerationHelper("*/5 * * * * ?");
    }

    @RequestMapping("/getCurrentMine")
    public Set<MineEntity> getCurrentMine(){
        return generateMine.getMineInfo();
    }


}
