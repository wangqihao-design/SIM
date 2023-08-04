package com.simtech.sim.dataproxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simtech.sim.dataproxy.entity.db.ResearchEfficiencyEntity;
import com.simtech.sim.dataproxy.entity.db.ResearchRecipeEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ResearchEfficiencyStorageDao extends BaseMapper<ResearchEfficiencyEntity> {
}
