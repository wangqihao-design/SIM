package com.simtech.sim.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.company.entity.CompanyAssetEntity;

import java.util.Map;

/**
 * 
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 17:41:16
 */
public interface CompanyAssetService extends IService<CompanyAssetEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

