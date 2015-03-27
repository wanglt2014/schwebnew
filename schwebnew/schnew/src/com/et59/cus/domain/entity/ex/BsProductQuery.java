package com.et59.cus.domain.entity.ex;

import java.util.Date;

import com.et59.cus.domain.entity.BsProduct;
/**
 * 查询条件
 * 点滴工作室
 * @author liuhaihua
 *
 */
public class BsProductQuery extends BsProduct {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Date startcreatetime;
	private Date endcreatetime;
	public Date getStartcreatetime() {
		return startcreatetime;
	}
	public void setStartcreatetime(Date startcreatetime) {
		this.startcreatetime = startcreatetime;
	}
	public Date getEndcreatetime() {
		return endcreatetime;
	}
	public void setEndcreatetime(Date endcreatetime) {
		this.endcreatetime = endcreatetime;
	}
	
}
