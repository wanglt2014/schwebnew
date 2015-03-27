package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsEmail;
import com.et59.cus.domain.entity.ex.BsEmailquery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.DateUtil;

/**
 * 点滴工作室
 * @author liuhaihua
 *
 */
public class EmailAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 邮件查询
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 查询邮件返回json
	 */
	public  void  query(){
		String mailto = request.getParameter("mailto");
		String startdate =request.getParameter("startdate");
		String enddate =request.getParameter("enddate");
		String isactive = request.getParameter("isactive");
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsEmailquery bsemail = new BsEmailquery();
			if(null!=startdate&&!startdate.equals("")){
				bsemail.setStartdate(DateUtil.strToDate(startdate));
			}
			if(null!=enddate&&!enddate.equals("")){
				bsemail.setEnddate(DateUtil.strToDate(enddate));
			}
			if(null!=isactive&&!isactive.equals("all")){
				bsemail.setIsactive(isactive);
			}
			if(null!=mailto&&!mailto.equals("")){
				bsemail.setMailto(mailto);
			}
			Pager pager = localServiceProxy.queryEmailJsonForpage(bsemail,Integer.valueOf(rows),Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询mail
	 * @return
	 */
	public void detail(){
		String id =  request.getParameter("id");
		try {
			BsEmail bsemail= localServiceProxy.queryEmailByIdJson(Long.valueOf(id));
			JSON.toJSONString(bsemail.getMailcontent());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
