<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>${sitename}--后台管理系统---缓存统计</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<table border="1" width="60%">
		<tr>
			<td><b>key</b></td>
			<td><b>操作</b></td>
		</tr>
		<tr>
			<td>系统变量</td>
			<td><a onclick="clearSystemConstant()" style="color: blue;" >清除</a>
			</td>
		</tr>
		<tr>
			<td>新闻缓存</td>
			<td><a  style="color: blue;" >清除</a>
			</td>
		</tr>
		<tr>
			<td>产品缓存</td>
			<td><a  style="color: blue;" >清除</a>
			</td>
		</tr>
		<tr>
			<td>权限缓存</td>
			<td><a  style="color: blue;" >清除</a>
			</td>
		</tr>
	</table>
</body>
</html>