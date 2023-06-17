package com.simtech.sim.technology.controller;


import com.simtech.sim.common.utils.R;
import com.simtech.sim.common.utils.Result;
import com.simtech.sim.technology.dto.AddTechDTO;
import com.simtech.sim.technology.entity.ResearchEntity;
import com.simtech.sim.technology.entity.mysql.BonusEntity;
import com.simtech.sim.technology.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private ResearchService researchService;


    @RequestMapping("/addResearch")
    public Result<ResearchEntity> createResearch(@RequestBody ResearchEntity research){
        researchService.createResearchEntity(research);
        return new Result<ResearchEntity>().ok(research);
    }

    @RequestMapping("/delResearch/{id}")
    public Result<String> deleteResearch(@PathVariable Long id){
        return researchService.deleteResearchEntity(id);
    }

    @RequestMapping("/allResearchInfo")
    public Result<List<ResearchEntity>> getAllResearchInfo(){
        List<ResearchEntity> allResearch =  researchService.getAllResearchEntities();
        return new Result<List<ResearchEntity>>().ok(allResearch);
    }

    @RequestMapping("/addTechToNode")
    public Result<AddTechDTO> addSubNode(@RequestBody AddTechDTO tech){
        researchService.addSubNode(tech.getParentId(), tech.getResearch());
        return new Result<AddTechDTO>().ok(tech);
    }

    @RequestMapping("/subNodes/{id}")
    public Result<List<ResearchEntity>> getSubNode(@PathVariable Long id){
        List<ResearchEntity> tech = researchService.getSubNodes(id);
        return new Result<List<ResearchEntity>>().ok(tech);
    }

    @RequestMapping("/setResearchBonus")
    public Result<BonusEntity> setResearchBonus(@RequestBody BonusEntity bonusInfo){
        researchService.save(bonusInfo);
        return new Result<BonusEntity>().ok(bonusInfo);
    }

    @RequestMapping("/getResearchBonus/{id}")
    public Result<BonusEntity> getResearchBonus(@PathVariable Long id){
        BonusEntity bonus = researchService.getById(id);
        return new Result<BonusEntity>().ok(bonus);
    }
}
