package com.simtech.sim.dataproxy.service.db.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.dataproxy.entity.db.ResearchEntity;
import com.simtech.sim.dataproxy.mapper.ResearchStorageDao;
import com.simtech.sim.dataproxy.service.db.ResearchStorage;
import org.springframework.stereotype.Service;

@Service
public class ResearchStorageImpl extends ServiceImpl<ResearchStorageDao, ResearchEntity> implements ResearchStorage {
}
