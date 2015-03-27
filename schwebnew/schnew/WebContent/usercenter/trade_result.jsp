<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<div>
	<table id="tradeRecords">
		<tr>

			<th class="th_id">订单号</th>
			<th class="th_status">订单状态</th>
			<th class="th_name">订单创建时间</th>
			<th class="th_fund">交易金额(元)</th>
			<th class="th_date">订单详情</th>

		</tr>
		<c:if test="${empty(orderlist)}">
			<tr>
				<td colspan="5" style="text-align: center"><a href="">没有检索到相关记录。</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${!empty(orderlist)}">
			<s:iterator var="order" value="orderlist" status="st">
				<s:if test="#st.odd">
					<tr class="odd">
				</s:if>
				<s:else>
					<tr>
				</s:else>


				<td class="td_id"><s:property value="#order.orderId" /></td>
				<td class="td_status" id="${tradeDetailExt.id}_tradeStatus">
						<c:choose>
						<c:when test="${order.orderStatus==1}"> 订单创建 </c:when>
						<c:when test="${order.orderStatus==2}">支付完成 </c:when>
						<c:when test="${order.orderStatus==3}">订单撤销 </c:when>
						<c:when test="${order.orderStatus==4}">订单已发货 </c:when>
						<c:when test="${order.orderStatus==5}">订单完成 </c:when>
						<c:otherwise> 无效状态 </c:otherwise>
						</c:choose>
				<td class="td_name">
				<s:date name="#order.orderCreateTime"
						format="yyyy-MM-dd HH:mm" />
				</td>

				<td class="td_fund"><s:i18n name="Format">
						<s:text name="format.number">
							<s:param value="#order.orderTotalPrice" />
						</s:text>
					</s:i18n></td>

				<td class="td_date" >
					<a href="UserCenter_getorderdetail?id=<s:property value="#order.orderId"/>" style="color: #4f5393" target="_blank">详情</a>
				</td>


			</s:iterator>
		</c:if>
	</table>
</div>

<s:if test="totalPageCount > 0">
	<jsp:include page="../usercenter/page.jsp" />
</s:if>
