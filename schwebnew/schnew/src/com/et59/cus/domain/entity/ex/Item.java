package com.et59.cus.domain.entity.ex;

import com.et59.cus.domain.entity.BsProduct;

/**
 * 
 * <p>Title: Item.java</p>
 * <p>Description: 购物车中item</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-6 上午11:39:37
 * @version 2.0
 *
 */
public class Item {
	private boolean checkbox = false;
	private int productnumber;
	private BsProduct bsProduct = new BsProduct();;
	public int getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}
	public BsProduct getBsProduct() {
		return bsProduct;
	}
	public void setBsProduct(BsProduct bsProduct) {
		this.bsProduct = bsProduct;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	
}
