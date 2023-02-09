package com.simtech.sim.mine.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simtech.sim.mine.entity.MmsSourceMaterialEntity;
import com.simtech.sim.mine.service.MmsSourceMaterialService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.R;



/**
 * 
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 16:44:49
 */
@RestController
@RequestMapping("mine/mmssourcematerial")
public class MmsSourceMaterialController {
    @Autowired
    private MmsSourceMaterialService mmsSourceMaterialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("mine:mmssourcematerial:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mmsSourceMaterialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("mine:mmssourcematerial:info")
    public R info(@PathVariable("id") Long id){
		MmsSourceMaterialEntity mmsSourceMaterial = mmsSourceMaterialService.getById(id);

        return R.ok().put("mmsSourceMaterial", mmsSourceMaterial);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("mine:mmssourcematerial:save")
    public R save(@RequestBody MmsSourceMaterialEntity mmsSourceMaterial){
		mmsSourceMaterialService.save(mmsSourceMaterial);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("mine:mmssourcematerial:update")
    public R update(@RequestBody MmsSourceMaterialEntity mmsSourceMaterial){
		mmsSourceMaterialService.updateById(mmsSourceMaterial);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("mine:mmssourcematerial:delete")
    public R delete(@RequestBody Long[] ids){
		mmsSourceMaterialService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
