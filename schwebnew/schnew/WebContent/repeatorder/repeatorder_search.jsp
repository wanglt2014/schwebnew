<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
	
	// 当前导航栏位置
	request.setAttribute("cur_nav",2);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="续费查询结果展示页面" />
<title>产品续费_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/product_search.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

$(document).ready(function(){
	 tradeSearch();
});
function tradeSearch(page){
	var targetPage = '';
	if(!page || (page=='')){
		targetPage = 1;
	}else{
		targetPage = page;
	}
	$.ajax({
		type:'post',
		url:'RepeatOrder_excuteProductQuery',
		data:{
			currentPage:targetPage
			},
		beforeSend:function(html){
			$.blockUI({
				showOverlay: false,
				message:'数据加载中...',
				css: { 
		            border: 'none', 
		            padding: '5px', 
		            backgroundColor: '#000', 
		            '-webkit-border-radius': '10px', 
		            '-moz-border-radius': '10px', 
		            opacity: .5, 
		            color: '#fff' ,
		            top:'200px',
		            left:($(window).width()/2)-80 +'px',
		            width:'150px',
		            height:'20px'
		        }
			});
		},
		success:function(html){
			$.unblockUI();
			$('#pageInfoDiv').html(html);
			
		},
		error:function(){
			$.unblockUI();
		}
	});
}

	
</script>

</head>

<body >
<div id="fade" class="black_overlay"></div>
<div class="container">
<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
	<div id="order_sub_content">
		<div class="trade_search_condition">
			<ul>
				<li ><div class="logodiv"><img src="${image_path}/xufei.png" /></div><div class="logodiv">产品续费</div></li>
			</ul>
		</div>
		<div class="search_area">
			
			<!--  <div class="search_tab_bottom"></div>-->
			
				<div id="pageInfoDiv">
				
				</div>
			
		</div>
	</div>
</div>


<jsp:include page="../bottom.jsp"></jsp:include>
</div>

</body>
</html>