<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	// 当前导航栏位置
	request.setAttribute("cur_nav", 2);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>院系介绍</title>
<meta http-equiv="Content-Type" name="description"
	content="${bsArticledetail.summary}" />
<link rel="shortcut icon" href="favicon.ico" />
<jsp:include page="../pre.jsp"></jsp:include>
<%-- <link rel="stylesheet" type="text/css" href="${css_path}/subindex.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/news.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/schoolEX.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.cookie.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script> --%>
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
							院系介绍
						</div>
						<div class="artic_author_detail" align="center">
							<%-- 作者:
							<c:out value="${bsArticledetail.author}" />
							时间:
							<fmt:formatDate value="${bsArticledetail.createdate}" pattern="yyyy/MM/dd  HH:mm:ss" /> --%>
						</div>

						<div class="normal_summary">
						<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:out value="${introduction}" escapeXml="false" />
						</div> 
						<div class="content_detail" id="articcontentdetail" align="center">
							<s:iterator var="college" value="collegelist" status="co">
								<b><a target="_blank" href="College_collegeDetail_${college.id}.shtm"><s:property
									value="#college.collegename" /> </a></b>
							</s:iterator>
						</div>
					</div>

				</div>

			</div>

		</div>

		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>