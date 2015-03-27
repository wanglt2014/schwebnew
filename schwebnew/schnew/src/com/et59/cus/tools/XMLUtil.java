package com.et59.cus.tools;

import com.et59.cus.domain.entity.ex.ReturnMsg;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * <p>
 * Title: XMLUtil.java
 * </p>
 * <p>
 * Description: xml工具类
 * </p>
 *
 */
public class XMLUtil {
	public static void main(String[] args) {
		CodeMsgUtil obj = new CodeMsgUtil();
		XStream xstream = new XStream();
		// xstream.alias("ROOT", CodeMsgUtil.class);
		String xml = xstream.toXML(obj);
		System.out.println(xml);
	}

	/**
	 * 对象转成xml
	 * 
	 * @param obj
	 * @return
	 */
	public static String ReturnMsgChangeTOXml(ReturnMsg returnMsg) {
		XStream xstream = new XStream();
		// xstream.alias("returnMsg", ReturnMsg.class);
		String xml = xstream.toXML(returnMsg);
		return xml;
	}
}
