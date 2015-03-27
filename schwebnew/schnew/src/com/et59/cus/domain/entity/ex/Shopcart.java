package com.et59.cus.domain.entity.ex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>
 * Title: Shopcart.java
 * </p>
 * <p>
 * Description: 购物车
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-6 上午11:37:19
 * @version 2.0
 * 
 */
public class Shopcart {
	/**
	 * 购物车中
	 */
	private List<Item> list = new ArrayList<Item>();
	private int itemnumber;
	private BigDecimal totalPrice ;

	public BigDecimal getTotalPrice() {
		totalPrice = new BigDecimal(0);
		for (Item item : list) {
			if (item.isCheckbox()) {
				BigDecimal  itemprice =item.getBsProduct().getProductPrice().multiply(new BigDecimal(item.getProductnumber()));
				totalPrice = totalPrice.add(itemprice);
			}
		}
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public int getItemnumber() {
		itemnumber = list.size();
		return itemnumber;
	}

	public void setItemnumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}

}
