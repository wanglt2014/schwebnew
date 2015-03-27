<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<%
String url = request.getRequestURL().toString();
String uri = request.getRequestURI();
String website =url.substring(0, url.indexOf(uri));
String request_path = website+request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
	
	// 当前导航栏位置
	request.setAttribute("cur_nav", 1);
	
%>
<%
	/* *
	 *功能：支付宝纯担保交易接口调试入口页面
	 *版本：3.3
	 *日期：2012-08-17
	 *说明：
	 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>支付宝纯担保交易接口</title>
<meta name=page-view-size content=1280*720 />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
	margin: 0;
	padding: 0;
}

ul,ol {
	list-style: none;
}

.title {
	color: #ADADAD;
	font-size: 14px;
	font-weight: bold;
	padding: 8px 16px 5px 10px;
}

.hidden {
	display: none;
}

.new-btn-login-sp {
	border: 1px solid #D74C00;
	padding: 1px;
	display: inline-block;
}

.new-btn-login {
	background-color: transparent;
	border: medium none;
}

.new-btn-login {
	background-position: 0 -198px;
	width: 82px;
	color: #FFFFFF;
	font-weight: bold;
	height: 28px;
	line-height: 28px;
	padding: 0 10px 3px;
}

.new-btn-login:hover {
	background-position: 0 -167px;
	width: 82px;
	color: #FFFFFF;
	font-weight: bold;
	height: 28px;
	line-height: 28px;
	padding: 0 10px 3px;
}

.bank-list {
	overflow: hidden;
	margin-top: 5px;
}

.bank-list li {
	float: left;
	width: 153px;
	margin-bottom: 5px;
}

#main {
	width: 750px;
	margin: 0 auto;
	font-size: 14px;
	font-family: '宋体';
}


.red-star {
	color: #f00;
	width: 10px;
	display: inline-block;
}

.null-star {
	color: #fff;
}

.content {
	margin-top: 5px;
}

.content dt {
	width: 160px;
	display: inline-block;
	text-align: right;
	float: left;
}

.content dd {
	margin-left: 100px;
	margin-bottom: 5px;
}

#foot {
	margin-top: 10px;
}

.foot-ul li {
	text-align: center;
}

.note-help {
	color: #999999;
	font-size: 12px;
	line-height: 130%;
	padding-left: 3px;
}

.cashier-nav {
	font-size: 14px;
	margin: 15px 0 10px;
	text-align: left;
	height: 30px;
	border-bottom: solid 2px #CFD2D7;
}

.cashier-nav ol li {
	float: left;
}

.cashier-nav li.current {
	color: #AB4400;
	font-weight: bold;
}

.cashier-nav li.last {
	clear: right;
}

.alipay_link {
	text-align: right;
}

.alipay_link a:link {
	text-decoration: none;
	color: #8D8D8D;
}

.alipay_link a:visited {
	text-decoration: none;
	color: #8D8D8D;
}
</style>
<script language="JavaScript" type="text/javascript">
	function alipay() {
		document.forms['alipayment'].submit();
	}
</script>

</head>
<body onload="alipay()">
	<div id="main" style="display: none;">
		<div id="head">
			<span class="title">支付宝纯担保交易接口快速通道</span>
		</div>
		<form name="alipayment" id="alipayment" action="Pay_alipayapi" method="post">
			<div id="body" style="clear: left">
				<dl class="content">
					<dt>卖家支付宝帐户：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDseller_email" value="${alipayemail}"/> <span>必填 </span>
					</dd>
					<dt>商户订单号：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDout_trade_no" value="${orderVo.order.orderId}"/> <span>商户网站订单系统中唯一订单号，必填 </span>
					</dd>
					<dt>订单名称：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDsubject" value="${sitename}订单号(${orderVo.order.orderId})"/> <span>必填 </span>
					</dd>
					<dt>付款金额：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30" name="WIDprice" value="${orderVo.order.orderTotalPrice}" />
						<span>必填 </span>
					</dd>
					<dt>订单描述 ：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30" name="WIDbody" value="${sitename}订单号(${orderVo.order.orderId})"/>
						<span></span>
					</dd>
					<dt>商品展示地址：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDshow_url" value="${websiteurl}"/> <span>需以http://开头的完整路径，如：http://www.xxx.com/myorder.html
						</span>
					</dd>
					<dt>收货人姓名：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDreceive_name" value="${orderVo.bsAddress.consignee}"/> <span>如：张三 </span>
					</dd>
					<dt>收货人地址：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDreceive_address" value="${orderVo.bsAddress.addressHead}${orderVo.bsAddress.addressDetail}"/> <span>如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
						</span>
					</dd>
					<dt>收货人邮编：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDreceive_zip" value="${orderVo.bsAddress.postcode}"/> <span>如：123456 </span>
					</dd>
					<dt>收货人电话号码：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDreceive_phone" value=""/> <span>如：0571-88158090 </span>
					</dd>
					<dt>收货人手机号码：</dt>
					<dd>
						<span class="null-star">*</span> <input size="30"
							name="WIDreceive_mobile" value="${orderVo.bsAddress.telephone}"/> <span>如：13312341234</span>
					</dd>
					<dt></dt>
					<dd>
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
								style="text-align: center;background-image: url('${image_path}/new-btn-fixed.png')">确 认</button> </span>
					</dd>
				</dl>
			</div>
		</form>
		<div id="foot">
			<ul class="foot-ul">
				<li><font class="note-help">如果您点击“确认”按钮，即表示您同意该次的执行操作。 </font>
				</li>
				<li>支付宝版权所有 2011-2015 ALIPAY.COM</li>
			</ul>
		</div>
	</div>
</body>
</html>