package com.simtech.sim.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.service.impl.CrudServiceImpl;
import com.simtech.sim.production.entity.ProductionRequestEntity;
import com.simtech.sim.production.repo.sql.ProductionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductionRequestServiceImpl extends ServiceImpl<ProductionInfoRepository, ProductionRequestEntity> {


}
