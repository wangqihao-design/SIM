package com.simtech.sim.dataproxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simtech.sim.dataproxy.entity.db.ProductEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductStorageDao extends BaseMapper<ProductEntity> {
}
