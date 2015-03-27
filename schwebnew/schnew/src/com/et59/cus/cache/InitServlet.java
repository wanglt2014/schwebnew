package com.et59.cus.cache;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.et59.cus.domain.entity.BsSystem;
import com.et59.cus.service.LocalService;

/**
 * 
 * <p>
 * Title: InitServlet
 * </p>
 * <p>
 * Description: 加载系统常量，并初始化
 * </p>
 * 
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected LocalService localServiceProxy;
	private Logger logger = Logger.getLogger(InitServlet.class);

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		logger.info("*********初始化系统变量*********");
		super.init(servletConfig);
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());
		localServiceProxy = (LocalService) webApplicationContext
				.getBean("localService");
		try {
			localServiceProxy.cacheSystemConstatnt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}