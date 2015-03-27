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
	request.setAttribute("cur_menu","menu_index");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description" content="${sitename}办事处的联系方式，地址，邮编" />
<title>联系我们_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/question.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

</script>

</head>

<body>
<div id="fade" class="black_overlay"></div>
<div class="container"><jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">


<div class="porductIntro" style="padding: 0 10px">

	<h2>联系我们</h2>
	<p></p>
		<div class="split_spx"></div>
	
	<div class="porductIntro" style="font-size: 14px;">
	
	<h3>联系方式</h3>
<!-- 	<table cellspacing="0" cellpadding="0" border="0" class="b_l_c"> -->
<!--         <tbody> -->
<!--         <tr>  -->
<!--           <td><br/> -->
<!--             <table cellspacing="0" cellpadding="0" border="0" class="show"> -->
<!--               <tbody><tr>  -->
<!--                 <td width="50%" valign="top" align="center"> -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">北京总部</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">总机：200-62266296  -->
<!--                         传真 200--12345678<br/> -->
<!--                         销售热线：1500-0132-7397<br/> -->
<!--                         战略合作：200--12345678 -->
<!-- <br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：100191</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">浙江59ET</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：100-27900901  -->
<!--                         传真：100-27900990 <br/> -->
<!--                         客服热线：100-27900691<br/> -->
<!--                         孵化基地服务中心：100-27900676<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦 <br/> -->
<!--                         邮编：315012</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--               </tr> -->
<!--             </tbody></table> -->
<!--             <table cellspacing="0" cellpadding="0" border="0" class="show"> -->
<!--               <tbody><tr>  -->
<!--                 <td width="50%" valign="top" align="center"> -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">天津分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：022-88350835  -->
<!--                         传真：022-88350833<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：300121</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">北京分公司  --%>
<!--                         </span></td> -->
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：200-82211266  -->
<!--                         传真：200-82211029<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：100191</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--               </tr> -->
<!--             </tbody></table> -->
<!--             <table cellspacing="0" cellpadding="0" border="0" class="show"> -->
<!--               <tbody><tr>  -->
<!--                 <td width="50%" valign="top" align="center"> -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">南京分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：025-86468300  -->
<!--                         传真：025-86468389<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B1B2座<br/> -->
<!--                         邮编：210005</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">上海分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：021--12345678  -->
<!--                         传真：021--12345678<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：200063</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--               </tr> -->
<!--             </tbody></table> -->
<!--             <table cellspacing="0" cellpadding="0" border="0" class="show"> -->
<!--               <tbody><tr>  -->
<!--                 <td width="50%" valign="top" align="center"> -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">广州分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：020--12345678  -->
<!--                         传真：020--12345678<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：510075</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">杭州分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：0571--12345678 -->
<!--                         传真：0571--12345678<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：310011</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--               </tr> -->
<!--             </tbody></table> -->
<!--           </td> -->
<!--         </tr> -->
<!--         <tr> -->
<!--           <td> -->
<!--             <table cellspacing="0" cellpadding="0" border="0" class="show"> -->
<!--               <tbody><tr>  -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">59ET渠道</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：200-12345678 -->
<!--                         传真：200-xxxxx<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：100191</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--                 <td width="50%" valign="top" align="center">  -->
<!--                   <table width="94%" cellspacing="5" cellpadding="0" border="0"> -->
<!--                     <tbody><tr>  -->
<%--                       <td align="left"><img width="16" border="0" height="17" src="${image_path}/next_icon.gif"/><span class="redtxt">深圳分公司</span></td> --%>
<!--                     </tr> -->
<!--                     <tr>  -->
<!--                       <td align="left" style="PADDING-LEFT: 16px">电话：0755-xxxxxxx  -->
<!--                         传真：0755-12345678<br/> -->
<!--                         地址：北京市海淀区学院路51号首享科技大厦<br/> -->
<!--                         邮编：518028</td> -->
<!--                     </tr> -->
<!--                   </tbody></table> -->
<!--                 </td> -->
<!--               </tr> -->
<!--             </tbody></table> -->
<!--           </td> -->
<!--         </tr> -->
<!--         <tr>  -->
<!--           <td>&nbsp;</td> -->
<!--         </tr> -->
<!--       </tbody></table> -->

	<p>&nbsp;</p>
</div>
<div class="back"><a href="javascript:window.close()">关闭本窗口</a></div>
</div>
</div>
<jsp:include page="../bottom.jsp"></jsp:include></div>
</body>
</html>