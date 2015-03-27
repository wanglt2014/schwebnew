package com.et59.cus.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.et59.cus.alipay.config.AlipayConfig;
import com.et59.cus.alipay.util.AlipayNotify;
import com.et59.cus.alipay.util.AlipaySubmit;
import com.et59.cus.cache.Cache;
import com.et59.cus.domain.entity.ex.SuccessFailPage;

/**
 * 
 * <p>
 * Title: PayAction.java
 * </p>
 * <p>
 * Description:支付系统
 * </p>
 * 
 */
public class PayAction extends BaseAction {
	private static Logger log = Logger.getLogger(PayAction.class);
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	public String index(){
		return "index";
	}
	public void alipayapi() {
		// 支付类型
		String payment_type = "1";
		// 必填，不能修改
		// 服务器异步通知页面路径
		//String notify_url = "http://125.35.15.73/pay/Pay_notifyurl";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数
		// 页面跳转同步通知页面路径
		//String return_url = "http://125.35.15.73/pay/Pay_returnurl";
		// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		// 卖家支付宝帐户
		String seller_email;
		try {
			seller_email = new String(request.getParameter("WIDseller_email")
					.getBytes("UTF-8"), "UTF-8");

			// 必填
			// 商户订单号
			String out_trade_no = new String(request.getParameter(
					"WIDout_trade_no").getBytes("UTF-8"),
					"UTF-8");
			// 商户网站订单系统中唯一订单号，必填
			// 订单名称
			String subject = new String(request.getParameter("WIDsubject")
					.getBytes("UTF-8"), "UTF-8");
			// 必填
			// 付款金额
			String price = new String(request.getParameter("WIDprice")
					.getBytes("UTF-8"), "UTF-8");
			// 必填
			// 商品数量
			String quantity = "1";
			// 必填，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品
			// 物流费用
			String logistics_fee = "0.00";
			// 必填，即运费
			// 物流类型
			String logistics_type = "EXPRESS";
			// 必填，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
			// 物流支付方式
			String logistics_payment = "SELLER_PAY";
			// 必填，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
			// 订单描述
			String body = new String(request.getParameter("WIDbody").getBytes(
					"UTF-8"), "UTF-8");
			// 商品展示地址
			String show_url = new String(request.getParameter("WIDshow_url")
					.getBytes("UTF-8"), "UTF-8");
			// 收货人姓名
			String receive_name = new String(request.getParameter(
					"WIDreceive_name").getBytes("UTF-8"), "UTF-8");
			// 收货人地址
			String receive_address = new String(request.getParameter(
					"WIDreceive_address").getBytes("UTF-8"), "UTF-8");
			// 收货人邮编
			String receive_zip = new String(request.getParameter(
					"WIDreceive_zip").getBytes("UTF-8"), "UTF-8");
			// 收货人电话号码
			String receive_phone = new String(request.getParameter(
					"WIDreceive_phone").getBytes("UTF-8"), "UTF-8");
			// 收货人手机号码
			String receive_mobile = new String(request.getParameter(
					"WIDreceive_mobile").getBytes("UTF-8"), "UTF-8");
			// 把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "create_partner_trade_by_buyer");
			sParaTemp.put("partner", AlipayConfig.partner);
			sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("payment_type", payment_type);
			sParaTemp.put("notify_url", Cache.getCache("alipay_notify_url").toString());
			sParaTemp.put("return_url", Cache.getCache("alipay_return_url").toString());
			sParaTemp.put("seller_email", seller_email);
			sParaTemp.put("out_trade_no", out_trade_no);
			sParaTemp.put("subject", subject);
			sParaTemp.put("price", price);
			sParaTemp.put("quantity", quantity);
			sParaTemp.put("logistics_fee", logistics_fee);
			sParaTemp.put("logistics_type", logistics_type);
			sParaTemp.put("logistics_payment", logistics_payment);
			sParaTemp.put("body", body);
			sParaTemp.put("show_url", show_url);
			sParaTemp.put("receive_name", receive_name);
			sParaTemp.put("receive_address", receive_address);
			sParaTemp.put("receive_zip", receive_zip);
			sParaTemp.put("receive_phone", receive_phone);
			sParaTemp.put("receive_mobile", receive_mobile);

			// 建立请求
			String sHtmlText = AlipaySubmit
					.buildRequest(sParaTemp, "get", "确认");
			log.info(sHtmlText);
			reponseWriter(sHtmlText);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/* *
	 * 功能：支付宝服务器异步通知页面 版本：3.3 日期：2012-08-17 说明：
	 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	 * 
	 * //***********页面功能说明*********** 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
	 * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
	 * 该页面调试工具请使用写文本函数logResult，该函数在com.alipay.util文件夹的AlipayNotify.java类文件中
	 * 如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
	 * //********************************
	 */
	public void notifyurl() {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("UTF-8"), "gbk");
			params.put(name, valueStr);
		}

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号

		try {
			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("UTF-8"),
					"UTF-8");

			// 支付宝交易号

			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("UTF-8"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter(
					"trade_status").getBytes("UTF-8"), "UTF-8");

			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			boolean falg =AlipayNotify.verify(params);
			if (falg) {// 验证成功
				// ////////////////////////////////////////////////////////////////////////////////////////
				// 请在这里加上商户的业务逻辑程序代码
				if (trade_status.equals("WAIT_BUYER_PAY")) {
					// 该判断表示买家已在支付宝交易管理中产生了交易记录，但没有付款
					localServiceProxy.updateOrder(out_trade_no, trade_no, 1);
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（response.getWriter()_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					reponseWriter("success"); // 请不要修改或删除
				} else if (trade_status.equals("WAIT_SELLER_SEND_GOODS")) {
					// 该判断表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货
					localServiceProxy.updateOrder(out_trade_no, trade_no, 2);
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（response.getWriter()_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					reponseWriter("success"); // 请不要修改或删除
				} else if (trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")) {
					// 该判断表示卖家已经发了货，但买家还没有做确认收货的操作
					localServiceProxy.updateOrder(out_trade_no, trade_no, 4);
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（response.getWriter()_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					reponseWriter("success"); // 请不要修改或删除
				} else if (trade_status.equals("TRADE_FINISHED")) {
					// 该判断表示买家已经确认收货，这笔交易完成
					localServiceProxy.updateOrder(out_trade_no, trade_no, 5);
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（response.getWriter()_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序

					reponseWriter("success"); // 请不要修改或删除
				} else {
					reponseWriter("success"); // 请不要修改或删除
				}

				// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

				// ////////////////////////////////////////////////////////////////////////////////////////
			} else {// 验证失败
				reponseWriter("fail");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* *
	 * 功能：支付宝页面跳转同步通知页面 版本：3.2 日期：2011-03-17 说明：
	 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	 * 
	 * //***********页面功能说明*********** 该页面可在本机电脑测试 可放入HTML等美化页面的代码、商户业务逻辑程序代码
	 * TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
	 * TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
	 * //********************************
	 */
	public String returnurl() {
		successFailPage = new SuccessFailPage();
		String  returnurl="return_fail";
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		try {
			for (Iterator iter = requestParams.keySet().iterator(); iter
					.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("UTF-8"), "utf-8");
				params.put(name, valueStr);
			}

			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			// 商户订单号

			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("UTF-8"),
					"UTF-8");

			// 支付宝交易号

			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("UTF-8"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter(
					"trade_status").getBytes("UTF-8"), "UTF-8");

			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

			// 计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			//boolean verify_result =true;
			if (verify_result) {// 验证成功
				// ////////////////////////////////////////////////////////////////////////////////////////
				// 请在这里加上商户的业务逻辑程序代码

				// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

				if (trade_status.equals("WAIT_SELLER_SEND_GOODS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（response.getWriter()_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					localServiceProxy.updateOrder(out_trade_no, trade_no, 2);
					successFailPage.setPage_title("支付成功");
					successFailPage.setPage_successmessage("支付成功");
					returnurl = "return_success";
				}else{
					successFailPage.setPage_failmeessage("支付失败");
					successFailPage.setPage_title("支付失败");
					returnurl = "return_fail";
				}

				// 该页面可做页面美工编辑
				//reponseWriter("验证成功<br />");
				// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				
			} else {
				// 该页面可做页面美工编辑
				//reponseWriter("验证失败");
				successFailPage.setPage_failmeessage("验证失败");
				successFailPage.setPage_title("验证失败");
				returnurl= "return_fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnurl;
	}
}
