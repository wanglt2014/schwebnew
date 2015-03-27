package com.et59.cus.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.et59.cus.domain.entity.BsEmail;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.ex.BsUserJson;
import com.et59.cus.domain.entity.ex.News;
import com.et59.cus.domain.entity.ex.Qa;
import com.et59.cus.domain.entity.ex.SuccessFailPage;
import com.et59.cus.mail.MailSenderInfo;
import com.et59.cus.mail.ReadReplaceFile;
import com.et59.cus.mail.SimpleMailSender;
import com.et59.cus.mail.TemplateVO;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.JsonUtil;
import com.et59.cus.tools.UUIDGenerator;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: LoginAction
 * @Description: 登陆类
 * @date 2014-3-21 下午12:37:49
 * 
 */
public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	private String loginPwd2;
	private String tokenId;
	private String mode;
	private String remark;
	/** 找回密码或注册激活时，邮件中的随机串 */
	private String ran;

	/** 邮件中传递的用户名 */
	private String confirmUser;

	/** 确认邮件id */
	private String userEmailId;

	/** 新闻Id */
	private String newsId;

	/** 新闻实体 */
	private News newItem;

	/** 常见问题列表 */
	private List<Qa> qaList;

	private String loginError;
	private String loginStatus;
	private String idType;

	private String validate;// 校验码
	/** 网站域名和协议头 ，如: http://www.59et.com */

	private String email;
	private String mobilephone;
	private String firstpassword;
	private String secondpassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getFirstpassword() {
		return firstpassword;
	}

	public void setFirstpassword(String firstpassword) {
		this.firstpassword = firstpassword;
	}

	public String getSecondpassword() {
		return secondpassword;
	}

	public void setSecondpassword(String secondpassword) {
		this.secondpassword = secondpassword;
	}

	public String init() {
		if (log.isDebugEnabled()) {
			log.debug("init 初始化。。。");
		}
		loginError = "";
		super.commonquery();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("user") != null) {
			// 查询账户余额
			if (log.isDebugEnabled()) {
				log.debug("user对象不为空");
			}
		}
		return "index";
	}

	public String newsDetail() {
		// newItem = CommonUtil.getNews(newsId);
		return "news_detail";
	}

	public String question() {
		// qaList = CommonUtil.getQaList();
		return "question";
	}

	public String toLogin() {
		super.commonquery();
		return "to_login";
	}

	/**
	 * 登陆
	 */
	@SuppressWarnings({ "rawtypes" })
	public void login() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (log.isDebugEnabled()) {
			log.debug("登陆方法!");
		}
		BsUser userobj = new BsUser();
		try {
			userobj.setUsername(idNumber);
			userobj.setPassword(password);
			userobj.setIsadmin("no");
			Map map = localServiceProxy.queryUsername(userobj);
			if (ComonUtil.validateMapResult(map)) {
				BsUser user1 = (BsUser) map.get(Constant.USER);
				loginSuccess();
				loginStatus = "0";// 登录成功
				if (log.isDebugEnabled()) {
					log.debug("登录成功");
				}
				loginError = "";
				session.put("user", user1);
			} else {
				loginFailed();
				loginStatus = "1";// 登录失败
				if (log.isDebugEnabled()) {
					log.debug("登陆失败!");
				}
			}
			reponseWriter(loginStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 跳转到sumpay登录页
	 * 
	 * @return
	 */
	public String directSumapay() {
		return "directSumapay";
	}

	/**
	 * 跳转到联系我们页面
	 * 
	 * @return
	 */
	public String linkus() {
		return "linkus";
	}

	/**
	 * 跳转到team.jsp
	 * 
	 * @return
	 */
	public String team() {
		return "team";
	}

	/**
	 * 跳转到招聘页面
	 * 
	 * @return
	 */
	public String job() {
		return "job";
	}

	@SuppressWarnings("unused")
	private boolean checkValidate() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (null != session.get("SHOW_VALIDATE")
				&& String.valueOf(session.get("SHOW_VALIDATE")).equals("Y")) {
			if (null == session.get("LOGIN_VALIDATE_NUM")) {
				return false;
			}
			String oldStr = (String) session.get("LOGIN_VALIDATE_NUM");
			if (oldStr.equals(validate)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * 登录失败3次，显示验证码
	 */
	private void loginFailed() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (null == session.get("FAILED_COUNT")) {
			session.put("FAILED_COUNT", 1);
		} else {
			int count = (Integer) session.get("FAILED_COUNT");
			count++;
			if (count >= 3) {
				session.put("SHOW_VALIDATE", "Y");
			}
			session.put("FAILED_COUNT", count);
		}
	}

	/**
	 * 登陆成功
	 */
	private void loginSuccess() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("FAILED_COUNT");
		session.remove("SHOW_VALIDATE");
	}

	/**
	 * 退出登陆
	 * 
	 * @return
	 */
	public String logout() {
		if (log.isDebugEnabled()) {
			log.debug("logout 退出。。。");
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		loginStatus = "1";
		loginError = "";
		return toLogin();
	}

	/***
	 * 从支付宝过来自动登录接口
	 * 
	 * @return
	 */
	public String autoLogin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		log.info("缴费平台收到获取用户从支付宝自动登录到缴费平台的请求");
		String tokenId = request.getParameter("tokenId");
		this.tokenId = tokenId;
		acceptSuccessNotify();
		return "index";

	}

	/***
	 * 接受成功消息
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String acceptSuccessNotify() {

		// GetMethod getMethod=null;
		try {
			/*
			 * HttpClient httpClient=new HttpClient();
			 * httpClient.getHttpConnectionManager
			 * ().getParams().setConnectionTimeout(60000);
			 * httpClient.getHttpConnectionManager
			 * ().getParams().setSoTimeout(60000); String
			 * url=""+queryUseInfoURl+"?tokenId="+tokenId+"&merchant="+merchant;
			 * getMethod = new GetMethod(url); int statusCode =
			 * httpClient.executeMethod(getMethod); if(statusCode ==
			 * HttpStatus.SC_OK){ if(log.isDebugEnabled()){
			 * log.debug("缴费平台发送获取用户信息指令成功!"); } }else{
			 * if(log.isDebugEnabled()){ log.debug("缴费平台发送获取用户信息指令失败!"); } }
			 * String charSet = getMethod.getResponseCharSet(); //响应的字符编码 byte[]
			 * responseBody = getMethod.getResponseBody(); // 读取内容
			 * System.out.println("缴费平台responseCode:\r\n" + statusCode);
			 * System.out.println("缴费平台charSet:\r\n" + charSet);
			 * System.out.println("缴费平台response:\r\n" + new String(responseBody,
			 * charSet)); //获取json加密串，对json解密 String encstr = new
			 * String(responseBody, charSet); String jsonstr =
			 * DecAndEncUtil.decryptedData(encstr, aKey.getBytes());
			 */

			// 模拟 程序
			String jsonstr = "{\"tokenId\":\"JF20120503105309904\",\"att1_Name\":\"yanghai@dvt.dvt.com\",\"att2_RealName\":\"yanghai@dvt.dvt.com\",\"att3_Email\":\"yanghai@dvt.dvt.com\",\"att4_Mobile\":\"null\"}";
			log.debug("缴费平台得到的用户信息!" + jsonstr);
			BsUserJson bsUserJson = (BsUserJson) JsonUtil.getObject4JsonString(
					jsonstr, BsUserJson.class);

			// 先查询是否存在令牌用户

			Map map = null;
			BsUser userobj = new BsUser();
			userobj.setUsername(bsUserJson.getAtt1_Name());
			map = localServiceProxy.queryUsername(userobj);
			log.info("缴费平台查询用户信息map--------------->:" + map);
			if (ComonUtil.validateMapResult(map)) {
				BsUser user1 = (BsUser) map.get(Constant.USER);
				if (null != bsUserJson.getTokenId()) {
					user1.setTokenid(bsUserJson.getTokenId());
				}
				if (null != bsUserJson.getAtt3_Email()) {
					user1.setEmail(bsUserJson.getAtt3_Email());
				}
				if (null != bsUserJson.getAtt4_Mobile()) {
					user1.setMobilephone(bsUserJson.getAtt4_Mobile());
				}
				if (null != bsUserJson.getAtt1_Name()) {
					user1.setUsername(bsUserJson.getAtt1_Name());
				}
				if (null != bsUserJson.getAtt2_RealName()) {
					user1.setRealname(bsUserJson.getAtt2_RealName());
				}
				map = localServiceProxy.updateUser(user1, "");
				log.info("缴费平台更新用户信息--------------->:" + map);
				if (ComonUtil.validateMapResult(map)) {
					idNumber = bsUserJson.getTokenId();
					login();
				}
			} else {
				log.info("缴费平台创建用户信息--------------->:" + map);
				BsUser user1 = new BsUser();
				user1.setUserid(ComonUtil.getUserId());
				if (null != bsUserJson.getTokenId()) {
					user1.setTokenid(bsUserJson.getTokenId());
				}
				if (null != bsUserJson.getAtt3_Email()) {
					user1.setEmail(bsUserJson.getAtt3_Email());
				}
				if (null != bsUserJson.getAtt4_Mobile()) {
					user1.setMobilephone(bsUserJson.getAtt4_Mobile());
				}
				if (null != bsUserJson.getAtt1_Name()) {
					user1.setUsername(bsUserJson.getAtt1_Name());
				}
				if (null != bsUserJson.getAtt2_RealName()) {
					user1.setRealname(bsUserJson.getAtt2_RealName());
				}
				map = localServiceProxy.createUser(user1, "");
				if (ComonUtil.validateMapResult(map)) {
					super.idNumber = bsUserJson.getTokenId();
					login();
				}
			}
			/*
			 * Header headers[] = getMethod.getResponseHeaders(); for(int i = 0;
			 * i < headers.length; i ++) { System.out.println(headers[i]); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			log.debug("缴费平台获取用户信息失败,原因:" + e.getMessage());
		} finally {
			// getMethod.releaseConnection();
		}
		return "index";
	}

	/**
	 * @Title: regUser
	 * @Description: (注册用户)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public void regUser() {
		boolean flag = false;
		user = new BsUser();
		user.setMobilephone(mobilephone);
		user.setEmail(email);
		user.setUserid(ComonUtil.getUserId());
		user.setPassword(firstpassword);
		user.setUsername(email);
		user.setIsadmin("no");
		try {
			Map result = localServiceProxy.createUser(user, "");
			if (ComonUtil.validateMapResult(result)) {
				flag = true;
			}
			response.getWriter().print(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/***
	 * 接受失败消息
	 * 
	 * @return
	 */
	public String acceptFailNotify() {
		return "error";
	}

	/**
	 * 通过邮箱找回密码
	 * 
	 * @return
	 */
	public String findPasswordByEmail() {
		return "findPassword";
	}

	/**
	 * 用户是否登录
	 */
	public void isUserLogin() {
		BsUser userobj = getUser();
		if (null == userobj) {
			super.reponseWriter("");
		} else {
			super.reponseWriter(userobj.getUsername());
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public void sendmail() {
		HttpSession hs = request.getSession();
		System.out.println("hs.getId();" + hs.getId() + "|"
				+ context.getSession());
		String flag = "0";
		String email = request.getParameter("email");
		String checkcode = request.getParameter("checkcode");
		String randomcode = (String) context.getSession().get("RANDOMIMAGES");
		log.info("checkcode|randomcode:" + checkcode + "|" + randomcode);
		if (randomcode.equals(checkcode)) {// 验证码相等才能发送
			user = new BsUser();
			user.setEmail(email);

			try {
				Map result = localServiceProxy.queryUserbyEmail(user);
				if (ComonUtil.validateMapResult(result)) {
					user = (BsUser) result.get(Constant.USER);
					MailSenderInfo mailInfo = getDefaultMailSenderInfo();
					mailInfo.setToAddress(user.getEmail());
					mailInfo.setSubject("密码找回");
					TemplateVO templateVO = new TemplateVO();
					templateVO.setUsername(user.getUsername());
					templateVO.setEmail(user.getEmail());
					String code = UUIDGenerator.generate();
					String encryptedStr = email + "|" + code;// 邮箱+"|"+UUID
					String url = getWebsiteurl() + "/Login_vertifyEmail?param="
							+ java.net.URLEncoder.encode(encryptedStr);
					System.out.println("url:" + url);
					templateVO.setUrl(url);
					ReadReplaceFile.path = getEmailtemplate() + "reg_template";
					String content = ReadReplaceFile
							.replaceTemplateByStr(templateVO);
					mailInfo.setContent(content);
					/**
					 * 插入邮件表里面
					 */
					BsEmail bsEmail = new BsEmail();
					bsEmail.setMailto(user.getEmail());
					bsEmail.setCode(code);
					bsEmail.setCreatetime(new Date());
					bsEmail.setMailcontent(content);
					bsEmail.setIsactive(Constant.ISACTIVE_NO);
					localServiceProxy.insertEmail(bsEmail);
					SimpleMailSender sms = new SimpleMailSender();
					sms.sendHtmlMail(mailInfo);// 发送html格式
					flag = "1";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			flag = "2";
		}
		try {
			response.setContentType("text/html");
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 验证邮箱
	 */
	@SuppressWarnings("rawtypes")
	public String vertifyEmail() {
		successFailPage = new SuccessFailPage();
		successFailPage.setPage_failmeessage("尊敬的客户你好:你的邮件验证未通过,请重新发送验证邮件!");
		successFailPage.setPage_title("邮件验证未通过");
		String flag = "vertifyemail_error";
		String param = java.net.URLDecoder
				.decode(request.getParameter("param"));
		try {
			if (ComonUtil.validateEmptyForString(param)) {
				flag = "vertifyemail_error";
			} else {
				String[] str = param.split("\\|");
				String email = str[0];
				String code = str[1];
				System.out.println("email|code:" + email + ":" + code);
				try {
					BsEmail bsEmail = new BsEmail();
					bsEmail.setCode(code);
					bsEmail.setMailto(email);
					bsEmail.setIsactive(Constant.ISACTIVE_NO);
					Map resultemail = localServiceProxy.queryEmail(bsEmail);
					if (ComonUtil.validateMapResult(resultemail)) {
						BsEmail updateemail = (BsEmail) resultemail
								.get(Constant.EMAIL);
						updateemail.setIsactive(Constant.ISACTIVE_YES);
						if (ComonUtil.validateMapResult(localServiceProxy
								.updateEmail(updateemail))) {// 更新成功后才能更改密码
							user = new BsUser();
							user.setEmail(email);
							Map result = localServiceProxy
									.queryUserbyEmail(user);
							if (ComonUtil.validateMapResult(result)) {
								user = (BsUser) result.get(Constant.USER);
								user.setPassword(Constant.DEFAULT_PASSWORD);
								localServiceProxy.updateUser(user, "");
								successFailPage = new SuccessFailPage();
								successFailPage
										.setPage_successmessage("尊敬的客户你好:你的邮件验证通过,登录账号["
												+ user.getUsername()
												+ "],密码重置为[123456]!请登录到个人中心修改密码!");
								successFailPage.setPage_title("邮件验证通过");
								flag = "vertifyemail_suceess";
							}
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return flag;
	}

	public String getRan() {
		return ran;
	}

	public void setRan(String ran) {
		this.ran = ran;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public String getLoginPwd2() {
		return loginPwd2;
	}

	public void setLoginPwd2(String loginPwd2) {
		this.loginPwd2 = loginPwd2;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public News getNewItem() {
		return newItem;
	}

	public void setNewItem(News newItem) {
		this.newItem = newItem;
	}

	public List<Qa> getQaList() {
		return qaList;
	}

	public void setQaList(List<Qa> qaList) {
		this.qaList = qaList;
	}

	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
