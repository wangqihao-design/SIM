package com.simtech.sim.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.company.entity.CompanyFinanceEntity;

import java.util.Map;

/**
 * 
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 17:41:16
 */
public interface CompanyFinanceService extends IService<CompanyFinanceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

