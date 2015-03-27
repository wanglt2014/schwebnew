<%@ page language="java"  pageEncoding="UTF-8" isErrorPage="true"%>  
<% response.setStatus(HttpServletResponse.SC_OK);%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


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
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>401错误</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/bank_recharge.css" />
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
	<div class="top_title">
		<div>错误提示</div>
	</div>

	<div class="result_tips">
		<div class="result_content">对不起，401错误</div>
		<br/>
		<div ><a href="index" class="link_style">返回首页</a>&nbsp;&nbsp;</div>
	</div>
	
</div>





<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>
</html>