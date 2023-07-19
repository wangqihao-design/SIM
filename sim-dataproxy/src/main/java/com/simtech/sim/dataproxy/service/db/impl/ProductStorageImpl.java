package com.simtech.sim.dataproxy.service.db.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.dataproxy.entity.db.ProductEntity;
import com.simtech.sim.dataproxy.mapper.ProductStorageDao;
import com.simtech.sim.dataproxy.service.db.ProductStorage;
import org.springframework.stereotype.Service;

@Service
public class ProductStorageImpl extends ServiceImpl<ProductStorageDao, ProductEntity> implements ProductStorage {
}
