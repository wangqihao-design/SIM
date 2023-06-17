package com.simtech.sim.technology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.Result;
import com.simtech.sim.technology.entity.ResearchEntity;
import com.simtech.sim.technology.entity.mysql.BonusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResearchService extends IService<BonusEntity> {
    ResearchEntity createResearchEntity(ResearchEntity researchEntity);

    Result<String> deleteResearchEntity(Long id);

    ResearchEntity updateResearchEntity(ResearchEntity researchEntity);

    ResearchEntity getResearchEntityById(Long id);

    List<ResearchEntity> getAllResearchEntities();

    ResearchEntity addSubNode(Long parentId, ResearchEntity subNode);

    List<ResearchEntity> getSubNodes(Long parentId);
}
