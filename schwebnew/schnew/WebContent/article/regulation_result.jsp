<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<jsp:include page="../pre.jsp"></jsp:include>
<c:if test="${empty(bsArticlelist)}">
	<tr>
		<td colspan="5" style="text-align: center"><a href="">没有检索到相关记录。</a>
		</td>
	</tr>
</c:if>
<c:if test="${!empty(bsArticlelist)}">
	<s:iterator var="teachInfo" value="bsArticlelist" status="st">
		<div class="one_artic">
			<div class="artic_title">
				<b><s:property value="#teachInfo.articletitle" /> </b> 作者:
				<s:property value="#teachInfo.author" />
				日期：
				<s:property value="#teachInfo.createdate" />
			</div>
			<div class="artic_content">
				<s:property value="#teachInfo.articlesummary" />
				<a style="color: #524EA3; text-decoration: underline;" href="Article_regulationDetail_<s:property value="#teachInfo.articleid"/>.shtm" target="_blank">[阅读全文]</a>
			</div>
			<div class="split_spx"></div>
		</div>
	</s:iterator>
</c:if>
<div class="news_page">
	<s:if test="totalPageCount > 0">
		<jsp:include page="../common/common_page.jsp" />
	</s:if>


</div>
