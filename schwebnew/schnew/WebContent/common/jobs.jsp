<%@ page contentType="text/html; charset=utf-8" language="java" %>
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
	
	// 本页左侧菜单位置
	request.setAttribute("cur_menu","menu_index");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="招聘信息" />
<title>人才招聘_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/question.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

</script>

</head>

<body>
<div id="fade" class="black_overlay"></div>
<div class="container">
<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
	<div class="porductIntro" style="padding: 0 10px;font-size: 14px;" >
	<h2>人才招聘</h2>
	<p/>
	<div class="split_spx"></div>

	<h3>招聘信息发布</h3>
		
	</div>
<div class="back" style="margin-top: 20px;"><a href="javascript:window.close()">关闭本窗口</a></div>	
</div>
	

<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>
</html>