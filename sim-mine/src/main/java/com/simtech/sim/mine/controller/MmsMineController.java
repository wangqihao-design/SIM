package com.simtech.sim.mine.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simtech.sim.mine.entity.MmsMineEntity;
import com.simtech.sim.mine.service.MmsMineService;
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
@RequestMapping("mine/mmsmine")
public class MmsMineController {
    @Autowired
    private MmsMineService mmsMineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("mine:mmsmine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mmsMineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("mine:mmsmine:info")
    public R info(@PathVariable("id") Long id){
		MmsMineEntity mmsMine = mmsMineService.getById(id);

        return R.ok().put("mmsMine", mmsMine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("mine:mmsmine:save")
    public R save(@RequestBody MmsMineEntity mmsMine){
		mmsMineService.save(mmsMine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("mine:mmsmine:update")
    public R update(@RequestBody MmsMineEntity mmsMine){
		mmsMineService.updateById(mmsMine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("mine:mmsmine:delete")
    public R delete(@RequestBody Long[] ids){
		mmsMineService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
