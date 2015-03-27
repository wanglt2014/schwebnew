package com.et59.cus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>Title: EncodingFilter.java</p>
 * <p>Description:解决乱码问题的过滤器 </p>
 * <p>Copyright: 59et Software (c) 2010</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2011-2-14
 * @version 1.0
 *
 */
  public class EncodingFilter implements Filter {

    private String encoding="UTF-8";

	public void init(FilterConfig filterconfig) throws ServletException {
		encoding = filterconfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterchain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding(encoding);
		filterchain.doFilter(request, response);

	}

	public void destroy() {

	}

      }
