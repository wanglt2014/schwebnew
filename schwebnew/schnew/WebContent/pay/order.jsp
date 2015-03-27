<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>

<%
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	String website = url.substring(0, url.indexOf(uri));
	String request_path = website + request.getContextPath();
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="订单结算页面" />
<title>订单结算_${sitename}</title>

<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${css_path}/subindex.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/news.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/order.css" />
<link rel="stylesheet" type="text/css"
	href="${css_path}/jqueryUi/jquery-ui.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.cookie.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/Area.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/AreaData_min.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/order.js"></script>
</head>
<body>
	<div class="container" style="position: relative;">

		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
		<div id="checkout">
			<div class="mt">
				<h2>填写并核对订单信息</h2>
			</div>
			<form method="post" action="ShopCart_pay" id="orderpayform">
				<div class="checkout-steps" id="wizard">
					<div class="step step-complete" id="step-1">
						<div class="step-title">
							<div class="step-right" id="save-consignee-tip"></div>
							<strong>收货人信息</strong>
						</div>
						<div class="step-content">
							<div class="sbox-wrap" id="consignee">
								<div class="sbox">
									<div class="form">
										<div name="consignee-list" id="consignee-list">
											<ul id="consignee-list-ul">
											<!-- 	<li><input type="radio" name="identity" checked="checked" value="old"onclick="hideaddressform()"/>江西省 南昌市 艾溪湖 |刘海华 | 15001327397| 110211</li>
												<li><input type="radio" name="identity" value="old" onclick="hideaddressform()"/>江西省 南昌市 艾溪湖 |刘海华 | 15001327397| 110211 </li>
												<li><input type="radio" name="identity"  value="old" onclick="hideaddressform()"/>江西省 南昌市 艾溪湖 |刘海华 | 15001327397| 110211 </li>
												<li><input type="radio" name="identity"  value="new" onclick="showaddressform()"/>新地址</li> -->
											</ul>
										</div>
										<div id="new-address-form" style="display: none;">
											
											<div id="name_div" class="list">
												<span class="label"><em>*</em>收货人：</span>
												<div class="field">
													<input type="text" maxlength="20" name="contactname"  id="contactname"
														class="textbox"/>
													<input type="text" maxlength="20" name="address_head"  id="address_head" style="display: none;"
														class="textbox"/>
												</div>
											</div>
											<div id="area_div" class="list select-address">
												<span class="label"><em>*</em>所在地区：</span>
												<div class="field">
													<center>
														<select id="seachprov" name="seachprov"
															onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>&nbsp;&nbsp;
														<select id="seachcity" name="homecity"
															onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>&nbsp;&nbsp;
														<span id="seachdistrict_div"><select
															id="seachdistrict" name="seachdistrict"></select> </span><!--  <input
															type="button" value="获取地区" onClick="showAreaID()" /> -->
													</center>
												</div>
											</div>

											<div id="address_div" class="list full-address">
												<span class="label"><em>*</em>详细地址：</span>
												<div class="field">
													<span id="areaNameTxt" class="fl selected-address"></span>
													<input type="text" maxlength="50" name="address_detail" id="address_detail"
														class="textbox"/>
												</div>
											</div>
											<div id="call_div" class="list">
												<span class="label"><em>*</em>手机号码：</span>
												<div class="field">
													<div class="phone">
														<input type="text" maxlength="11" name="contacttelephone"
															id="contacttelephone" class="textbox"/>
														
													</div>
												</div>
											</div>
											<div id="call_div" class="list">
												<span class="label"><em>*</em>邮编：</span>
												<div class="field">
													<div class="phone">
														<input type="text" maxlength="11" name="address_postcode"
															id="address_postcode" class="textbox"/>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="step step-complete" id="step-4">
						<div class="step-title">
							<strong>商品清单</strong>
						</div>
						<div class="step-content">
							<div class="sbox-wrap" id="part-order">
								<div class="sbox">
									<div id="order-cart">
										<div class="order-review"  id="order_pay_items">
											<!--商品清单展示-->
											
										</div>


									</div>
									<!--**********商品清单内容列表结束************-->

									<div class="agree hide" id="oldReplaceNewDiv">
										<div class="fl">
											<label for="oldReplaceNew">订单说明：</label> <strong>对本次订单有任何疑问或者你想咨询一下优惠情况，您可以联系本网站的客服人员。</strong>，客服QQ:422293101
										</div>
									</div>

									
								</div>
							</div>
						</div>
					</div>
					<div class="checkout-buttons group" id="checkout-floatbar">
						<div class="inner">
							<input type="button" id="order-submit" value="" onclick="pay()"
								class="checkout-submit"/> <span class="total">应付总额：<strong
										id="payPriceId">￥750.00</strong>元</span>
						</div>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</div>
</body>
</html>