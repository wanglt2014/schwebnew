<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
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
	request.setAttribute("cur_menu","menu_index");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="常见问题解答，常见问题汇总分类" />
<title>常见问题_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/question.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

</script>

</head>

<body>
<div id="fade" class="black_overlay"></div>
<div class="container">
<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
<!-- <div id="content"> -->
<!--             <div class="inner"> -->
<!--                 <div class="inner_tit"> -->
<!--                     常见问题分类导航 -->
<!--                 </div> -->
<!--                 <div class="inner_con"> -->
<!--                     <div class="type type1"> -->
<%--                         <h3><a href="${request_path}/faq/huiyuan/">会员类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/huiyuan/hyzc/Index.html">会员注册</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/xxxg/Index.html">信息修改</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/cpgl/Index.html">产品管理</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/jfhd/Index.html">积分活动</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/passwd/Index.html">忘记密码</a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type2"> -->
<%--                         <h3><a href="${request_path}/faq/caiwu/">财务类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/caiwu/hkwt/Index.html">汇款问题</a></li> --%>
<%--                             <li><a href="${request_path}/faq/caiwu/fpwt/Index.html">发票问题</a></li> --%>
<%--                             <li><a href="${request_path}/faq/caiwu/wrhk/Index.html">无人认领汇款</a></li> --%>
<%--                             <li><a href="${request_path}/faq/caiwu/tkwt/Index.html">退款问题</a></li> --%>
<%--                             <li><a href="${request_path}/faq/caiwu/xufei/Index.html">续费问题</a></li> --%>
<!--                     </ul></div> -->
<!--                     <div class="type type3"> -->
<%--                         <h3><a href="${request_path}/faq/yuming/">域名类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/yuming/ymzc/Index.html">注册域名</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymxf/Index.html">域名续费</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/url/Index.html">解析URL转发</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymgh/Index.html">域名信息修改过户</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymsite/Index.html">域名空间站</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymzy/Index.html">域名转移注册商</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymzhi/Index.html">域名增值服务</a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type4"> -->
<%--                         <h3><a href="${request_path}/faq/xuni/">主机类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/xuni/zjgm/Index.html">主机购买</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjgl/Index.html">管理主机</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/balancing/Index.html">负载均衡服务</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zujian/Index.html">功能组件支持 </a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjxs/Index.html">主机续费升级</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/only/Index.html">独享主机服务器  </a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/ftppw/Index.html">FTP上传</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/database/Index.html">数据库</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/ziyou/Index.html">云服务器</a></li> --%>
<!--         		       <li><a href="http://help.aliyun.com/manual?lastSortId=228">阿里云云服务器</a></li> -->
<%-- 			<li><a href="http://www.net.cn${request_path}/faq/xuni/yundun/">云盾</a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type5"> -->
<%--                         <h3><a href="${request_path}/faq/youx/">邮箱类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/youx/mailsy/Index.html">网页版邮箱功能</a></li> --%>
<%--                             <li><a href="${request_path}/faq/youx/mailgroup/Index.html">客户端设置</a></li> --%>
<%--                             <li><a href="${request_path}/faq/youx/cloudmail/Index.html">收发问题</a></li> --%>
<%--                             <li><a href="${request_path}/faq/youx/cloudmxbs/Index.html">开通指南</a></li> --%>
<%--                             <li><a href="${request_path}/faq/youx/bsmail/Index.html">常见问题</a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type6"> -->
<%--                         <h3><a href="${request_path}/faq/jzwt/">建站类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/jzwt/sitelc/Index.html">建站流程介绍</a></li> --%>
<%--                             <li><a href="${request_path}/faq/jzwt/scsite/Index.html">速成高级版及标准网站</a></li> --%>
                            
