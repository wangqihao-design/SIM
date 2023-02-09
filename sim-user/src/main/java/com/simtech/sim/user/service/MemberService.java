package com.simtech.sim.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.user.entity.MemberEntity;

import java.util.Map;

/**
 * 用户
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-08 20:54:09
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

