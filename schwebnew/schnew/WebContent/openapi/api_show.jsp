<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%
	String request_path = request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8" >
<title>[${openApi.text}]接口说明</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/openapi.css">
<link rel="stylesheet" type="text/css" href="${css_path}/jquery.alerts.css" />
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript" src="${js_path}/menu.js"></script>
<script type="text/javascript" src="${js_path}/jquery.json-2.4.min.js"></script>
<script type="text/javascript"src="${js_path}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${js_path}/jquery.alerts.js" ></script>

</head>
<body>
	${openApi.apidesc}
</body>
</html>