<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String request_path = request.getContextPath();
	// 当前导航栏位置
	request.setAttribute("cur_nav", 5);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>人才培养方案_${tDepartmentWithBLOBs.departmentname}</title>
<meta http-equiv="Content-Type" name="description"
	content="${tDepartmentWithBLOBs.departmentname}" />
<link rel="shortcut icon" href="favicon.ico" />
<jsp:include page="../pre.jsp"></jsp:include>
<%-- <script language="JavaScript" type="text/javascript" --%>
<%-- 	src="${js_path}/fileUploadHandle.js"></script> --%>
</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container" style="position: relative;">

		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>


		<div style="position: relative; margin: 5px 0px 10px 0px;">
			<div id="index_top">
				<div id="news_right_content_detail">
<!-- 					<div class="one_artic_detail"> -->
						<div class="title_detail" align="center">
							<b style="font-size: 15px; font-family: sans-serif;"><c:out
									value="${tDepartmentWithBLOBs.departmentname}" />--学科方向 </b>
						</div>
						<hr class="line_teacher" />	
<!-- 						<div class="content_detail" id="articcontentdetail"> -->
<%-- 							<c:out value="${tDepartmentWithBLOBs.departmentdirection}" escapeXml="false" /> --%>
<!-- 						</div> -->
						<div class="plan_content_detail">
						<c:out value="${tDepartmentWithBLOBs.departmentdirection}" escapeXml="false" />
						</div><br>
<!-- 					</div> -->
				</div>
			</div>
		</div>
			<%-- <input type="text" id="wordName" name="wordName"  style="display:none">
			 <input type="text" id="documentType" name="documentType" style="display:none">
			 <input type="text" id="serverName" name="serverName" style="display:none">
			 <input type="text" id="serverIp" name="serverIp" style="display:none">
			 <input type="text" id="restorePath" name="restorePath" value="${bsArticledetail.download.filepath}" style="display:none">
			 <input type="text" id="pwd" name="pwd" style="display:none">
			 <input type="text" id="account" name="account" style="display:none"> --%>
		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>