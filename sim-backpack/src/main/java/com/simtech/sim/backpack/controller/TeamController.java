package com.simtech.sim.backpack.controller;


import com.simtech.sim.backpack.entity.TeamEntity;
import com.simtech.sim.backpack.service.CommonService;
import com.simtech.sim.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/backpack/team")
public class TeamController {


    @Autowired
    private CommonService commonService;

    @RequestMapping("/addTeam")
    public Result<TeamEntity> addTeam(@RequestBody TeamEntity team){
        commonService.addTeam(team);
        return new Result<TeamEntity>().ok(team);
    }



    
}
