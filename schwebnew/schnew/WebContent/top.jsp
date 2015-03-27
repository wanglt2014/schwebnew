<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<link rel="stylesheet" type="text/css" href="${css_path}/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/global.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/1200.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/comments.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.alerts.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.ui.draggable.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/top.js" charset="UTF-8"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/footer.js" charset="UTF-8"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/Calculation.js" charset="UTF-8"></script>
	
<!-- 统一引用 -->
<link rel="stylesheet" type="text/css" href="${css_path}/subindex.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/news.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/schoolEX.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css" />
<%-- <script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script> --%>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.cookie.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<!-- header -->
<div id="header">
	<div id="logo" style="height: 35px;">
<%-- 		<a href="${request_path}/index.shtm"> <img src="${image_path}/logo.gif" --%>
<!-- 			alt="logo" />  </a> -->
	</div>

	<div class="header-right">
<!-- 		<div class="header-tel">7×24小时客服热线：150-0132-7397</div> -->
		<div class="header-tel"></div>
		<div id="user-header-carshop">
		<div class="header-link" id ="user-header-link">
			<!-- 显示用户名 -->
		</div>
		
		<!-- 购物车 -->
<%-- 		<div id="carshopdiv" style="display: none;"><jsp:include page="common/cartshop.jsp"></jsp:include></div> --%>
		</div>
		<!-- 登录 -->
		<div id="popupLogin" class="LoginWindowHeaderBox"
			style="left: 50px; top: 250px;">
			<ul>
				<li class="normal_title_left"></li>
				<li class="normal_title_right"></li>
				<li class="normal_title_content">用户登录 <a href="#"
					onclick="CloseDiv('popupLogin','fade')"> <img
						src="${image_path}/close.png" width="30" height="30"
						style="float: right" /> </a></li>
			</ul>
			<form action="Login_login" method="post" name="loginForm"
				id="loginForm">
				<div class="normal_content_login">
					<div style="margin: 30px 30px 15px 80px;"></div>
					<ul>
						<li><span id="type_label">用户邮箱:</span>&nbsp;&nbsp;<span
							class="error" id="userError"></span> <input type="text"
							style="width: 180px; height: 20px" class="text_style"
							id="idNumber" name="idNumber" /></li>
						<li></li>
						<li>登录密码:&nbsp;&nbsp;<span class="error" id="pwdError"></span>
							<input type="password" style="width: 180px; height: 20px"
							class="text_style" id="password" name="password" /></li>



						<li class="login_btn"><input type="button" value="登陆"
							class="normal_btn" id="step_up" onclick="login()" /></li>
						<li class="forget_password_area"><a class="link_style"
							target="_blank" href="Login_findPasswordByEmail">忘记密码？</a>&nbsp;&nbsp;
							<a class="link_style" href="#"
							onclick="ShowDiv('reguser','fade')">注册账号</a>
						</li>
					</ul>
				</div>
			</form>
		</div>
		<!-- 用户注册 -->

		<div id="reguser" class="LoginWindowHeaderBox"
			style="left: 50px; top: 250px; display: none;">
			<ul>
				<li class="normal_title_left"></li>
				<li class="normal_title_right"></li>
				<li class="normal_title_content">用户注册 <a href="#"
					onclick="CloseDiv('reguser','fade')"> <img
						src="${image_path}/close.png" width="30" height="30"
						style="float: right" /> </a></li>
			</ul>
			<form action="Login_regUser" method="post" name="loginForm"
				id="regForm">
				<div class="normal_content_reg">
					<div style="margin: 20px 30px 15px 80px;"></div>
					<ul>
						<li><span id="type_label">用户邮箱:</span>&nbsp;&nbsp; <input
							type="text" style="width: 180px; height: 20px" class="text_style"
							id="email" name="email" /></li>
						<li><span id="type_label">手机号码:</span>&nbsp;&nbsp; <input
							type="text" style="width: 180px; height: 20px" class="text_style"
							id="mobilephone" name="mobilephone" /></li>
						<li>输入密码:&nbsp;&nbsp; <input type="password"
							style="width: 180px; height: 20px" class="text_style"
							id="firstpassword" name="firstpassword" /></li>
						<li>确认密码:&nbsp;&nbsp; <input type="password"
							style="width: 180px; height: 20px" class="text_style"
							id="secondpassword" name="secondpassword" /></li>


						<li class="login_btn"><input type="button" value="注册"
							class="normal_btn" id="step_up" onclick="reg()" /></li>
					</ul>
				</div>
			</form>
		</div>

	</div>
</div>


<!-- 回到顶部 -->
<div id="elevator_item">
        <a id="elevator"  title="回到顶部"></a>
        <a class="qr"></a>
  	<div class="qr-popup">
    	<a class="code-link"><img class="code" src="${image_path}/wx.jpg"/></a>
        <span>扫一扫二维码加我QQ</span>
    <div class="arr"></div>
  </div>
  
</div>
