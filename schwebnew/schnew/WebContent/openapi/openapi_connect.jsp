<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
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
<head>
<meta charset="UTF-8">
<title>${sitename}--网站连接</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/adminlogin.css">
<link rel="shortcut icon" href="favicon.ico" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function reset() {
		$('#loginForm').reset();
	}
</script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="147" background="${image_path}/top02.gif"></td>
		</tr>
	</table>
	<table width="562" border="0" align="center" cellpadding="0"
		cellspacing="0" class="right-table03">
		<tr>
			<td width="221"><table width="95%" border="0" cellpadding="0"
					cellspacing="0" class="login-text01">

					<tr>
						<td><table width="100%" border="0" cellpadding="0"
								cellspacing="0" class="login-text01">
								<tr>
									<td align="center"><img src="${image_path}/ico13.gif"
										width="107" height="97" />
									</td>
								</tr>
								<tr>
									<td height="40" align="center"><div id="logo">
		<a href="${request_path}/index"><img src="${image_path}/logo.gif"
			alt="logo" />
		</a>
	</div></td>
								</tr>

							</table>
						</td>
						<td><img src="${image_path}/line01.gif" width="5"
							height="292" />
						</td>
					</tr>
				</table>
			</td>
			<td>
				<form action="OpenApi_connect" method="post" name="loginForm"
					id="loginForm">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="color: #7F9DB9; font-size: 13px; padding-top: 4px; text-align: left; text-decoration: none">
						<tr>
							<td style="padding-top: 20px; color: red; font-size: 14px;">将允许${openApp.appname}进行以下操作：</td>
						</tr>
						<tr>
							<td width="71%"><input type="checkbox" name="accessauth" id="oauth" value="1" checked="checked" disabled="disabled">认证授权
							</td>
						</tr>
						<tr>
							<td width="71%"><input type="checkbox"  name="accessauth" id="ss" value="2">个人中心</td>
						</tr>
						<tr>
							<td><input type="checkbox"  name="accessauth" id="cc" value="3"> 公司新闻<br /></td>
						</tr>
						<tr>
							<td><input type="checkbox" name="accessauth" id="dd" value="4">产品中心<br /></td>
						</tr>
						<tr>
							<td width="71%"><input type="checkbox" name="accessauth" id="ee" value="5">商务合作</td>
						</tr>
						<tr>
							<td style="padding-top: 10px;"><input name="Submit2"
								type="submit" class="right-button01" value="连接" /> <input
								type="button" class="right-button02" onclick="reset()"
								value="取消" />
							</td>
						</tr>

					</table>
		</form>
		</td>
		</tr>
	</table>
</body>
</html>