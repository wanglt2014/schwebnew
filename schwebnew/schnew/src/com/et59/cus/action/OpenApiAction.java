package com.et59.cus.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.OpenApi;
import com.et59.cus.domain.entity.OpenApp;
import com.et59.cus.domain.entity.OpenOauth;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.domain.entity.ex.ReturnMsg;
import com.et59.cus.tools.CodeMsgUtil;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.UUIDGenerator;

/**
 * 
 * <p>
 * Title: OpenApiAction.java
 * </p>
 * <p>
 * Description: 开发API管理
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-26 上午11:57:43
 * @version 2.0
 * 
 */
public class OpenApiAction extends BaseAction {
	private OpenApi openApi;
	private OpenApp openApp;
	private String appid;
	private ReturnMsg returnMsg;
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	public String apiindex() {
		return "apiindex";
	}

	/**
	 * 查询开发api左侧菜单
	 */
	public void query() {
		String jsonstr = "";
		try {
			jsonstr = localServiceProxy.getOpenApiJsonstr();
			reponseWriter(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询详细api信息
	 */
	public String queryApiDetail() {
		String id = request.getParameter("id");
		try {
			openApi = localServiceProxy.queryApiDetailByID(new Long(id));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "api_show";
	}

	/**
	 * 查詢api
	 */
	public void queryapi() {
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		String openapiname = request.getParameter("openapiname");
		try {
			OpenApi openApi = new OpenApi();
			openApi.setText(openapiname);
			Pager pager = localServiceProxy.queryApibyPage(openApi,
					Integer.valueOf(rows), Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存api
	 */
	public void save() {
		boolean flag = false;
		OpenApi openApi = getOpenApiObj();
		try {
			localServiceProxy.saveOpenApi(openApi);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑api
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		OpenApi openApi = getOpenApiObj();
		openApi.setId(Long.valueOf(id));
		try {
			localServiceProxy.updateOpenApi(openApi);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法
	 * 
	 * @return
	 */
	public OpenApi getOpenApiObj() {
		String text = request.getParameter("text");
		String apiurl = request.getParameter("apiurl");
		String apitype = request.getParameter("apitype");
		String httptype = request.getParameter("httptype");
		String parent = request.getParameter("parent");
		String apidesc = request.getParameter("apidesc");
		OpenApi openApi = new OpenApi();
		openApi.setApidesc(apidesc);
		openApi.setApitype(apitype);
		openApi.setParent(new Long(parent));
		openApi.setHttptype(httptype);
		openApi.setApiurl(apiurl);
		openApi.setText(text);
		return openApi;
	}

	/**
	 * 删除api
	 */
	public void deleteOpenApi() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteOpenApi(Long.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 授权接口
	 */
	public String authorize() {
		returnMsg = new ReturnMsg();
		try {
			appid = request.getParameter("appid");
			if (ComonUtil.validateEmptyForString(appid)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.APPID_NULL_CODE,
						CodeMsgUtil.APPID_NULL_MSG);
				reponseWriterMobile(returnMsg);
			} else {
				openApp = localServiceProxy.queryApp(new Long(appid));
				returnMsg.setMsgAndCode("", "");
				getSession().put("openApp", openApp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "authorize";
	}

	/**
	 * 登陆
	 */
	@SuppressWarnings({ "rawtypes" })
	public String dologin() {
		openApp = (OpenApp) getSession().get("openApp");
		Map<String, Object> session = context.getSession();
		String str = "authorize";
		BsUser sessionuser = (BsUser) session.get("user");
		if (null == sessionuser) {
			BsUser userobj = new BsUser();
			try {
				userobj.setUsername(idNumber);
				userobj.setPassword(password);
				userobj.setIsadmin("no");
				String randomcode = (String) session.get("RANDOMIMAGES");
				log.info("checkcode|randomcode:" + checkcode + "|" + randomcode);
				if (randomcode.equalsIgnoreCase(checkcode)) {
					Map map = localServiceProxy.queryUsername(userobj);
					if (ComonUtil.validateMapResult(map)) {
						BsUser user1 = (BsUser) map.get(Constant.USER);
						log.debug("授权登录成功");
						str = "connect";
						showMessage = "";
						session.put("user", user1);
					} else {
						log.debug("授权登录登陆失败!");
						showMessage = "用户名或者密码不正确!";
					}
				} else {
					showMessage = "验证码不正确!";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			str = "connect";
		}
		return str;
	}

	/**
	 * 授权接口生成code
	 */
	public void connect() {
		OpenApp app = (OpenApp) getSession().get("openApp");
		String[] checkbox = request.getParameterValues("accessauth");
		try {
			if (isLogin()) {
				String code = UUIDGenerator.generate();
				// 插入授权表
				OpenOauth openOauth = new OpenOauth();
				openOauth.setAppid(app.getId());
				openOauth.setUserid(getUser().getUserid());
				openOauth.setCodeIsactive(Constant.ISACTIVE_NO);
				// 查询是否存在未使用的code,如果有责直接返回给用户，否则创建新的纪录
				List<OpenOauth> list = localServiceProxy
						.queryOpenOauth(openOauth);
				if (null != list && list.size() > 0) {
					OpenOauth openOauth_update = list.get(0);
					code = openOauth_update.getCode();
					openOauth_update.setAccessAuth(checkbox.toString());
					localServiceProxy.updateOpenOauth(openOauth_update);
				} else {
					openOauth.setCode(code);
					openOauth.setAccessAuth(checkbox.toString());
					localServiceProxy.insertOpenOauth(openOauth);
				}
				// 跳转到回调地址,带上参数
				String url = app.getAppreturnurl() + "?code=" + code;
				response.sendRedirect(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取accesstoken
	 */
	public void getAccessToken() {
		ReturnMsg returnMsg = new ReturnMsg();
		String refreshaccesstoken = request.getParameter("refreshaccesstoken");
		String code = request.getParameter("code");
		String appid = request.getParameter("appid");
		String appsecret = request.getParameter("appsecret");
		try {
			// 验证参数是否合法
			if (ComonUtil.validateEmptyForString(code)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.CODE_INVALID_CODE,
						CodeMsgUtil.CODE_INVALID_MSG);
			} else if (ComonUtil.validateEmptyForString(appid)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.APPID_NULL_CODE,
						CodeMsgUtil.APPID_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(appsecret)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.APPSECRET_NULL_CODE,
						CodeMsgUtil.APPSECRET_NULL_MSG);
			} else {
				// 验证应用是否合法
				OpenApp openApp = localServiceProxy.queryApp(new Long(appid));
				if (openApp.getAppsecret().equals(appsecret)) {
					OpenOauth openOauth = new OpenOauth();
					openOauth.setAppid(new Long(appid));
					openOauth.setUserid(getUser().getUserid());
					openOauth.setCode(code);
					openOauth.setCodeIsactive(Constant.ISACTIVE_NO);
					List<OpenOauth> list = localServiceProxy
							.queryOpenOauth(openOauth);
					if (null != list && list.size() > 0) {
						if (null != refreshaccesstoken
								&& !refreshaccesstoken.equals("")) {
							// 刷新token
							openOauth.setCodeIsactive(Constant.ISACTIVE_YES);
							openOauth.setAccessAuth(refreshaccesstoken);
							List<OpenOauth> listrefresh = localServiceProxy
									.queryOpenOauth(openOauth);
							OpenOauth openOauth_refresh = listrefresh.get(0);
							openOauth_refresh.setUptime(new Date());
							localServiceProxy
									.updateOpenOauth(openOauth_refresh);
							returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
									CodeMsgUtil.SUCCESS_MSG, openOauth_refresh);
						} else {
							// 获取acceeetoken
							OpenOauth openOauth_update = list.get(0);
							String accesstoken = UUIDGenerator.generate();
							openOauth_update.setUptime(new Date());
							openOauth_update.setAccessToken(accesstoken);
							openOauth_update
									.setCodeIsactive(Constant.ISACTIVE_YES);
							openOauth_update
									.setTokenExpires(Constant.TOKEN_EXPIRES);
							localServiceProxy.updateOpenOauth(openOauth_update);
							returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
									CodeMsgUtil.SUCCESS_MSG, openOauth_update);
						}

					} else {
						// 无效没有该记录，请求无效
						returnMsg.setMsgAndCode(CodeMsgUtil.CODE_INVALID_CODE,
								CodeMsgUtil.CODE_INVALID_MSG);
					}

				} else {
					// 应用验证失败
					returnMsg.setMsgAndCode(CodeMsgUtil.APP_INVALID_CODE,
							CodeMsgUtil.APP_INVALID_MSG);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	public OpenApi getOpenApi() {
		return openApi;
	}

	public void setOpenApi(OpenApi openApi) {
		this.openApi = openApi;
	}

	public OpenApp getOpenApp() {
		return openApp;
	}

	public void setOpenApp(OpenApp openApp) {
		this.openApp = openApp;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public ReturnMsg getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(ReturnMsg returnMsg) {
		this.returnMsg = returnMsg;
	}

}
