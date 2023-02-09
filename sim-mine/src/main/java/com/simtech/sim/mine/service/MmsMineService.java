package com.simtech.sim.mine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.mine.entity.MmsMineEntity;

import java.util.Map;

/**
 * 
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 16:44:49
 */
public interface MmsMineService extends IService<MmsMineEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

