package com.et59.cus.action;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsMarking;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;

/**
 * 
 * <p>
 * Title: MarkingAction.java
 * </p>
 * <p>
 * Description: 市场合作
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-22 下午01:41:01
 * @version 2.0
 * 
 */
public class MarkingAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void getxml() {
		try {
			BsMarking bsMarking = new BsMarking();
			Pager pager = localServiceProxy.queryBsMarkingByPage(bsMarking,
					Integer.valueOf(100), 1);
			List<BsMarking> list = (List<BsMarking>) pager.getRows();
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><root >");
			for (BsMarking row : list) {
				if (null == row.getHref() || row.getHref().equals("")) {
					sb.append("<item class=\"" + row.getClassstyle()
							+ "\"  href=\"\" title=\"" + row.getProvince()
							+ "\" >");
				} else {
					sb.append("<item class=\"" + row.getClassstyle()
							+ "\"  href=\"" + row.getHref() + "\" title=\""
							+ row.getProvince() + "\" >");
				}
				sb.append("<![CDATA[<div class=\"box2\">");
				sb.append("<ul class=\"news_content\">");
				sb.append("<li>姓名:" + row.getSaleName() + "</li>");
				sb.append("<li>手机:" + row.getSalePhone() + "</li>");
				sb.append("<li>email:" + row.getSaleEmail() + "</li>");
				sb.append("<li>" + row.getAreaname() + "</li>");
				sb.append("<li>" + row.getRemark() + "</li>");
				sb.append("</ul>");
				sb.append("</div>]]>");
				sb.append("</item>");
			}
			sb.append("</root>");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml");
			String str = JSON.toJSONString(sb);
			System.out.println("json:" + str);
			str = ComonUtil.processSpecialChar(str);
			System.out.println("替换：" + str);
			response.getWriter().print(str.substring(1, str.length() - 1));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 主页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * 查询主页
	 */
	public void query() {
		String markingNamequery = request.getParameter("markingNamequery");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			BsMarking bsMarking = new BsMarking();
			bsMarking.setSaleName(markingNamequery);
			Pager pager = localServiceProxy.queryBsMarkingByPage(bsMarking,
					Integer.valueOf(rows), Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新市场人员
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		BsMarking bsMarking = getBsMarking();
		try {
			bsMarking.setId(Integer.valueOf(id));
			localServiceProxy.updateBsMarking(bsMarking);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新增市场人员
	 */
	public void save() {
		boolean flag = false;
		BsMarking bsMarking = getBsMarking();
		try {
			localServiceProxy.saveBsMarking(bsMarking);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除市场人员
	 */
	public void delete() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteBsMarking(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到市场人员
	 * 
	 * @return
	 */
	public BsMarking getBsMarking() {
		String province = request.getParameter("province");
		String saleName = request.getParameter("saleName");
		String saleQq = request.getParameter("saleQq");
		String saleEmail = request.getParameter("saleEmail");
		String areaname = request.getParameter("areaname");
		String remark = request.getParameter("remark");
		String classstyle = request.getParameter("classstyle");
		String salePhone = request.getParameter("salePhone");
		String href = request.getParameter("href");
		BsMarking bsMarking = new BsMarking();
		bsMarking.setAreaname(areaname);
		bsMarking.setClassstyle(classstyle);
		bsMarking.setHref(href);
		bsMarking.setProvince(province);
		bsMarking.setRemark(remark);
		bsMarking.setSaleEmail(saleEmail);
		bsMarking.setSaleName(saleName);
		bsMarking.setSalePhone(salePhone);
		bsMarking.setSaleQq(saleQq);
		return bsMarking;
	}
}
