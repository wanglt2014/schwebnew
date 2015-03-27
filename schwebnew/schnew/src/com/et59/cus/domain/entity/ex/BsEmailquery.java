package com.et59.cus.domain.entity.ex;

import java.util.Date;

import com.et59.cus.domain.entity.BsEmail;
/**
 * 查询条件vo
 * @author liuhaihua
 *
 */
public class BsEmailquery extends BsEmail {
	/**
	 * 起始日期
	 */
	public  Date  startdate;
	/**
	 * 结束日期
	 */
	public  Date  enddate;
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
}
