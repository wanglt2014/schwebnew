package com.et59.cus.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsUserservice;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.UUIDGenerator;

/**
 * <p>Title: RepeatOrderAction.java</p>
 * <p>Description: </p>
 * <p>Copyright:</p>
 * <p>Company: </p>
 * @author 
 * @date 2012-2-15
 * @version 2.0
 *
 */
@SuppressWarnings("serial")
public class RepeatOrderAction extends BaseAction{
	Logger log = Logger.getLogger(this.getClass());
	//private List<BsOrder> orderlist;
	List<BsUserservice> userServicelist ;
	/**
	 * 续订首页
	 * @return
	 */
	public String toSubIndex(){
		
		return "toSubIndex";
	}
	/**
	 * 续订查询
	 * @return
	 */
	public String doRepeatOrderQuery(){
		getSession().put(Constant.SUPPLIERCODE, suppliercode);
		return "repeatOrder_query";
	}
	/**
	 *查询预备
	 * @return
	 */
	public String toRepeatOrderQuery(){
		getSession().put(Constant.ORDER_OBJ, order);
		return "repeatOrder_querypre";
	}
	/**
	 * 查询订购产品
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String excuteProductQuery(){
		
		order = (BsOrder) getSession().get(Constant.ORDER_OBJ);
		if(log.isDebugEnabled()){
			log.debug("查询订单信息currentPage>>>>:"+currentPage);
		}
		String supplier_Code = (String) getSession().get(Constant.SUPPLIERCODE);
		try {
			if(currentPage == 0){
				currentPage = 1;
			}
			BsUserservice  bsUserservice= new BsUserservice();
			//Map map =localServiceProxy.queryOrderByIccardForPage(order, Constant.PAGESIZE,currentPage);
			Map map =localServiceProxy.queryUserServiceForPage(bsUserservice,  Constant.PAGESIZE, currentPage);
			if(ComonUtil.validateMapResult(map)){
				//orderlist = (List<BsOrder>) map.get(Constant.ORDER_LIST);
				userServicelist = (List<BsUserservice>) map.get(Constant.BSUSERSERVICE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount =(Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "excute_productquery";
	}
	/**
	 * 查询产品详细信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String queryRepeatOrderInfo(){
		String id =  request.getParameter("id");
		if(log.isDebugEnabled()){
			log.debug("将要查询的产品code---->"+id);
		}
		try {
			Map map =localServiceProxy.queryProductDetail(Integer.valueOf(id));
			if(ComonUtil.validateMapResult(map)){
				product = (BsProduct) map.get(Constant.PRODUCT_OBJ);
				getSession().put(Constant.PRODUCT_OBJ, product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "repeatOrder_detailInfo";
	}
	/***
	 * 选择购买产品
	 * @return
	 */
	public String doRepeatOrderChoose(){
		product = (BsProduct) getSession().get(Constant.PRODUCT_OBJ);
		order = (BsOrder) getSession().get(Constant.ORDER_OBJ);
		BsOrder order1 =  new BsOrder();
		order = order1;
		getSession().put(Constant.ORDER_OBJ, order1);
		return  "repeatOrder_choose";
	}
	/**
	 * 产品确认
	 * @return
	 */
	public String doRepeatOrderConfirm(){
		BsOrder order1 = (BsOrder) getSession().get(Constant.ORDER_OBJ);
		order1.setProductNumber(order.getProductNumber());
		order1.setOrderTotalPrice(product.getProductPrice().multiply(new BigDecimal(order.getProductNumber())));
		order = order1;
		getSession().put(Constant.ORDER_OBJ, order1);
		return  "repeatOrder_confirm";
	}
	/**
	 * 支付
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String doRepeatOrderPay(){
		order = (BsOrder) getSession().get(Constant.ORDER_OBJ);
		String orderid  = UUIDGenerator.getOrderNo();//唯一的数据库主键
		order.setOrderId(orderid);
		order.setOrderStatus(Constant.ORDER_STATUS_UNPAY);
		order.setOrderCreateTime(ComonUtil.getDate(0));
		String loginName = "";
		if(null!=getUser()){
			order.setUserId(String.valueOf(getUser().getUserid()));
			loginName = getUser().getUsername();
		}
		try {
			Map map =localServiceProxy.insertOrder(order);
			if(ComonUtil.validateMapResult(map)){
				if(log.isDebugEnabled()){
					log.debug("保存订单成功!将要进行订单支付ing");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return  "repeatOrder_pay";
	}
	/*public List<BsOrder> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<BsOrder> orderlist) {
		this.orderlist = orderlist;
	}*/
	public List<BsUserservice> getUserServicelist() {
		return userServicelist;
	}
	public void setUserServicelist(List<BsUserservice> userServicelist) {
		this.userServicelist = userServicelist;
	}
	
	
}
