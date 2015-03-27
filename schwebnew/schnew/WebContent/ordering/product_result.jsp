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
	request.setAttribute("cur_nav", 1);
	
%>
<div>
<table  >
		<c:if test="${empty(productlist)}">
			<tr>
				<td colspan="5" style="text-align:center">
						没有检索到相关记录
				</td>
			</tr>
		</c:if>
		<c:if test="${!empty(productlist)}">
			<tr>
			<s:iterator var="product" value="productlist" status="st">
			  <td>
				<div class="productinfo">
				<a href="Ordering_queryProductInfo_${product.id}.shtm" class="link_style">
				<div class="productinfo_img"><img src="${image_path}/${product.productImageUrl}.png" class="productinfo_imgstyle" width="140px;" height="120px;"/></div>
				<div class="productinfo_name">${product.productName}</div>
				<div class="split_spx"></div>
				</a>
				<div class="productinfo_price">
					<ul class="ul_product">
						<li>抢购价:&nbsp;</li>
						<li class="productprice"><fmt:formatNumber value="${product.productPrice}" type="currency" pattern="#0.00"/></li>
						<li>&nbsp;元每/月</li>
					</ul>
				</div>
				
				</div>
				
				</td>
				
				<s:if test="#st.modulus(5)==0">
                   <s:if test="#st.last">
                       </tr>
                   </s:if>
                  <s:else>
                       <tr>
                  </s:else>
              </s:if>
          
              
			</s:iterator>
		
		</c:if>
	
</table>
</div>

<s:if test="totalPageCount > 0">
<jsp:include page="../usercenter/page.jsp"/>
</s:if>
