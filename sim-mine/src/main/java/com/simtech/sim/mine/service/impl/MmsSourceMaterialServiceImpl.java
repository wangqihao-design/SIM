package com.simtech.sim.mine.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.mine.dao.MmsSourceMaterialDao;
import com.simtech.sim.mine.entity.MmsSourceMaterialEntity;
import com.simtech.sim.mine.service.MmsSourceMaterialService;


@Service("mmsSourceMaterialService")
public class MmsSourceMaterialServiceImpl extends ServiceImpl<MmsSourceMaterialDao, MmsSourceMaterialEntity> implements MmsSourceMaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MmsSourceMaterialEntity> page = this.page(
                new Query<MmsSourceMaterialEntity>().getPage(params),
                new QueryWrapper<MmsSourceMaterialEntity>()
        );

        return new PageUtils(page);
    }

}