<%-- <li><a href="${request_path}/faq/jzwt/scyy/Index.html">速成易用版 </a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type7"> -->
<%--                         <h3><a href="${request_path}/faq/softfaq">技术类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/softfaq/jiaocheng/Index.html">虚拟主机教程</a></li> --%>
<%--                             <li><a href="${request_path}/faq/softfaq/jsp/Index.html">JSP技术</a></li> --%>
<%--                             <li><a href="${request_path}/faq/softfaq/aspnet/Index.html">ASP.NET技术</a></li> --%>
<%--                             <li><a href="${request_path}/faq/softfaq/jspcx/Index.html">JSP程序模板</a></li> --%>
<%--                             <li><a href="${request_path}/faq/softfaq/aspnetcx/Index.html">ASP.NET程序模板</a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                     <div class="type type8 bn"> -->
<%--                         <h3><a href="${request_path}/faq/other/">其他类</a></h3> --%>
<!--                         <ul class="category"> -->
<%--                             <li><a href="${request_path}/faq/other/icp/Index.html">ICP备案 </a></li> --%>
<!--                         </ul> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div style="width: 225px; left: 735px; position: absolute; top: 0;"> -->
<!--                 <div style="width: 225px; height: 50px; margin-bottom: 10px; cursor: pointer;"> -->
<!--                     <a target="_blank" href="http://app.askform.cn"><img title="帮助中心改版调查" alt="帮助中心改版调查" src="http://gtms01.alicdn.com/tps/i1/T1gTwlFbFaXXbbT46n-225-50.gif"/></a></div> -->
<!--                 <div class="right_bd"> -->
<!--                     <div class="right_bd_top"> -->
<!--                     </div> -->
<!--                     <div class="right_bd_con"> -->
<!--                         <h3>热点问题</h3> -->
<!--                         <ul class="right_bd_list"> -->
<%--                             <li><a href="${request_path}/faq/xuni/zjgm/201312/6221.html">轻云服务器的优势</a></li> --%>
<%--                             <li><a href="${request_path}/faq/youx/cloudmxbs/201309/6099.html">企业邮箱转入流程</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjxs/201308/6090.html">哪些用户可以享受免费迁移服…</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjxs/201308/6089.html">轻云服务器免费数据迁移服务…</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjxs/201308/6074.html">数据迁移页面如何填写？</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/hyzc/201308/6062.html">新版登录页面介绍</a></li> --%>
<%--                             <li><a href="${request_path}/faq/yuming/ymgh/201308/6044.html">如何修改域名注册联系人邮箱</a></li> --%>
<%--                             <li><a href="${request_path}/faq/huiyuan/xxxg/201307/6039.html">备用邮箱更换提示</a></li> --%>
<%--                             <li><a href="${request_path}/faq/xuni/zjgl/201304/5935.html">虚拟主机升级轻云服务器流程</a></li> --%>
<!--                         </ul> -->
<!--                         <h3>常用文档下载</h3> -->
<!--                         <ul class="right_bd_list"> -->
<%--                             <li><a href="${request_path}/ziliao/ywwd/hyid/201301/359.html">重置会员密码/密保申请表</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywwd/hyid/201301/345.html">业务转移申请表</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywwd/hyid/201301/338.html">会员账号所有人变更申请表</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywwd/yml/201301/4941.html">转入域名申请解锁免责声明</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywlc/qita/201110/465.html">业务转移流程</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywlc/yml/201110/462.html">国内域名转入流程</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/cpsc/201012/4514.html">Windows云主机使用手册</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/alfx/200611/1588.html">无法收取新邮件的几种解决办</a></li> --%>
<%--                             <li><a href="${request_path}/ziliao/ywlc/zjl/200603/922.html">修改主机管理员密码流程</a></li> --%>
                             
<!--                         </ul> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
	<div class="problem_area">
		<ul>
			<c:forEach items="${qaList}" var="qa" step="1" varStatus="var">
				<li class="question"><c:out value="${qa.question}" /></li>
				<li class="answer">答：<c:out value="${qa.answer}" /></li>
			</c:forEach>
		</ul>
	</div>
</div>
	

<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>
</html>