package com.et59.cus.domain.entity.ex;

import java.util.List;

import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;

/**
 * 
 * <p>Title: OrderVo.java</p>
 * <p>Description: 订单返回</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-11 下午02:37:17
 * @version 2.0
 *
 */
public class OrderVo {
	private  BsOrder  order;
	private  BsAddress bsAddress;
	private  List<BsProductVo> list;
	public BsOrder getOrder() {
		return order;
	}
	public void setOrder(BsOrder order) {
		this.order = order;
	}
	public BsAddress getBsAddress() {
		return bsAddress;
	}
	public void setBsAddress(BsAddress bsAddress) {
		this.bsAddress = bsAddress;
	}
	public List<BsProductVo> getList() {
		return list;
	}
	public void setList(List<BsProductVo> list) {
		this.list = list;
	}
	
	
}
