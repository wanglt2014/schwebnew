<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>

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
	request.setAttribute("cur_nav", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$(".isservices .services_but").click(function() {
			$(this).hide();
			$(".isservices .services_act").show();
		});
		$(".isservices .services_act .title a").click(function() {
			$(this).parents(".services_act").hide();
			$(".isservices .services_but").show();
		});
	});
</script>
</head>
<body>
	<div class="isservices">
		<a style="display: block;" class="services_but" href="javascript:;"></a>
		<div class="services_act" style="display: none;">

			<div class="title">
				让生活，更简单！<a href="javascript:;"></a>
			</div>
			<div class="content">
				<div class="picture">
					<img alt="" src="${image_path}/services_picture.png">
				</div>
				<div class="stitle">
					<span>学校信息化建设服务</span>
				</div>
				<div class="im">
					<p>
					<a target="_blank"
						href="http://shang.qq.com/wpa/qunwpa?idkey=deec408119eda2246c7c7aa862665167a172af85d3cdc4d72fef01631013ae8f"><img
						border="0" src="http://pub.idqqimg.com/wpa/images/group.png"
						alt="${sitename}" title="${sitename}">
					</a>
					</p>
					<p>
						<a
							href="http://wpa.qq.com/msgrd?v=3&amp;uin=422293101&amp;site=qq&amp;menu=yes"
							target="_blank"><img border="0" title="点击这里给我发消息"
							alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=2:422293101:41">
						</a>
					</p>
					<p>
						<a
							href="tencent://message/?uin=422293101&amp;Site=www.59et.com&amp;Menu=yes"
							target="blank"><img border="0" alt="点击这里给我发消息"
							src="http://wpa.qq.com/pa?p=1:422293101:7"> </a>
					</p>
					
				</div>
				<ul>
					<li>联 系：王先生</li>
					<li>手 机：10000000000</li>
					<li>电 话：010-xxxxxxxx</li>
				</ul>
				<div class="foot">BBS software</div>
			</div>
		</div>
	</div>
	<style type="text/css">
.isservices {
	position: fixed;
	right: 0px;
	top: 30%;
	z-index: 111111;
	_position: absolute;
	_top: expression(documentElement.scrollTop +             150 +            
		"px");
}

.isservices .services_but {
	display: inline-block;
	background: url(${image_path}/services_but.png) no-repeat;
	width: 48px;
	height: 151px;
}

.isservices .services_act {
	width: 150px;
}

.isservices .services_act .title {
	background: url(${image_path}/services_title.png) no-repeat;
	height: 34px;
	line-height: 34px;
	padding-left: 10px;
	color: #f5f7f9;
	font-family: "微软雅黑";
	font-size: 16px;
	position: relative;
	zoom: 1;
}

.isservices .services_act .title a {
	position: absolute;
	right: 0;
	top: 0;
	width: 30px;
	height: 100%;
}

.isservices .services_act .content {
	border: #cacaca solid 1px;
	border-top: none;
	background-color: #fff;
}

.isservices .services_act .content .picture {
	font-size: 0;
	text-align: center;
	padding: 3px 0;
}

.isservices .services_act .content .stitle {
	background: url(${image_path}/services_stitle_bg.png) repeat-x;
	height: 32px;
	line-height: 32px;
}

.isservices .services_act .content .stitle span {
	display: inline-block;
	height: 100%;
	background: url(${image_path}/services_stitle_arrow.png) no-repeat left
		center;
	padding-left: 15px;
	margin-left: 10px;
	font-size: 12px;
	color: #fff;
}

.isservices .services_act .content .im {
	text-align: center;
	padding: 5px 0;
}

.isservices .services_act .content .im p {
	padding: 5px 0;
}

.isservices .services_act .content ul {
	font-size: 12px;
	color: #666;
	border-top: #c8dee9 solid 1px;
	padding: 8px;
}

.isservices .services_act .content .foot {
	background: url(${image_path}/services_foot.png) repeat-x;
	height: 24px;
	line-height: 24px;
	text-align: right;
	padding-right: 10px;
	font-family: "微软雅黑";
	font-size: 12px;
	color: #fff;
}

.isservices .services_act .content .foot span {
	vertical-align: super;
	font-size: 10px;
}
</style>
</body>
</html>