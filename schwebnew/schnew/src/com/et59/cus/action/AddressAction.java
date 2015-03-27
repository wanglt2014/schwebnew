package com.et59.cus.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;
import com.et59.cus.tools.UUIDGenerator;

/**
 * 
 * <p>Title: AddressAction.java</p>
 * <p>Description: 地址维护</p>
 *
 */
public class AddressAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	public String index(){
		return "index";
	}
	/**
	 * 查询地址
	 */
	public  void query(){
		String userIdquery = request.getParameter("userIdquery"); 
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsAddress  bsAddress = new BsAddress();
			bsAddress.setUserid(userIdquery);
			Pager pager= localServiceProxy.queryaddressbyPage(bsAddress,Integer.valueOf(rows),Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询用户地址
	 */
	public  void queryuserAddres(){
		try {
			BsAddress  bsAddress = new BsAddress();
			bsAddress.setUserid(getUser().getUserid());
			Pager pager= localServiceProxy.queryaddressbyPage(bsAddress,10,1);
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增地址
	 */
	public void  save(){
		boolean flag =false ;
		BsAddress bsAddress = getBsAddress();
		try {
			localServiceProxy.insertBsAddress(bsAddress);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除地址
	 */
	public void  delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteBsAddress(new Long(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新地址
	 */
	public void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		BsAddress bsAddress = getBsAddress();
		try {
			bsAddress.setId(new Long(id));
			localServiceProxy.updateBsAddress(bsAddress);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到地址
	 * @return
	 */
	public BsAddress  getBsAddress(){
		String userid = request.getParameter("userid"); 
		String consignee = request.getParameter("consignee"); 
		String telephone = request.getParameter("telephone"); 
		String postcode = request.getParameter("postcode"); 
		String addressHead = request.getParameter("addressHead"); 
		String addressDetail = request.getParameter("addressDetail"); 
		BsAddress bsAddress  = new BsAddress();
		bsAddress.setUserid(userid);
		bsAddress.setAddressDetail(addressDetail);
		bsAddress.setAddressHead(addressHead);
		bsAddress.setConsignee(consignee);
		bsAddress.setTelephone(telephone);
		bsAddress.setPostcode(postcode);
		return bsAddress;
	}
}
