<%@ page contentType="text/html; charset=utf-8" language="java"
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
	request.setAttribute("cur_nav", 4);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="商务合作，各地区区域销售代表联系方式展示" />
<title>商务合作_${sitename}</title>

<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="${css_path}/subindex.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.cookie.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery-1.3.2.min.js"></script>

</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container" style="position: relative;">

		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>


		<div style="position: relative; margin: 5px 0px 10px 0px;">
			<div id="index_top">
				<div id="left_content">
					<div id="flash_div">
						<div class="flash_left"></div>
						<div class="flash_content"><jsp:include page="chinamap2.jsp"></jsp:include></div>
						<div class="flash_right"></div>
					</div>



				</div>
				<div id="right_content_top">
					<ul>
						<li class="normal_title_left"></li>
						<li class="normal_title_right"></li>
						<li class="normal_title_content">
							全国销售总代表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</li>
					</ul>
					<div class="normal_content_top">
						<ul class="news_content">
							<li>联系人:Harries</li>
							<li>手机：150-0132-7397</li>
							<li>Email: jxausea@163.com</li>
							<li>${sitename}</li>
							<li>欢迎新老客户来电咨询</li>
						</ul>
					</div>
				</div>
				<div id="right_content_bottom">
					<ul>
						<li class="normal_title_left"></li>
						<li class="normal_title_right"></li>
						<li class="normal_title_content">
							地区销售代表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</li>
					</ul>
					<div class="normal_content_bottom" id="merchantinfo">
						<ul class="news_content">
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
							<li><a target="_blank"
								href="tencent://message/?uin=422293101&Site=59et.com&Menu=yes">
									<img src="${image_path}/qq.jpg" alt="click me" /> </a>
							</li>
						</ul>
					</div>
				</div>

			</div>
			<div id="service_div">
				<div class="merchant_info_new">
					<div class="merchantinfo_title">合作伙伴</div>
					<div class="split_spx"></div>
					<div class="merchantinfo_logo">
						<a href="http://www.angelcrunch.com" target="_blank" ><img src="${image_path}/angelcrunch.jpg" width="180" height="42" alt="天使汇"/></a>
						<a href="http://www.cyzone.cn" target="_blank"><img src="${image_path}/cyzone.jpg" width="180" height="42" alt="创业邦"/></a>
						<a href="http://www.gnygy.com" target="_blank"><img src="${image_path}/gnygy.jpg" width="180" height="42" alt="给你几个亿"/> </a>
						<a href="http://tisiwi.com" target="_blank"><img src="${image_path}/tianshiwan.jpg" width="180" height="42" alt="天使湾"/></a>
						<a href="http://www.36kr.net" target="_blank"><img src="${image_path}/36kr.jpg" width="180" height="42" alt="36氪"/></a>
					</div>
				</div>
				<div class="service_right"></div>
			</div>

		</div>

		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>