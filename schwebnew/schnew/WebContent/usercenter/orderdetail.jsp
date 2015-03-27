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
<meta http-equiv="Content-Type" content="订单详情页面" />
<title>订单详情_${sitename}</title>

<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
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
<body>
	<div class="container" style="position: relative;">

		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
		<div id="checkout">
			<div class="bank_pay_step">
				<h2 style="margin-left: 20px">订单详细信息</h2>
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
												<li>
												${orderVo.bsAddress.addressHead}
												${orderVo.bsAddress.addressDetail}
												|${orderVo.bsAddress.consignee}
												|${orderVo.bsAddress.telephone}
												|${orderVo.bsAddress.postcode}
												</li>
											</ul>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="step step-complete" id="step-2">
						<div class="step-title">
							<div class="step-right" id="save-consignee-tip"></div>
							<strong>订单信息</strong>
						</div>
						<div class="step-content">
							<div class="sbox-wrap" id="consignee">
								<div class="sbox">
									<div class="form">
										<div name="consignee-list" id="consignee-list">
											<ul id="consignee-list-ul">
												<li>订单号：${orderVo.order.orderId}</li>
												<li>支付交易号: ${orderVo.order.payTradeNo}</li>
												<li>订单创建日期: ${orderVo.order.orderCreateTime}</li>
												<li>订单状态: 
												<c:choose>
												<c:when test="${orderVo.order.orderStatus==1}"> 订单创建 </c:when>
												<c:when test="${orderVo.order.orderStatus==2}">支付完成 </c:when>
												<c:when test="${orderVo.order.orderStatus==3}">订单撤销 </c:when>
												<c:when test="${orderVo.order.orderStatus==4}">订单已发货 </c:when>
												<c:when test="${orderVo.order.orderStatus==5}">订单完成 </c:when>
												<c:otherwise> 无效状态 </c:otherwise>
												</c:choose></li>
												<li>订单金额: ￥${orderVo.order.orderTotalPrice} 元</li>
												
											</ul>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="step step-complete" id="step-3">
						<div class="step-title">
							<strong>商品清单</strong>
						</div>
						<div class="step-content">
							<div class="sbox-wrap" id="part-order">
								<div class="sbox">
									<div id="order-cart">
										<div class="order-review" id="order_pay_items">
											<!--商品清单展示-->
											<div id="order-cart">
												<div id="order_pay_items" class="order-review">
													<table style="border: 1px dashed #ddd; width: 100%">
														<tbody class="review-thead">
															<tr>
																<td class="fore1">商品</td>
																<td class="fore2">商城价</td>
																<td class="fore3">数量</td>
																<td class="fore4">小计</td>
															</tr>
														</tbody>
														<tbody>
														<c:forEach var="bsproduct" items="${orderVo.list}">
															<tr style="border-bottom: 1px #ddd dashed;">
																<td class="fore1">
																	<div class="p-goods">
																		<div class="p-img">
																			<a href="Ordering_queryProductInfo_<c:out value="${bsproduct.id}"/>.shtm"
																				target="_blank"> <img width="60"
																				src="${image_path}/<c:out value="${bsproduct.productImageUrl}"/>.png">
																			</a>
																		</div>
																		<div class="p-detail">
																			<div class="p-name">
																				<a href="Ordering_queryProductInfo_<c:out value="${bsproduct.id}"/>.shtm"
																					target="_blank"><c:out value="${bsproduct.productName}"/> </a>
																			</div>
																			<div class="p-more">商品编号：<c:out value="${bsproduct.id}"/></div>
																		</div>
																	</div>
																</td>
																<td class="p-price"><strong>￥<c:out value="${bsproduct.productPrice}"/></strong></td>
																<td class="p-promotion"><c:out value="${bsproduct.number}"/></td>
																<td class="fore2">￥<c:out value="${bsproduct.totalprice}"/></td>
															</tr>
														</c:forEach>
														</tbody>
													</table>
												</div>


											</div>

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
				</div>
			</form>
		</div>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</div>
</body>
</html>