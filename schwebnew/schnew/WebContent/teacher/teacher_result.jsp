<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>

<%
String request_path = request.getContextPath();
%>
<style type="text/css">

.teacher_list{
	width: 100%;
	text-align: center;
}
.span_title{
	width: 80%;
	text-align: left;
	
}
</style>
<jsp:include page="../pre.jsp"></jsp:include>
<c:if test="${empty(teacherList)}">
	<tr>
		<td colspan="5" style="text-align: center"><a href="">没有检索到相关记录。</a>
		</td>
	</tr>
</c:if>
<c:if test="${!empty(teacherList)}">
<br><br>
	<s:iterator var="dictionary" value="dictionaryList" status="s" >
	<div align="center" style="width: 100%;">
	<h3 class="span_title"><s:property value="#dictionary.dictionaryvalue" /></h3>
	<hr color="#bbbbbb" width="80%" />
	<table class="teacher_list">
		<s:iterator var="teacher" value="teacherList" status="st">
<%-- 		<s:property value="#dictionary.dictionarycode" />@@@<s:property value="#teacher.department" />#### --%>
<%-- 		<s:property value="#st.index" /> --%>
		<s:if test="#dictionary.dictionarycode==#teacher.department">
		  <s:if test="#st.index % 4 == 0">
		<tr>
		  </s:if>
		  <td>                
		  	<a href="Teacher_teacherDetail_${teacher.id}.shtm"><img class="img_thunmb" alt="' + teacher.teachername + '" src="file://<s:property value="#teacher.iimageurll"/>" /></a>
		  	<br>
		  	<a href="Teacher_teacherDetail_${teacher.id}.shtm"><i class="point">•</i>&nbsp;<s:property value="#teacher.teachername" /></a>
		  </td>            
		  <s:if test="#st.index % 4 == 3">                
		  </tr>
		  </s:if>
<!-- 		<div class="artic_content"> -->
		
<!-- 		</div> -->
<!-- 			<div class="one_artic"> -->
<!-- 				<div class="artic_content"> -->
<%-- 				<s:property value="#dictionary.dictionaryvalue" /> --%>
<%-- 					<s:property value="#teacher.teachername" /> --%>
<%-- 					<a href="Teacher_teacherDetail_${teacher.id}.shtm"><img alt="' + teacher.teachername + '" src="<s:property value="#teacher.iimageurll"/>" /></a> --%>
<%-- 					<a style="color: #524EA3; text-decoration: underline;" href="Article_teachDetail_<s:property value="#teachInfo.articleid"/>.shtm" target="_blank">[阅读全文]</a> --%>
<!-- 				</div> -->
<!-- 				<div class="split_spx"></div> -->
<!-- 			</div> -->
		</s:if>
		</s:iterator>
		</table>
		</div>
		<br><br><br><br>
	</s:iterator>
</c:if>
<div class="news_page">
<%-- 	<s:if test="totalPageCount > 0"> --%>
<%-- 		<jsp:include page="../common/common_page.jsp" /> --%>
<%-- 	</s:if> --%>
</div>
