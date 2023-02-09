package com.simtech.sim.company.entity;

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
 * @date 2023-02-09 17:41:16
 */
@Data
@TableName("company_asset")
public class CompanyAssetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 公司id
	 */
	@TableId
	private Integer id;
	/**
	 * 公司名字
	 */
	private String name;
	/**
	 * 公司古固定资产【矿井】
	 */
	private Integer fixAsset;

}
