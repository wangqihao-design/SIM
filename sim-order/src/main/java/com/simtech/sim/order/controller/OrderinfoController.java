package com.simtech.sim.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simtech.sim.order.entity.OrderinfoEntity;
import com.simtech.sim.order.service.OrderinfoService;
import com.simtech.sim.common.utils.PageUtils;
import com.simtech.sim.common.utils.R;


/**
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-08 16:43:14
 */
@RestController
@RequestMapping("order/orderinfo")
public class OrderinfoController {
    @Autowired
    private OrderinfoService orderinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderinfo:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    //@RequiresPermissions("order:orderinfo:info")
    public R info(@PathVariable("orderId") Integer orderId) {
        OrderinfoEntity orderinfo = orderinfoService.getById(orderId);

        return R.ok().put("orderinfo", orderinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderinfo:save")
    public R save(@RequestBody OrderinfoEntity orderinfo) {
        orderinfoService.save(orderinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderinfo:update")
    public R update(@RequestBody OrderinfoEntity orderinfo) {
        orderinfoService.updateById(orderinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderinfo:delete")
    public R delete(@RequestBody Integer[] orderIds) {
        orderinfoService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
