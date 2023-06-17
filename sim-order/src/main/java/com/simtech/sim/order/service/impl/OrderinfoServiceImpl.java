package com.simtech.sim.order.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.order.dao.OrderinfoDao;
import com.simtech.sim.order.entity.OrderinfoEntity;
import com.simtech.sim.order.service.OrderinfoService;


@Service("orderinfoService")
public class OrderinfoServiceImpl extends ServiceImpl<OrderinfoDao, OrderinfoEntity> implements OrderinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderinfoEntity> page = this.page(
                new Query<OrderinfoEntity>().getPage(params),
                new QueryWrapper<OrderinfoEntity>()
        );

        return new PageUtils(page);
    }

}