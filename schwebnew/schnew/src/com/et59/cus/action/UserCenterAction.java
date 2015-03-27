package com.et59.cus.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.ex.OrderVo;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.opensymphony.xwork2.ActionContext;

/**
 * <p>Title: ucenter.java</p>
 * <p>Description: </p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2012-2-15
 * @version 2.0
 *
 */
@SuppressWarnings("serial")
public class UserCenterAction extends BaseAction{
	private static final Logger log = Logger.getLogger(UserCenterAction.class);
	private  OrderVo orderVo;
	/**
	 * 跳转到用户信息界面
	 * @return
	 */
	public String toUserInfo(){
		return "toUserInfo";
	}
	/**
	 * 修改用户信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String doUpdateUser(){
		try{
			Map map = localServiceProxy.updateUser(user,"");
			if(ComonUtil.validateMapResult(map)){
				showMessage="修改成功";
				log.info("修改成功");
			}else{
				showMessage="修改失败";
				log.info("修改失败");
			}
		}catch (Exception e) {
			showMessage="修改失败";
			log.info("修改失败");
			e.printStackTrace();
			return "update_user";
		}
		// 修改成功或者失败，session里的user对象要重新设置一遍
		Map map=null;;
		try {
			map = localServiceProxy.queryUsername(user);
			if(ComonUtil.validateMapResult(map)){
				BsUser  user1 = (BsUser) map.get(Constant.USER);
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("user", user1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update_user";
	}
	/**
	 * 更新密码主页
	 */
	public  String  toupdatepasswd(){
		return "toupdatepasswd";
	}
	/**
	 * 更新密码动作
	 */
	@SuppressWarnings("rawtypes")
	public  void  updatepasswd(){
		boolean flag=false;
		String password = request.getParameter("password");
		String defaultpassword = request.getParameter("defaultpasswd");
		user = (BsUser) context.getSession().get("user");
		if(user.getPassword().equals(defaultpassword)){
			user.setPassword(password);
			try{
				Map map = localServiceProxy.updateUser(user,"");
				if(ComonUtil.validateMapResult(map)){
					flag =true;
				}
				super.reponseWriter(JSON.toJSONString(flag));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 得到订单详情
	 * @return
	 */
	public  String getorderdetail(){
		String orderid=request.getParameter("id");
		try {
			orderVo =localServiceProxy.getOrderDetail(orderid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order_detail";
	}
	public OrderVo getOrderVo() {
		return orderVo;
	}
	public void setOrderVo(OrderVo orderVo) {
		this.orderVo = orderVo;
	}
	public static Logger getLog() {
		return log;
	}
	
}
