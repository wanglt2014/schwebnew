<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
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
	request.setAttribute("cur_nav",2);
	
%>

				<div>
					<table id="tradeRecords">
						<tr>
							
							<th class="th_name">产品名称</th>
							<th class="th_fund">交易金额(元)</th>
							<th class="th_date">到期时间</th>
							<th class="th_status">操作</th>
						</tr>
						<c:if test="${empty(userServicelist)}">
							<tr><td colspan="4" style="text-align:center">
								没有检索到相关记录!
							</td></tr>
						</c:if>
						<c:if test="${!empty(userServicelist)}">
							<s:iterator var="bsuserservice" value="userServicelist" status="st">
								<s:if test="#st.odd">
									<tr class="odd">
								</s:if>
								<s:else>
									<tr>
								</s:else>
									
							 <td class="td_name" >
								<s:property value="#bsuserservice.productName"/>	
							 </td>
							 
							 <td class="td_fund" >
							 	<s:i18n name="Format">   <s:text name="format.number"><s:param value="#bsuserservice.productPrice"/></s:text></s:i18n>
							 </td>
							 
							  <td class="td_date">
								 <s:date name="#bsuserservice.serviceEndTime" format="yyyy-MM-dd HH:mm"/>
							 </td>
							<td class="td_operation">
					 		  	<a href="Ordering_queryProductInfo_<s:property value="#bsuserservice.productId"/>.shtm" class="link_style" >续费</a>
							</td>
									
							</s:iterator>
						</c:if>
				 	</table>
				</div>
				 <s:if test="totalPageCount > 0">
					<jsp:include page="../usercenter/page.jsp"/>
				</s:if>

