<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>

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

	// 当前导航栏位置
	request.setAttribute("cur_nav", 1);

	// 本页左侧菜单位置
	request.setAttribute("cur_menu", "menu_withdraw");
%>
<head>
<meta http-equiv="Content-Type"  name="description"  content="无权访问页面" />
<title>权限访问限制--${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">
	
</script>

</head>

<body>
		<div id="content">
			<table border=0 cellpadding=0 cellspacing=0 width="100%"
				height="100%">
				<tr>
					<td align="center" style="padding-top:130px;"><img
						src="${image_path}/noaccess.jpg" /></td>
				</tr>
				<tr>
					<form name=loading>
						<td align=center>
							<p>
								<font color=gray>正在载入首页，请稍候.......</font>
							</p>
							<p>
								<input type=text name=chart size=46
									style="font-family: Arial; font-weight: bolder; color: gray; background-color: white; padding: 0px; border-style: none;">
									<br> <input type=text name=percent size=46
										style="font-family: Arial; color: gray; text-align: center; border-width: medium; border-style: none;">
											<script>
												var bar = 0
												var line = "||"
												var amount = "||"
												count()
												function count() {
													bar = bar + 2
													amount = amount + line
													document.loading.chart.value = amount
													document.loading.percent.value = bar
															+ "%"
													if (bar < 99) {
														setTimeout("count()",
																120);
													}//这里修改载入时间
													else {
														window.location.href ='${request_path}/index';
													}//这里改成你的网站地址
												}
											</script>
							</p></td>
					</form>
				</tr>
			</table>

		</div>


</body>
</html>