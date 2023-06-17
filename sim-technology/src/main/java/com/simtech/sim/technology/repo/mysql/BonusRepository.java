package com.simtech.sim.technology.repo.mysql;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.technology.entity.mysql.BonusEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BonusRepository extends BaseMapper<BonusEntity> {
}
