package com.et59.cus.action;

import java.io.IOException;

import org.apache.commons.lang.time.DateUtils;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.ex.OpenLogQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.DateUtil;

/**
 * 
 * <p>Title: OpenLogAction.java</p>
 * <p>Description: 开放日志</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-28 下午05:23:18
 * @version 2.0
 *
 */
public class OpenLogAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日誌首頁
	 * @return
	 */
	public String index(){
		return "index";
	}
	/**
	 * 查詢日誌
	 */
	public void query(){
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String appid = request.getParameter("appid");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			OpenLogQuery openLog = new OpenLogQuery();
			if(null!=appid&&!appid.equals("")){
				openLog.setAppid(new Long(appid));
			}
			openLog.setStarttime(DateUtil.strToDateMMDDYYYYHHMMSS(startdate));
			openLog.setEndtime(DateUtil.strToDateMMDDYYYYHHMMSS(enddate));
			Pager pager = localServiceProxy.queryopenLogbyPage(openLog,
					Integer.valueOf(rows), Integer.valueOf(page));
			reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
