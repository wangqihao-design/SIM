package com.simtech.sim.order.entity;

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
 * @date 2023-02-08 16:43:14
 */
@Data
@TableName("oms_orderinfo")
public class OrderinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer orderId;
	/**
	 * price of the order
	 */
	private BigDecimal orderPrice;
	/**
	 * buyer's id
	 */
	private Integer receiverId;
	/**
	 * seller's id
	 */
	private Integer producerId;
	/**
	 * violation date
	 */
	private Date vioDate;
	/**
	 * violation cost
violation cost
	 */
	private Integer vioMoney;
	/**
	 * notes
	 */
	private String orderNote;

}
