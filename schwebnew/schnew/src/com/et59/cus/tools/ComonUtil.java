package com.et59.cus.tools;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * <p>
 * Title: ComonUtil.java
 * </p>
 * 
 * @version 2.0
 * 
 */
public class ComonUtil {
	/**
	 * 校验返回结果
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validateMapResult(Map map) {
		int result = (Integer) map.get(Constant.ACTION_RESULT);
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 检查string是否为空
	 */
	public static boolean validateEmptyForString(String str) {
		if (null == str || str.equals("") || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 校验list是否为空
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validateEmptyForList(List list) {
		if (null == list || list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 计算页数
	 * 
	 * @param totalcount
	 * @return
	 */
	public static int computusTotalPage(int totalcount, int pagesize) {
		int totalPage = totalcount % pagesize != 0 ? totalcount / pagesize + 1
				: totalcount / pagesize;
		return totalPage;
	}

	/**
	 * 取时间
	 */
	public static Date getDate(int addmonth) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, addmonth);
		return c.getTime();
	}

	/***
	 * 得到订单的唯一id 订单号=用户编号+当前时间(17)+4位随机数+增长序列号
	 * 
	 * @return
	 */
	public static String getUserId() {
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat fmtrq = new SimpleDateFormat("MMddhhmmssSSS",
				Locale.CHINA);
		String nowDate = fmtrq.format(now.getTime());
		return nowDate;

	}

	public static Date getAddDate(Date currentdate, int addmonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(currentdate);
		c.add(Calendar.MONTH, addmonth);
		return c.getTime();
	}

	/**
	 * 主函数
	 * 
	 * @param args
	 * @return
	 */
	public static void main(String[] args) {
		/*
		 * int totalcount =20; int pagesize = 10; int totalPage =
		 * computusTotalPage(totalcount,pagesize);
		 */
		// System.out.println("ssssssssssssss---->:"+getUserId());
		String aa = "璐拱浜у搧锛氱幆鐞冩梾娓�";

		try {
			String ssa = new String(aa.getBytes(), "UTF-8");
			System.out.println(ssa);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 消除转义字符
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String processSpecialChar(String inputStr) {
		return inputStr.replace("\\", "");
	}

	/**
	 * 空字符串转0
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String emptyToZero(String inputStr) {
		if ("".equals(inputStr) || null == inputStr) {
			return "0";
		} else {
			return inputStr;
		}

	}
}
