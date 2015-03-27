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
	request.setAttribute("cur_nav", 2);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="产品订购业务-在线查询 ,根据会员卡号查询订购的产品服务" />
<title>续费查询_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/product_search.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.validate.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.validate.chinese.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">
function queryproduct(){
	$("#submitForm").action = 'RepeatOrder_toRepeatOrderQuery';
	$("#submitForm").submit();
}
$().ready(function(){
	$("#submitForm").validate();
	if($('#showMessage').val() != ''){
		jAlert($('#showMessage').val(),'提示');
	}

});
</script>
</head>

<body>
<div id="fade" class="black_overlay"></div>
<div class="container">
<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
<s:hidden id="showMessage" name="showMessage"></s:hidden>
<form  name="submitForm" id="submitForm" action="RepeatOrder_toRepeatOrderQuery" method="post">
	<div id="product_sub_content">
		<div class="trade_search_condition">
			<ul>
				<li ><div class="logodiv"><img src="${image_path}/xufei.png" /></div><div class="logodiv">产品续费</div></li>
			</ul>
		</div>
		<div class="product_choose">
			  <div class="bank_pay_step" id="bank_pay_step">
				  <ul class="ul_step_repeat">
				  	<li>
					  产品订购业务-在线查询
					</li>
				  </ul>
			  </div>
		
			
			<div id="pageInfoDiv">
					<div class="withdraw_confirm">
					<div class="confirm_tips"><img src="${image_path}/tips_icon.gif"/>&nbsp;尊敬的用户您好，欢迎您使用网上营业厅业务查询服务，请您输入要查询的会员卡号：</div>
					<div class="confirm_div">
						<table style="width:100%">
							
							<tr>
								<td class="table_title">请输入你要查询的会员卡号:</td>
								<td><input type="text" name="order.orderIccard" id="order.orderIccard" class="required" style="color:black;"/></td>
							</tr>
							
						</table>
					</div>
					<div class="confirm_btn_area">
						<input type="button" value="查询" class="normal_btn" id="confirm_btn" onclick="queryproduct()"/>
					</div>
				</div>
			</div>
			
				<div class="tip_remark">
					<div class="bank_pay_prompt" id="bank_pay_prompt">
					  	<ul class="ul_prompt">
							<li><img src="${image_path}/tips_icon.gif"/>&nbsp;温馨提示:</li>
						</ul>
					</div>
					<div style="font-size: 14px;padding:0px 0px 10px 30px;">
						<p>1.  在线缴费适用于开通网上支付的用户，如果您不清楚网上支付功能，建议您先学习了解网上支付相关知识</p>  
						<p>2.  交费时，请您认真核对银行卡号、交费金额，以防止由于错误输入给您带来的损失和不便。  </p>  
						<p>3.  建议您不要在网吧等公共场所使用本系统，以保证您的账户安全。  </p>  
					</div>
					</div>
		</div>
	
	</div>
	</form>
</div>


<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>
</html>