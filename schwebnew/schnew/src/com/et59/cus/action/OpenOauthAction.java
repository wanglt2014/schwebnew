package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.OpenOauth;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.DateUtil;
import com.et59.cus.tools.UUIDGenerator;

/**
 * 
 * <p>Title: OpenAauthAction.java</p>
 * <p>Description: 授权action</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-5-21 下午05:07:18
 * @version 2.0
 *
 */
public class OpenOauthAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回授权管理页面首页
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 查詢授权
	 */
	public void query(){
		String Oauthid = request.getParameter("Oauthid");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			OpenOauth openOauth = new OpenOauth();
			if(null!=Oauthid&&!Oauthid.equals("")){
				openOauth.setAppid(new Long(Oauthid));
			}
			Pager pager = localServiceProxy.queryOpenOauthbyPage(openOauth,
					Integer.valueOf(rows), Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 编辑Oauth
	 */
	public void edit() {
		boolean flag = false;
		String id = request.getParameter("id");
		OpenOauth openOauth = getOpenOauth();
		try {
			openOauth.setId(Long.valueOf(id));
			localServiceProxy.updateOpenOauth(openOauth);
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加Oauth
	 */
	public void save() {
		boolean flag = false;
		OpenOauth openOauth = getOpenOauth();
		try {
			localServiceProxy.insertOpenOauth(openOauth);
			flag = true;
			reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除Oauth
	 */
	public void delete() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteOpenOauth(Long.valueOf(id));
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
	public OpenOauth getOpenOauth() {
		OpenOauth openOpenOauth = new OpenOauth();
		try {
			String appid = request.getParameter("appid");
			String code = request.getParameter("code");
			String accessToken = request.getParameter("accessToken");
			String userid = request.getParameter("userid");
			String accessAuth = request.getParameter("accessAuth");
			String tokenExpires = request.getParameter("tokenExpires");
			String codeIsactive = request.getParameter("codeIsactive");
			String tokenIsactive = request.getParameter("tokenIsactive");
			String uptime = request.getParameter("uptime");
			openOpenOauth.setAppid(new Long(appid));
			openOpenOauth.setAccessToken(accessToken);
			openOpenOauth.setAccessAuth(accessAuth);
			openOpenOauth.setCodeIsactive(codeIsactive);
			openOpenOauth.setUserid(userid);
			openOpenOauth.setUptime(DateUtil.strToDate(uptime));
			openOpenOauth.setTokenIsactive(tokenIsactive);
			openOpenOauth.setTokenExpires(new Long(tokenExpires));
			openOpenOauth.setCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return openOpenOauth;
	}
}
