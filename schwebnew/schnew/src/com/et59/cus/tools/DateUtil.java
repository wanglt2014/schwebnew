package com.et59.cus.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 */
public class DateUtil {
	/**
	 * 日期变换
	 * 
	 * @param MMddyyyy
	 * @return
	 */
	public static Date strToDate(String str) {
		if (null != str && !str.equals("")) {
			Date date = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = format.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		} else {
			return null;
		}
	}

	/**
	 * 日期变换
	 * 
	 * @param MMddyyyy
	 *            HH:MM:ss
	 * @return
	 */
	public static Date strToDateMMDDYYYYHHMMSS(String str) {
		if (null != str && !str.equals("")) {
			Date date = null;
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				date = format.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		} else {
			return null;
		}
	}

	public static String getNowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(new Date());
		return str;
	}

	SimpleDateFormat sdf = new SimpleDateFormat(" yyyy年MM月dd日 ");

	String str = sdf.format(new Date());

	public static void main(String[] args) {
		System.out.println(strToDateMMDDYYYYHHMMSS("2014-4-9 12:21:12"));
	}
}
