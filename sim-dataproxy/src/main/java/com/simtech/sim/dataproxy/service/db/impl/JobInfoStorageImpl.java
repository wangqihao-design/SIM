package com.simtech.sim.dataproxy.service.db.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.dataproxy.mapper.JobInfoStorageDao;
import com.simtech.sim.dataproxy.entity.JobInfoTable;
import com.simtech.sim.dataproxy.service.db.JobInfoStorage;
import org.springframework.stereotype.Service;


@Service
public class JobInfoStorageImpl extends ServiceImpl<JobInfoStorageDao, JobInfoTable> implements JobInfoStorage {
}
