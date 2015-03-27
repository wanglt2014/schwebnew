package com.et59.cus.interceptor;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.et59.cus.domain.entity.TjActiontime;
import com.et59.cus.service.LocalService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * <p>
 * Title: TimerInterceptor.java
 * </p>
 * <p>
 * Description:时间拦截器
 * </p>
 * 
 * @date 2014-4-25 下午08:45:34
 * @version 2.0
 *
 */
public class TimerInterceptor extends AbstractInterceptor {
	@Autowired
	protected LocalService localServiceProxy;
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 6017311502566041661L;
	private static final Logger log = Logger.getLogger(TimerInterceptor.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime = System.currentTimeMillis();// 计算开始日期
		String result = invocation.invoke();
		long executionTime = System.currentTimeMillis() - startTime;
		StringBuffer message = new StringBuffer(100);
		TjActiontime tjActiontime = new TjActiontime();
		message.append("Executed action [");
		String namespace = invocation.getProxy().getNamespace();
		if ((namespace != null) && (namespace.trim().length() > 0)) {
			message.append(namespace).append("/");
		}
		message.append(invocation.getProxy().getActionName());
		tjActiontime.setActionName(invocation.getProxy().getActionName());
		message.append("!");
		message.append(invocation.getProxy().getMethod());
		tjActiontime.setActionMethod(invocation.getProxy().getMethod());
		message.append("] took ").append(executionTime).append(" ms.");
		tjActiontime.setExcuteTime(executionTime);
		tjActiontime.setCreatetime(new Date());
		localServiceProxy.insertActionTime(tjActiontime);
		if (log.isInfoEnabled()) {
			log.info(message.toString());
		}
		return result;
	}
}