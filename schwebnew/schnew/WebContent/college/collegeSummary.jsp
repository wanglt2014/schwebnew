<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	// 当前导航栏位置
	request.setAttribute("cur_nav", 1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学院简介</title>
<meta http-equiv="Content-Type" name="description"
	content="院系简介" />
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
						<div class="title_detail" >
							学院简介
						</div>
						<div class="artic_author_detail" align="center">
							<%-- 作者:
							<c:out value="${bsArticledetail.author}" />
							时间:
							<fmt:formatDate value="${bsArticledetail.createdate}" pattern="yyyy/MM/dd  HH:mm:ss" /> --%>
							<div class="bdsharebuttonbox" style="text-align: right;">
								<label for="fontsize">字体大小:</label> <select id="fontsize">
									<option value="12px">小号</option>
									<option value="14px">较小</option>
									<option value="15px" selected="selected">中号</option>
									<option value="18px">较大</option>
									<option value="24px">大号</option>
								</select>
							</div>
						</div>

						<!-- <div class="normal_summary">
							
						</div>  -->
						<div class="content_detail" id="articcontentdetail">
							<c:out value="${college.collegesummary}" escapeXml="false" />
						</div>
					</div>

				</div>

			</div>

		</div>

		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>