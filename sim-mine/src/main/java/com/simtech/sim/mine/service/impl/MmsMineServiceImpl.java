package com.simtech.sim.mine.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.mine.dao.MmsMineDao;
import com.simtech.sim.mine.entity.MmsMineEntity;
import com.simtech.sim.mine.service.MmsMineService;


@Service("mmsMineService")
public class MmsMineServiceImpl extends ServiceImpl<MmsMineDao, MmsMineEntity> implements MmsMineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MmsMineEntity> page = this.page(
                new Query<MmsMineEntity>().getPage(params),
                new QueryWrapper<MmsMineEntity>()
        );

        return new PageUtils(page);
    }

}