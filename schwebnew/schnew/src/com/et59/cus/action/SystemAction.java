package com.et59.cus.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.et59.cus.cache.Cache;
import com.et59.cus.service.LocalService;
import com.et59.cus.service.LocalServiceEX;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * Title: SystemAction.java
 * </p>
 * <p>
 * Description: 系统常量
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-12 下午03:51:35
 * @version 2.0
 *
 */
public class SystemAction extends ActionSupport {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	protected String emailtemplate;
	protected String sitename;
	protected String alipayemail;
	protected String websiteurl;
	@Autowired
	protected LocalService localServiceProxy;
	@Autowired
	protected LocalServiceEX localServiceEXProxy;

	public String getSitename() {
		Object obj = Cache.getCache("sitename");
		if (null == obj) {
			loadCache();
			getSitename();
		}
		return obj.toString();
	}

	public String getWebsiteurl() {
		Object obj = Cache.getCache("websiteurl");
		if (null == obj) {
			loadCache();
			getWebsiteurl();
		}
		return obj.toString();
	}

	public String getEmailtemplate() {
		Object obj = Cache.getCache("emailtemplate");
		if (null == obj) {
			loadCache();
			getEmailtemplate();
		}
		return obj.toString();
	}

	/**
	 * 加载缓存
	 */
	public synchronized void loadCache() {
		try {
			localServiceProxy.cacheSystemConstatnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载卖家账号
	 * 
	 * @return
	 */
	public String getAlipayemail() {
		Object obj = Cache.getCache("alipay_email");
		if (null == obj) {
			loadCache();
			getAlipayemail();
		}
		return obj.toString();
	}
}
