package com.simtech.sim.dataproxy.repo.sql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simtech.sim.dataproxy.entity.ProductionRequestEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionInfoRepository extends BaseMapper<ProductionRequestEntity> {
}
