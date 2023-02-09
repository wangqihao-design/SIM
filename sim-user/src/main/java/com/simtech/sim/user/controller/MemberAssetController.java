package com.simtech.sim.user.controller;


import com.simtech.sim.common.utils.R;
import com.simtech.sim.user.entity.MemberEntity;
import com.simtech.sim.user.entity.MemberStatisticsInfoEntity;
import com.simtech.sim.user.entity.MemberTransferEntity;
import com.simtech.sim.user.service.MemberStatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

// 用户资产改变模块

// TODO 添加权限模块

@RestController
@RequestMapping("user/asset")
public class MemberAssetController {

    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    @RequestMapping("/transfer")
    public R transfer(@RequestBody MemberTransferEntity memberTransferEntity){
        memberStatisticsInfoService.transferService(memberTransferEntity);
        return R.ok().put("code", 200);
    }

    @RequestMapping("/check")
    public R checkAsset(long id){
        BigDecimal asset = memberStatisticsInfoService.getById(id).getTotalAsset();
        return R.ok().put("asset", asset);
    }


}
