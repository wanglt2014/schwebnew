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
	request.setAttribute("cur_menu","menu_updatepasswd");
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
function updatepasswd(){
	$("#first").validate();
	var defaultpasswd= $('#defaultpasswd').val();
	var firstpasswd= $('#firstpasswd').val();
	var secondpasswd= $('#secondpasswd').val();
	if(defaultpasswd==""){
		jAlert('原始密码不能为空','修改密码提示');
	}else if(firstpasswd==""){
		jAlert('新密码不能为空','修改密码提示');
	}else if(secondpasswd==""){
		jAlert('确认密码不能为空','修改密码提示');
	}else if(firstpasswd!=secondpasswd){
		jAlert('2次密码不一致,请重新修改!','修改密码提示');
	}else if(firstpasswd==defaultpasswd){
		jAlert('新密码和原始密码不能重复!,请重新修改!','修改密码提示');
	}else{
		$.ajax({
			type : 'post',
			url : 'UserCenter_updatepasswd',
			data : {
				defaultpasswd : defaultpasswd,
				password : firstpasswd
			},
			success : function(data) {
				if(data=='true'){
					jAlert('恭喜你,密码修改成功！','修改密码提示');
				}else{
					jAlert('修改密码失败,原始密码不对！','修改密码提示');
				}
			},
			error : function() {
				jAlert('系统错误，请联系管理员','修改密码提示');
			}
		});
	}
}
</script>
<title>密码修改</title>
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
								<div class="select_div">
									<ul>
										<li class="select_title">个人密码修改</li>
									</ul>
								</div>
							<form  action="UserCenter_doUpdateUser"  id="first" method="post">
							<div class="recharge_div">
								<table>
										<tr>
											<td class="person_setup">原始密码：</td>
											<td><input type="password" value="${defaultpasswd}" name="defaultpasswd" id="defaultpasswd" maxlength="14"  />请输入原始</td>
										</tr>
									
										<tr>
											<td class="person_setup">新密码：</td>
											<td><input type="password" value="${firstpasswd}" name="firstpasswd" id="firstpasswd" maxlength="14"  />请输入新密码</td>
										</tr>
									
										<tr>
											<td class="person_setup">确认新密码：</td>
											<td><input type="password" value="${secondpasswd}" name="secondpasswd" id="secondpasswd"  maxlength="14" />在此输入新密码</td>
										</tr>
									
										<tr>
											<td class="person_setup"></td>
											<td><div class="person_setup_submit"><input type="button"  value="修改" class="normal_btn" onclick="updatepasswd()"/></div></td>
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
