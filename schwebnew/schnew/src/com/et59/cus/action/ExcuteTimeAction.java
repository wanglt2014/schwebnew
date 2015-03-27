package com.et59.cus.action;

import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.TjActiontime;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 
 * <p>
 * Title: ExcuteTimeAction.java
 * </p>
 * <p>
 * Description: action执行时间统计
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-5 下午02:51:30
 * @version 2.0
 * 
 */
public class ExcuteTimeAction extends BaseAction {
	private String fileName;
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2119735800546476969L;

	/**
	 * top10最慢接口
	 * 
	 * @return
	 */
	public String index() {
		genenateImage();
		return "index";
	}

	/**
	 * 生成图标
	 */
	public void genenateImage() {
		TjActiontime tjActiontime = new TjActiontime();
		try {
			List<TjActiontime> list = localServiceProxy
					.queryActionTime(tjActiontime);
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (TjActiontime row : list) {
				dataset.addValue(row.getExcuteTime(), row.getCreatetime(),
						row.getActionName() + "(" + row.getActionMethod() + ")");
			}
			JFreeChart chart = ChartFactory.createBarChart3D(
					"Action执行时间监控统计", // 图表标题
					"执行Action方法", // 目录轴的显示标签x
					"执行时间(单位:ms)", // 数值轴的显示标签y
					dataset, // 数据集
					PlotOrientation.VERTICAL, // 图表方向：水平、垂直
					true, // 是否显示图例(对于简单的柱状图必须是 false)
					false, // 是否生成工具
					false // 是否生成 URL 链接
					);
			fileName = ServletUtilities.saveChartAsPNG(chart, 700, 550,
					httpsession);
			// ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 查询page
	 */
	public void query() {
		TjActiontime tjActiontime = new TjActiontime();
		Pager page = new Pager();
		List<TjActiontime> list;
		try {
			list = localServiceProxy.queryActionTime(tjActiontime);
			page.setRows(list);
			page.setTotal(list.size());
			super.reponseWriter(JSON.toJSONString(page));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
