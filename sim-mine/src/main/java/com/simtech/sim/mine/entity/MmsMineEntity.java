package com.simtech.sim.mine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author CharlieWang
 * @email wan2901@dcds.edu
 * @date 2023-02-09 16:44:49
 */
@Data
@TableName("mms_mine")
public class MmsMineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 矿井id
	 */
	@TableId
	private Long id;
	/**
	 * 矿井名称
	 */
	private String name;
	/**
	 * 产出物品1
	 */
	private Long productid1;
	/**
	 * 产出物品2
	 */
	private Long productid2;
	/**
	 * 产出物品3【最多产出3种，不够再改】
	 */
	private Long productid3;
	/**
	 * 矿井价格
	 */
	private BigDecimal cost;
	/**
	 * 矿井位置
	 */
	private String location;

}
