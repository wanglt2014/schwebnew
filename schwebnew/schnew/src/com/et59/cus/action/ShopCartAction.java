package com.et59.cus.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.ex.Item;
import com.et59.cus.domain.entity.ex.OrderVo;
import com.et59.cus.domain.entity.ex.Shopcart;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;

/**
 * 
 * <p>Title: ShopCartAction.java</p>
 * <p>Description: 购物车操</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-6 上午11:46:11
 * @version 2.0
 *
 */
public class ShopCartAction extends BaseAction {
	private OrderVo orderVo;
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6780751895679934112L;
	/**
	 * 查询购物车
	 */
	public   void  queryShopCart(){
		//
		reponseWriter(JSON.toJSONString(getShopcart()));
	}
	/**
	 * 添加item
	 */
	@SuppressWarnings("rawtypes")
	public  void  addItem(){
		boolean flag= false;
		String productid = request.getParameter("productid");
		try {
			Map map =localServiceProxy.queryProductDetail(Integer.parseInt(productid));
			if(ComonUtil.validateMapResult(map)){
				product = (BsProduct) map.get(Constant.PRODUCT_OBJ);
			}
			Item item = new Item();
			item.setProductnumber(1);
			item.setBsProduct(product);
			item.setCheckbox(true);
			Item returnitem = isExistsItem(item);
			if(null ==returnitem){//不存在添加item
				getShopcart().getList().add(item);
			}else{//存在数量加1
				returnitem.setProductnumber(returnitem.getProductnumber()+1);
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		reponseWriter(JSON.toJSONString(flag));
	}
	/**
	 * 更新item
	 */
	public void updateCheckbox(){
		boolean flag= false;
		String productid = request.getParameter("productid");
		String checkflag = request.getParameter("checkflag");
		List<Item> list =getShopcart().getList();
		for(Item row:list){
			if(row.getBsProduct().getId()==Integer.parseInt(productid)){
				if(checkflag.equals("yes")){
					row.setCheckbox(true);
				}else if(checkflag.equals("no")){
					row.setCheckbox(false);
				}
			}
		}
		flag = true;
		reponseWriter(JSON.toJSONString(flag));
	}
	/**
	 * 设置数量
	 */
	public  void setProductnum(){
		boolean flag= false;
		String productid = request.getParameter("productid");
		String productnumber = request.getParameter("productnumber");
		List<Item> list =getShopcart().getList();
		for(Item row:list){
			if(row.getBsProduct().getId()==Integer.parseInt(productid)){
				row.setProductnumber(Integer.valueOf(productnumber));
			}
		}
		flag = true;
		reponseWriter(JSON.toJSONString(flag));
	}
	/**
	 * 删除Item
	 */
	@SuppressWarnings("rawtypes")
	public void deleteItem(){
		boolean flag= false;
		String productid = request.getParameter("productid");
		List<Item> list =getShopcart().getList();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Item row = (Item) it.next();
			if(row.getBsProduct().getId()==Integer.parseInt(productid)){
				it.remove();
				list.remove(row);
			}
		}
		flag = true;
		reponseWriter(JSON.toJSONString(flag));
	}
	/**
	 * 返回Shopcart
	 * @return
	 */
	public  Shopcart getShopcart(){
		initShopCart();
		return (Shopcart) getSession().get(Constant.SHOP_CART);
	}
	/**
	 * 存在则数量+1
	 * 不存在则放入购物车
	 */
	public  Item  isExistsItem(Item item){
		Item  returnitem =null; ;
		List<Item> list = getShopcart().getList();
		if(null==list||list.size()==0){
			returnitem = null;
		}else{
			for(Item  row:list){
				if(row.getBsProduct().getId().equals(item.getBsProduct().getId())){
					returnitem = row;
				}
			}
		}
		return returnitem;
	}
	/**
	 * 初始化购物车
	 */
	public  synchronized void initShopCart(){
		Shopcart shopcart = (Shopcart) getSession().get(Constant.SHOP_CART);
		if(null==shopcart){
			Shopcart shopcart1 = new Shopcart();
			getSession().put(Constant.SHOP_CART, shopcart1);
			getShopcart();
		}
	
	}
	/**
	 * 提交订购
	 * @return
	 */
	public String  commit(){
		return "commit";
	}
	
	/**
	 * 支付
	 * @return
	 */
	public  String pay(){
		String identity = request.getParameter("identity");
		String contactname = request.getParameter("contactname");
		String address_head = request.getParameter("address_head");
		String address_detail = request.getParameter("address_detail");
		String contacttelephone = request.getParameter("contacttelephone");
		String address_postcode = request.getParameter("address_postcode");
		BsAddress bsAddress = new BsAddress();
		bsAddress.setAddressDetail(address_detail);
		bsAddress.setAddressHead(address_head);
		bsAddress.setConsignee(contactname);
		bsAddress.setPostcode(address_postcode);
		bsAddress.setUserid(getUser().getUserid());
		bsAddress.setTelephone(contacttelephone);
		try {
			 orderVo = localServiceProxy.Pay(bsAddress, (Shopcart) getSession().get(Constant.SHOP_CART),identity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pay";
	}
	public OrderVo getOrderVo() {
		return orderVo;
	}
	public void setOrderVo(OrderVo orderVo) {
		this.orderVo = orderVo;
	}
	
}
