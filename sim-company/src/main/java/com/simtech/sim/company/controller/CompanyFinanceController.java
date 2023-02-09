package com.simtech.sim.company.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simtech.sim.company.entity.CompanyFinanceEntity;
import com.simtech.sim.company.service.CompanyFinanceService;
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
@RequestMapping("company/companyfinance")
public class CompanyFinanceController {
    @Autowired
    private CompanyFinanceService companyFinanceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("company:companyfinance:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyFinanceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("company:companyfinance:info")
    public R info(@PathVariable("id") Integer id){
		CompanyFinanceEntity companyFinance = companyFinanceService.getById(id);

        return R.ok().put("companyFinance", companyFinance);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("company:companyfinance:save")
    public R save(@RequestBody CompanyFinanceEntity companyFinance){
		companyFinanceService.save(companyFinance);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("company:companyfinance:update")
    public R update(@RequestBody CompanyFinanceEntity companyFinance){
		companyFinanceService.updateById(companyFinance);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("company:companyfinance:delete")
    public R delete(@RequestBody Integer[] ids){
		companyFinanceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
