package com.simtech.sim.dataproxy.service.db.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.dataproxy.entity.db.MineEntity;
import com.simtech.sim.dataproxy.mapper.MineStorageDao;
import com.simtech.sim.dataproxy.service.db.MineStorage;
import org.springframework.stereotype.Service;


@Service
public class MineStorageImpl extends ServiceImpl<MineStorageDao, MineEntity> implements MineStorage {
}
