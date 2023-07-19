package com.simtech.sim.dataproxy.repo.sql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simtech.sim.dataproxy.entity.MachineEntity;
import org.springframework.stereotype.Repository;


@Repository

public interface MachineRepository extends BaseMapper<MachineEntity> {

}