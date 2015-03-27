package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.OpenApp;
import com.et59.cus.domain.entity.OpenApp;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.UUIDGenerator;

/**
 * 
 * <p>
 * Title: OpenAppAction.java
 * </p>
 * <p>
 * Description: 应用管理
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-28 上午10:43:43
 * @version 2.0
 * 
 */
public class OpenAppAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 首页
	 */
	public String index() {
		if(getUser().getIsadmin().equals("yes")){
			return "adminindex";
		}else{
			return "index";
		}
	}

	/**
	 * 查询app
	 */
	public void queryApp() {
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			OpenApp openApp = new OpenApp();
			if(!getUser().getIsadmin().equals("yes")){
				openApp.setUserid(getUser().getUserid());
			}
			Pager pager = localServiceProxy.queryAppbyPage(openApp,
					Integer.valueOf(rows), Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑app
	 */
	public void editApp() {
		boolean flag = false;
		String id = request.getParameter("id");
		OpenApp openapp = getOpenApp();
		try {
			openapp.setId(Long.valueOf(id));
			localServiceProxy.editApp(openapp);
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加app
	 */
	public void save() {
		boolean flag = false;
		OpenApp openapp = getOpenApp();
		try {
			String appsecret = UUIDGenerator.generate();
			openapp.setAppsecret(appsecret);
			localServiceProxy.addApp(openapp);
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除app
	 */
	public void deleteApp() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteApp(Long.valueOf(id));
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重置密钥
	 */
	public void resetSecret() {
		boolean flag = false;
		String id = request.getParameter("id");
		OpenApp openapp = getOpenApp();
		try {
			openapp.setId(Long.valueOf(id));
			String appsecret = UUIDGenerator.generate();
			openapp.setAppsecret(appsecret);
			localServiceProxy.editApp(openapp);
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到相关参数
	 * 
	 * @return
	 */
	public OpenApp getOpenApp() {
		OpenApp openApp = new OpenApp();
		try {
			String appname = request.getParameter("appname");
			String appurl = request.getParameter("appurl");
			String appdesc = request.getParameter("appdesc");
			String appsecret = request.getParameter("appsecret");
			String accesscount = request.getParameter("accesscount");
			String appreturnurl = request.getParameter("appreturnurl");
			String isactive = request.getParameter("isactive");
			if(null!=accesscount&&!accesscount.equals("")){
				openApp.setAccesscount(new Long(accesscount));
			}else{
				openApp.setAccesscount(new Long(2000));
			}
			String userid = request.getParameter("userid");
			if(null!=userid&&!userid.equals("")){
				openApp.setUserid(userid);
			}else{
				openApp.setUserid(getUser().getUserid());
			}
			if(null!=isactive&&!isactive.equals("")){
				openApp.setIsactive(isactive);
			}else{
				openApp.setIsactive("no");
			}
			openApp.setAppurl(appurl);
			openApp.setAppsecret(appsecret);
			openApp.setAppreturnurl(appreturnurl);
			openApp.setAppname(appname);
			if(null!=accesscount&&!accesscount.equals("")){
				openApp.setAccesscount(new Long(accesscount));
			}
			openApp.setAppdesc(appdesc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return openApp;
	}
	
}
