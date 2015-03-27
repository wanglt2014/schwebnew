<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

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
	
%>
<html>
<head>
<meta name=page-view-size content=1280*720 />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

function dianbo(){
	$("#submitForm").submit();
	//document.getElementById("submitForm").submit();
	//window.history();
}
var secs = 5;
function turnpage()
	{
		
		for(var i=0;i<=secs;i++) 
		{ 
			window.setTimeout("update(" + i + ")", i * 1000); 
		}
		
		setTimeout("hidediv()",5000);
		//setTimeout("window.location.href='http://114.242.25.23:80/Pay-Gateway-Web-PC/BankcmbPay_acceptMeaasgeFromcmbBank?Succeed=Y&CoNo=000000&BillNo=000000&Amount=0.1&Date=20110401&MerchantPara=201104010000003343,Anybody@anysite.com,NoLogin&Msg=10000000002011040100000000000000000000&Signature=131|216|34|143|199|70|215|220|76|72|25|104|48|30|54|56|56|59|254|155|39|169|181|15|141|174|135|69|232|113|47|115|59|141|90|140|50|246|209|127|82|67|215|175|181|98|33|181|33|149|197|108|251|39|215|148|172|25|34|180|43|36|96|140|';",7000);			
		
	}
	
function hidediv()
{
	document.getElementById("divturn").innerHTML="<br><font style='font-size:18px; font-weight:bold;'>已转向缴费平台首页，如有疑问请与客服联系。</font>";
	
	btnturn();
}
function btnturn(){
	window.location.href="http://www.59et.com/cus/";
}

function update(num) 
{ 
	var printnr = secs-num; 
	document.getElementById("lbsecs").innerHTML= 
		"<font style='font-size:24px; color:#CC3300; font-weight:bold;'> " + printnr + "&nbsp;</font>";
}   

</script>
</head>
<body onload="turnpage()">
<!-- 正在跳转到支付宝(http://www.59et.com)进行鉴权，请稍后... -->

<div id="content">
	<div class="result_tips">
	<div class="result_content">你还未登陆，请先登陆广电缴费平台,5秒钟后将自动转到主页...</div>
    <hr id="idhr" align="left" color="DDDDDD" noshade size="0" width="100%"/>
    <div id=divturn  style=" height:80px;width:100%; "><label id=lbsecs style="border:none; color:#ffffff; width:10px;"></label><font style="font-size:14px; font-family:'宋体'; font-weight:bold; color:#666666">秒后将转向缴费系统主页面。</font><br><br><input value="立即跳转" type="button" onclick="btnturn()" />
	</div>
	</div>
	
</div>
<form action="http://${bsUserAuth.domain}/main/UserAuth_sumapayLogin" method="post" id="submitForm"  name="submitForm" style="display: none;">
<table style="width:100%;text-align: center">
	<tr>
		<td colspan="2">Test userauth</td>
	</tr>
	
	<tr>
		<td style="text-align: right">merchant:</td>
		<td style="text-align: left"><input type="text" name="merchant" value="${bsUserAuth.merchant}" /></td>
	</tr>
	<tr>
		<td style="text-align: right">data:</td>
		<td style="text-align: left"><input type="text" name="data" value="${bsUserAuth.data}" /></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="button" value="使用支付宝账户登录" onclick="dianbo()" />
		</td>
	</tr>
</table>

</form>
</body>
</html>
