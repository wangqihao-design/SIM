package com.simtech.sim.user.service.impl;

import com.simtech.sim.common.utils.R;
import com.simtech.sim.user.entity.MemberTransferEntity;
import com.simtech.sim.user.entity.OrderinfoEntity;
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
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional
    public R transferService(MemberTransferEntity TransferEntity) {

        // 扣除A的钱
        MemberStatisticsInfoEntity payerStatisticsInfoEntity = new MemberStatisticsInfoEntity();
        payerStatisticsInfoEntity.setId(TransferEntity.getPayerId());
        payerStatisticsInfoEntity.setTotalAsset(getById(TransferEntity.getPayerId()).getTotalAsset().subtract(TransferEntity.getTransferred()));
        updateById(payerStatisticsInfoEntity);

        // 加B的钱
        MemberStatisticsInfoEntity receiverStatisticsInfoEntity = new MemberStatisticsInfoEntity();
        receiverStatisticsInfoEntity.setId(TransferEntity.getReceiverId());
        receiverStatisticsInfoEntity.setTotalAsset(getById(TransferEntity.getReceiverId()).getTotalAsset().add(TransferEntity.getTransferred()));
        updateById(receiverStatisticsInfoEntity);
        return R.ok().put("code", 200);
    }
}