<%@ page contentType="text/html; charset=utf-8" language="java"%>
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

	// 本页左侧菜单位置
	request.setAttribute("cur_menu", "menu_index");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="Ios,android wp手机客户端下载，以及平板电脑客服端下载" />
<title>手机客户端--${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/mobile.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">
	
</script>

</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container">
		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>

<!-- 		<div id="content"> -->
<!-- 			<div class="center fontWei"> -->
<!-- 				<div class="pictxt"> -->
<!-- 					四小块 -->
<!-- 					<ul> -->
<!-- 						<li class="mr10 mb10"> -->
<!-- 						<a -->
<%-- 							href="${request_path}/android/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/icon_and.gif" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/android/" target="_blank">Android版客户端</a> --%>
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/android/" target="_blank">提供最新IT资讯、摄影美图/产品图赏、IT产品报价库、论坛热帖、Android应用推荐等服务，支持Android手机平台。</a> --%>
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow">最新版本：V3.7.0（5.3MB）<a -->
<%-- 								href="${request_path}/mobile/pconline.apk" --%>
<!-- 								target="_blank">立即下载</a> </span> -->
						
<!-- 						</li> -->
<!-- 						<li class="ml10 mb10"><a -->
<%-- 							href="${request_path}/iphone/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/icon_iph.gif" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/iphone/" target="_blank">iPhone版客户端</a> --%>
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/iphone/" target="_blank">提供最新IT资讯、摄影美图/产品图赏、IT产品报价库、论坛热帖、iOS应用推荐等服务，支持iPhone、iPod --%>
<!-- 											touch设备。</a> -->
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow">最新版本：V3.7.0（8.7 MB）<a -->
<!-- 								href="http://itunes.apple.com/cn/app/id415249203?mt=8" -->
<!-- 								target="_blank">立即下载</a> </span></li> -->
<!-- 						<li class="mt10 mr10 mb10"><a -->
<%-- 							href="${request_path}/download/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/4811477_logo3.png" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/download/" target="_blank">移动下载客户端</a> --%>
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/download/" --%>
<!-- 											target="_blank">为用户提供海量、最新、最热门的安卓游戏、安卓手机软件下载。以“轻应用”概念打造&mdash;&mdash;最轻便、最快速、最简洁的手机应用商店。</a> -->
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow">最新版本：V1.0.1（2.18 MB）<a -->
<%-- 								href="${request_path}/dl/android.apk" --%>
<!-- 								target="_blank">立即下载</a> </span></li> -->
<!-- 						<li class="mt10 ml10 mb10"><a -->
<%-- 							href="${request_path}/syblHD/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/icon_sybl.gif" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/syblHD/" --%>
<!-- 										target="_blank">摄影部落HD</a> <span><i class="news"><a>NEW</a> -->
<!-- 									</i> </span> -->
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/syblHD/" --%>
<%-- 											target="_blank">${sitename}网推出的一款iPad图库类应用，精选线上近百万张美图供您欣赏。致力于提供最好的iPad图片浏览体验，打造最好的原创数码摄影分享平台。</a> --%>
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow">最新版本：V2.2.1（15.1MB）<a -->
<!-- 								href="#" -->
<!-- 								target="_blank">立即下载</a> </span></li> -->
<!-- 						<li class="mt10 mr10"><a -->
<%-- 							href="${request_path}/waps/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/icon_wap.gif" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/wap/" target="_blank">WAP站</a> --%>
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/wap/" target="_blank">提供最新IT资讯、产品报价查询等服务，在手机浏览器地址栏中输入g.59et.com即可浏览，支持任何手机平台。</a> --%>
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow detail"> <a -->
<%-- 								href="${request_path}/wap/" target="_blank">查看详情</a> --%>
<!-- 						</span></li> -->
<!-- 						<li class="mt10 ml10  mb10"><a -->
<%-- 							href="${request_path}/iphone/" target="_blank" --%>
<!-- 							class="ptPic" style="left: 30px;"> <img width="64" -->
<!-- 								height="66" -->
<%-- 								src="${image_path}/icon_iph.gif" --%>
<!-- 								alt=""> -->
<!-- 						</a> -->
<!-- 							<dl class="ptTxt" style="right: 27px;"> -->
<!-- 								<dt> -->
<%-- 									<a href="${request_path}/iphone/" target="_blank">WP版客户端</a> --%>
<!-- 								</dt> -->
<!-- 								<dd> -->
<!-- 									<p> -->
<%-- 										<a href="${request_path}/iphone/" target="_blank">提供最新IT资讯、摄影美图/产品图赏、IT产品报价库、论坛热帖、WP应用推荐等服务，支持WP --%>
<!-- 											touch设备。</a> -->
<!-- 									</p> -->
<!-- 								</dd> -->
<!-- 							</dl> <span class="dow">最新版本：V3.7.0（8.7 MB）<a -->
<!-- 								href="#" -->
<!-- 								target="_blank">立即下载</a> </span></li> -->
<!-- 					</ul> -->
<!-- 					四小块 -->
<!-- 					<div class="clear"></div> -->
<!-- 				</div> -->
<!-- 				<div class="infMod"> -->
<!-- 					<div class="modB modBl"> -->
<!-- 						<div class="thB">产品动态</div> -->
<!-- 						<div class="tbB"> -->
<!-- 							<ul> -->
<!-- 								<li><a target="_blank" -->
<%-- 									href="${request_path}/483/4838917.html">强烈推荐!PConline移动下载安卓版发布</a><span>2014-05-27 --%>
<!-- 								</span> -->
<!-- 								</li> -->
<!-- 								<li><a target="_blank" -->
<%-- 									href="${request_path}/447/4476696.html">电脑网Android客户端3.7公测开启</a><span>2014-03-21 --%>
<!-- 								</span> -->
<!-- 								</li> -->
<!-- 								<li><a target="_blank" -->
<%-- 									href="${request_path}/446/4463980.html">电脑网iPhone客户端3.7公测开启</a><span>2014-03-19 --%>
<!-- 								</span> -->
<!-- 								</li> -->
<!-- 								<li><a target="_blank" -->
<%-- 									href="${request_path}/384/3848536.html">省钱不只双11!今日聚超值安卓/iOS客户端上线</a><span>2013-11-19 --%>
<!-- 								</span> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="modB modBr"> -->
<!-- 						<div class="thB">商务合作</div> -->
<!-- 						<div class="tbB"> -->
<!-- 							<ul> -->
<!-- 								<li>联系人：刘先生</li> -->
<!-- 								<li>QQ：422293101</li> -->
<!-- 								<li>电话：150-0132-7397</li> -->
<!-- 								<li>地址：北京市朝阳区莱锦文化创意产业园</li> -->
<!-- 							</ul> -->
<!-- 							<a class="weibo" target="_blank" href="http://weibo.com/et59">关注我们</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="clear"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->


		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>