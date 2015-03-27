package com.et59.cus.action;

import java.io.IOException;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsLeavemessage;
import com.et59.cus.domain.entity.ex.OpenLogQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.DateUtil;

/**
 * 
 * <p>
 * Title: LeaveMessageAction.java
 * </p>
 * <p>
 * Description: 留言时间
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-5-27 上午09:57:59
 * @version 2.0
 * 
 */
public class LeaveMessageAction extends BaseAction {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public void save() {
		boolean flag = false;
		try {
			String msg_vcode = request.getParameter("msg_vcode");
			String randomcode = (String) getSession().get("RANDOMIMAGES");
			log.info("checkcode|randomcode:" + msg_vcode + "|" + randomcode);
			if (randomcode.equalsIgnoreCase(msg_vcode)) {
				String name = request.getParameter("name");
				String message = request.getParameter("message");
				String email = request.getParameter("email");
				String telephone = request.getParameter("telephone");
				BsLeavemessage bsLeavemessage = new BsLeavemessage();
				bsLeavemessage.setEmail(email);
				bsLeavemessage.setLeaveTime(new Date());
				bsLeavemessage.setMessage(message);
				bsLeavemessage.setName(name);
				bsLeavemessage.setTelephone(telephone);
				localServiceProxy.insertleavemessage(bsLeavemessage);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		reponseWriter(JSON.toJSONString(flag));
	}
	/**
	 * 意见反馈
	 * @return
	 */
	public String index(){
		return "index";
	}
	/**
	 * 查詢意见反馈
	 */
	public void query(){
		String leavemessagetitle = request.getParameter("leavemessagetitle"); 
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			BsLeavemessage bsLeavemessage = new BsLeavemessage();
			bsLeavemessage.setMessage(leavemessagetitle);
			Pager pager = localServiceProxy.queryleavemessagebyPage(bsLeavemessage,Integer.valueOf(rows), Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
