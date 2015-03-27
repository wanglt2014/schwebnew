package com.et59.cus.domain.entity.ex;

import java.util.Date;

import com.et59.cus.domain.entity.OpenLog;
/**
 * 
 * <p>Title: OpenLogQuery.java</p>
 * <p>Description:日志查询类</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-29 上午11:04:01
 * @version 2.0
 *
 */
public class OpenLogQuery extends OpenLog {
	private  Date starttime;
	private Date endtime;
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
}
