<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String request_path = request.getContextPath();
	// 当前导航栏位置
	request.setAttribute("cur_nav", 3);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>资料下载</title>
<meta http-equiv="Content-Type" name="description"
	content="" />
<link rel="shortcut icon" href="favicon.ico" />
<jsp:include page="../pre.jsp"></jsp:include>
</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container" style="position: relative;">
		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
		<div style="position: relative; margin: 5px 0px 10px 0px;">
			<div id="index_top">
				<div id="news_right_content_detail">
					<div class="one_artic_detail">
						<div class="title_detail" align="center">
							<b style="font-size: 15px; font-family: sans-serif;"><c:out
									value="${downloaddetail.filename}" /> </b>
						</div>
						<div class="artic_author_detail" align="center">
							作者:
							<c:out value="${downloaddetail.author}" />
							时间:
							<c:out value="${downloaddetail.createdate}" />
							<div class="bdsharebuttonbox" style="text-align: right;">
							</div>
						</div>
						<div class="normal_summary">
							描述：
							<c:out value="${downloaddetail.directions}" escapeXml="false" />
						</div> 
						<div class="artic_content_detail" id="articcontentdetail">
							<%-- 描述：
							<c:out value="${downloaddetail.directions}" escapeXml="false" /> --%>
						<a href="<%=request_path %>/${downloaddetail.fileshowpath}" id="filePath" title="" ><c:out value="${downloaddetail.filename}" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</div>
</body>
</html>