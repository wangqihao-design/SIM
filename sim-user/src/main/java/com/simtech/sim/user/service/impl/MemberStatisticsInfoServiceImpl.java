package com.simtech.sim.user.service.impl;

import com.simtech.sim.user.entity.MemberTransferEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.Query;

import com.simtech.sim.user.dao.MemberStatisticsInfoDao;
import com.simtech.sim.user.entity.MemberStatisticsInfoEntity;
import com.simtech.sim.user.service.MemberStatisticsInfoService;


@Service("memberStatisticsInfoService")
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoDao, MemberStatisticsInfoEntity> implements MemberStatisticsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberStatisticsInfoEntity> page = this.page(
                new Query<MemberStatisticsInfoEntity>().getPage(params),
                new QueryWrapper<MemberStatisticsInfoEntity>()
        );

        return new PageUtils(page);
    }

    // 转账系统
    @Override
    public String transferService(MemberTransferEntity TransferEntity) {
        MemberStatisticsInfoEntity payerStatisticsInfoEntity = new MemberStatisticsInfoEntity();
        payerStatisticsInfoEntity.setId(TransferEntity.getPayerId());
        payerStatisticsInfoEntity.setTotalAsset(getById(TransferEntity.getPayerId()).getTotalAsset().subtract(TransferEntity.getTransferred()));
        updateById(payerStatisticsInfoEntity);

        MemberStatisticsInfoEntity receiverStatisticsInfoEntity = new MemberStatisticsInfoEntity();
        receiverStatisticsInfoEntity.setId(TransferEntity.getReceiverId());
        receiverStatisticsInfoEntity.setTotalAsset(getById(TransferEntity.getReceiverId()).getTotalAsset().add(TransferEntity.getTransferred()));
        updateById(receiverStatisticsInfoEntity);
        return "success";
    }


}