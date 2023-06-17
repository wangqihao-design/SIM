package com.simtech.sim.mine.repo.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simtech.sim.mine.entity.cities.CityEntities;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityNameRepo extends BaseMapper<CityEntities> {


}
