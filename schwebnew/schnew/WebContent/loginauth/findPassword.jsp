<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>
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
<meta http-equiv="Content-Type"  name="description"  content="找回密码，可以通过手机，邮箱，其他方式找回" />
<title>找回密码_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css"
	href="${css_path}/findpassword.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/findpassword.js"></script>
</head>

<body>
	<div class="container">
		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
		<div id="content">
			<div id="Tab">
				<div class="Menubox">
					<ul>
						<li id="menu1"  onclick="setTab('menu',1,3)" class="hover">通过登录/注册邮箱找回密码</li>
						<li id="menu2" onclick="setTab('menu',2,3)">通过注册/绑定手机找回密码</li>
						<li id="menu3" onclick="setTab('menu',3,3)">其他方式找回密码</li>
					</ul>
				</div>
				<div class="Contentbox">
					<div id="con_menu_1" class="hover">
					<div class="mail_tips">
							<div class="result_content">
							<div >
						       	<table >
						           <tr >	
						           	<td style="float: right; ">登录邮箱：</td><td><input type="text"  value="" maxlength="50" id="findpasswd_email" name="findpasswd_email"/></td>
						        </tr>
						        <tr class="emaildialog">
						           	<td style="float: right;margin-top: 10px; ">验证码：</td><td>
						           	<input type="text"  value="" maxlength="20"  size="10" id="checkcode" name="checkcode"/>
						           	<img width="80" height="20" id="randimage" src="${request_path}/common/validate_img.jsp" align="absMiddle" border="0" alt="看不清楚?请点击刷新" style="cursor : pointer;" onclick="this.src='${request_path}/common/validate_img.jsp?'+ Math.random()"/>
						         </td>
						         </tr>
						         </table>
						       </div>
							
							</div>
							<br />
							<div class="email_btn">
								<input type="button" onclick="sendmail()" id="sendmail_btn" class="normal_btn" value="发送验证邮件"/>
							</div>
						</div>
						
					</div>
					<div id="con_menu_2" style="display: none">
						<div class="mobile_tips">
							<div class="result_content">对不起，目前没有开通手机找回密码功能!</div>
							<br />
							<div>
								<a href="index" class="link_style">返回首页</a>&nbsp;&nbsp;
							</div>
						</div>
					</div>
					<div id="con_menu_3" style="display: none">
						<div class="other_tips">
							<div class="result_content">对不起，其他找回密码功能等待添加!</div>
							<br />
							<div>
								<a href="index" class="link_style">返回首页</a>&nbsp;&nbsp;
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>