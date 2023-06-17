package com.simtech.sim.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.order.entity.OrderinfoEntity;

import java.util.Map;

/**
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-08 16:43:14
 */
public interface OrderinfoService extends IService<OrderinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

