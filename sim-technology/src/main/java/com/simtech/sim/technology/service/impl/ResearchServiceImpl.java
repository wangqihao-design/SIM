package com.simtech.sim.technology.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.Result;
import com.simtech.sim.technology.entity.ResearchEntity;
import com.simtech.sim.technology.entity.mysql.BonusEntity;
import com.simtech.sim.technology.repo.mysql.BonusRepository;
import com.simtech.sim.technology.repo.neo4j.TechnologyRepository;
import com.simtech.sim.technology.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ResearchServiceImpl extends ServiceImpl<BonusRepository, BonusEntity> implements ResearchService {


    private final TechnologyRepository technologyRepository;

    public ResearchServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public ResearchEntity createResearchEntity(ResearchEntity researchEntity) {
        return technologyRepository.save(researchEntity);
    }

    @Override
    public Result<String> deleteResearchEntity(Long id) {
        if (technologyRepository.existsById(id)) {
            technologyRepository.deleteById(id);
            return new Result<String>().ok("ok");
        } else {
            return new Result<String>().error("No such technology");
        }
    }

    @Override
    public ResearchEntity updateResearchEntity(ResearchEntity researchEntity) {
        return technologyRepository.save(researchEntity);
    }

    @Override
    public ResearchEntity getResearchEntityById(Long id) {
        return technologyRepository.findById(id).orElse(null);
    }

    @Override
    public List<ResearchEntity> getAllResearchEntities() {
        return technologyRepository.findAll();
    }

    @Override
    public ResearchEntity addSubNode(Long parentId, ResearchEntity subNode) {
        ResearchEntity parent = technologyRepository.findById(parentId).orElse(null);
        if (parent != null) {
            parent.requires(subNode);
            return technologyRepository.save(parent);
        }
        return subNode;
    }

    @Override
    public List<ResearchEntity> getSubNodes(Long parentId) {
        ResearchEntity parent = technologyRepository.findById(parentId).orElse(null);
        if (parent != null) {
            return new ArrayList<>(parent.getPostTech());
        }
        return Collections.emptyList();
    }



}
