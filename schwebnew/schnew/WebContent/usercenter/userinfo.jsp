<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String url = request.getRequestURL().toString();
String uri = request.getRequestURI();
String website =url.substring(0, url.indexOf(uri));
String request_path = website+request.getContextPath();
	pageContext.setAttribute("request_path", request_path);
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
	
	// 当前导航栏位置
	request.setAttribute("cur_nav", 3);
	
	// 本页左侧菜单位置
	request.setAttribute("cur_menu","menu_setting");
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/userinfo.css" />
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.validate.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.validate.chinese.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script>
function updatepersoninfo(){
	var user = $("#name").val();
	$("#first").submit();
}
$().ready(function(){
	$("#first").validate();
	
	if($('#showMessage').val() != ''){
		jAlert($('#showMessage').val(),'提示');
	}

});
</script>
<title>个人资料</title>
</head>
<body>
<div id="fade" class="black_overlay"></div>
<div class="container">

<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
	<s:hidden id="showMessage" name="showMessage"></s:hidden>
	<jsp:include page="../usercenter/menu.jsp"></jsp:include>
			<div id="sub_content">
							<div class="balance_div">
								<ul>
									<li class="recharge_account_label">温馨提示：</li>
									<li ><span id="recharge_account">妥善保管好个人信息，不要向他人透露你的个人信息!</span></li>
								</ul>
							</div>
								<div class="select_div">
									<ul>
										<li class="select_title">个人资料设置</li>
									</ul>
								</div>
							<form  action="UserCenter_doUpdateUser"  id="first" method="post">
							<div class="recharge_div">
								<table>
										<tr>
											<td  class="person_setup">真实姓名：</td>
											<td><input type="text" value="${user.realname}" name="user.realname" maxlength="14" />请输入真实姓名</td>
										</tr>
										
										<tr>
											<td class="person_setup">会员卡号：</td>
											<td><c:out value="${user.iccard}"/>
											</td>
										</tr>
									
										<tr>
											<td class="person_setup">电话号码：</td>
											<td><c:out value="${user.mobilephone}"/></td>
										</tr>
									
										<tr>
											<td class="person_setup">邮箱：</td>
											<td><c:out value="${user.email}"/></td>
										</tr>
									
										<tr>
											<td class="person_setup"></td>
											<td><div class="person_setup_submit"><input type="button"  value="修改" class="normal_btn" onclick="updatepersoninfo()"/></div></td>
										</tr>
								</table>
							</div>
							
							</form>
							
							
			</div>

</div>

<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>


</html>
