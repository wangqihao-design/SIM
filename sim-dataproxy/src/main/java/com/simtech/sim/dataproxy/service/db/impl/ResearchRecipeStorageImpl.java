package com.simtech.sim.dataproxy.service.db.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.dataproxy.entity.db.ResearchRecipeEntity;
import com.simtech.sim.dataproxy.mapper.ResearchRecipeStorageDao;
import com.simtech.sim.dataproxy.service.db.ResearchStorage;
import org.springframework.stereotype.Service;

@Service
public class ResearchRecipeStorageImpl extends ServiceImpl<ResearchRecipeStorageDao, ResearchRecipeEntity> implements ResearchStorage {
}
