package com.simtech.sim.mine.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("mms_source_material")
public class MmsSourceMaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 原料id
	 */
	@TableId
	private Long id;
	/**
	 * 原料名称
	 */
	private String name;
	/**
	 * 原料品质【0-错误 1-顶级 2-高级 3-中级 4-低级 5-差】
	 */
	private Integer quality;
	/**
	 * 生产需要的时间(s)
	 */
	private Long produceTime;

}
