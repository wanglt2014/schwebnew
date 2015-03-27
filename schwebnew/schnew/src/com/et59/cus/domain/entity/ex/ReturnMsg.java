package com.et59.cus.domain.entity.ex;

/**
 * 
 * <p>
 * Title: ReturnMsg.java
 * </p>
 * <p>
 * Description: 返回的消息
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-5-5 上午10:37:37
 * @version 2.0
 * 
 */
public class ReturnMsg {
	/**
	 * 返回的消息
	 */
	public  String msg;
	/**
	 * 返回的代码
	 */
	public  String code;
	/**
	 * 返回的对象
	 */
	public  Object obj;

	public  void setMsg(String msg) {
		this.msg = msg;
	}

	public  void setCode(String code) {
		this.code = code;
	}
	public  void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * 设置code和msg
	 */
	public  void setMsgAndCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 设置全信息
	 * 
	 * @param code
	 * @param msg
	 * @param Obj
	 */
	public  void setAllReturnMsg(String code, String msg, Object obj) {
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	public Object getObj() {
		return obj;
	}

	

}
