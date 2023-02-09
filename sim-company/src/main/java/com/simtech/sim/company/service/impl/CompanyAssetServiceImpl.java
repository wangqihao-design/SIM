package com.simtech.sim.company.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.company.dao.CompanyAssetDao;
import com.simtech.sim.company.entity.CompanyAssetEntity;
import com.simtech.sim.company.service.CompanyAssetService;


@Service("companyAssetService")
public class CompanyAssetServiceImpl extends ServiceImpl<CompanyAssetDao, CompanyAssetEntity> implements CompanyAssetService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyAssetEntity> page = this.page(
                new Query<CompanyAssetEntity>().getPage(params),
                new QueryWrapper<CompanyAssetEntity>()
        );

        return new PageUtils(page);
    }

}