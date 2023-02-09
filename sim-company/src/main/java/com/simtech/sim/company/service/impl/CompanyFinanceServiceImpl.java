package com.simtech.sim.company.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.company.dao.CompanyFinanceDao;
import com.simtech.sim.company.entity.CompanyFinanceEntity;
import com.simtech.sim.company.service.CompanyFinanceService;


@Service("companyFinanceService")
public class CompanyFinanceServiceImpl extends ServiceImpl<CompanyFinanceDao, CompanyFinanceEntity> implements CompanyFinanceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyFinanceEntity> page = this.page(
                new Query<CompanyFinanceEntity>().getPage(params),
                new QueryWrapper<CompanyFinanceEntity>()
        );

        return new PageUtils(page);
    }

}