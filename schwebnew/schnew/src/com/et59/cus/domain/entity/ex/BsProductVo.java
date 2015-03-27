package com.et59.cus.domain.entity.ex;

import java.math.BigDecimal;

import com.et59.cus.domain.entity.BsProduct;
/**
 * 
 * 点滴工作室
 * @author liuhaihua
 *
 */
public class BsProductVo extends BsProduct {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private  int number;
	private  BigDecimal totalprice;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	
}
