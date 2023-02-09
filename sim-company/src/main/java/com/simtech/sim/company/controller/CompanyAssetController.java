package com.simtech.sim.company.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simtech.sim.company.entity.CompanyAssetEntity;
import com.simtech.sim.company.service.CompanyAssetService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.R;



/**
 * 
 *
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 17:41:16
 */
@RestController
@RequestMapping("company/companyasset")
public class CompanyAssetController {
    @Autowired
    private CompanyAssetService companyAssetService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("company:companyasset:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyAssetService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("company:companyasset:info")
    public R info(@PathVariable("id") Integer id){
		CompanyAssetEntity companyAsset = companyAssetService.getById(id);

        return R.ok().put("companyAsset", companyAsset);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("company:companyasset:save")
    public R save(@RequestBody CompanyAssetEntity companyAsset){
		companyAssetService.save(companyAsset);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("company:companyasset:update")
    public R update(@RequestBody CompanyAssetEntity companyAsset){
		companyAssetService.updateById(companyAsset);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("company:companyasset:delete")
    public R delete(@RequestBody Integer[] ids){
		companyAssetService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
