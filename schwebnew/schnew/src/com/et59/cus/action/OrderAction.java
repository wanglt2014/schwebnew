package com.et59.cus.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;
import com.et59.cus.tools.UUIDGenerator;

/**
 * 
 * <p>Title: OrderAction.java</p>
 * <p>Description: 订单管理后台</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-18 下午04:21:48
 * @version 2.0
 *
 */
public class OrderAction extends BaseAction {

	/**
	 * 订单管理
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 首页
	 * @return
	 */
	public String index(){
		return "index";
	}
	/**
	 * 分页查询订单
	 */
	@SuppressWarnings("rawtypes")
	public void query(){
		String orderid = request.getParameter("orderid"); 
		String userIdquery = request.getParameter("userIdquery"); 
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsOrder  bsOrder = new BsOrder();
			bsOrder.setUserId(userIdquery);
			bsOrder.setOrderId(orderid);
			Pager pager = new Pager();
			Map map= localServiceProxy.queryOrderForPage(bsOrder,Integer.valueOf(rows),Integer.valueOf(page));
			pager.setTotal((Integer)map.get(Constant.TOTALCOUNT));
			pager.setRows(map.get(Constant.ORDER_LIST));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新订单
	 */
	public  void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		BsOrder bsOrder = getBsOrder();
		try {
			bsOrder.setId(Integer.valueOf(id));
		
			localServiceProxy.updateOrder(bsOrder);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增订单
	 */
	public void save(){
		boolean flag =false ;
		BsOrder bsOrder = getBsOrder();
		String orderid  = UUIDGenerator.getOrderNo();//唯一的数据库主键
		bsOrder.setOrderId(orderid);
		try {
			localServiceProxy.insertOrder(bsOrder);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除订单
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteOrder(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到订单
	 * @return
	 */
	public BsOrder  getBsOrder(){
		String userId = request.getParameter("userId"); 
		String orderId = request.getParameter("orderId"); 
		String productid = request.getParameter("productId"); 
		String orderUpdateTime = request.getParameter("orderUpdateTime"); 
		String orderCreateTime = request.getParameter("orderCreateTime"); 
		String orderTotalPrice = request.getParameter("orderTotalPrice"); 
		String orderStatus = request.getParameter("orderStatus"); 
		String productNumber = request.getParameter("productNumber"); 
		String addressId = request.getParameter("addressId"); 
		BsOrder bsOrder  = new BsOrder();
		BsUser user = new BsUser();
		user.setUserid(userId);
		bsOrder.setUserId(userId);
		bsOrder.setProductId(Integer.valueOf(productid));
		bsOrder.setOrderUpdateTime(DateUtil.strToDate(orderUpdateTime));
		bsOrder.setProductNumber(Integer.valueOf(productNumber));
		bsOrder.setOrderCreateTime(DateUtil.strToDate(orderCreateTime));
		bsOrder.setOrderTotalPrice(new BigDecimal(orderTotalPrice));
		bsOrder.setOrderStatus(Integer.valueOf(orderStatus));
		bsOrder.setOrderId(orderId);
		bsOrder.setAddressId(Long.valueOf(addressId));
		return bsOrder;
	}
}
