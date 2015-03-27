<%@ page contentType="text/html; charset=utf-8" language="java" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="产品查询，分类：VPS代购，云主机，云运维，软件定制开发，Tiny系列软件销售" />
<title>产品查询_${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/product_search.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css"/>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript">

	$(document).ready(function(){
		var $searchTab = $('.search_tab');
		$searchTab.click(
			function(){
				var $this = $(this);
				
				if ($this.hasClass('search_tab_focus')){
					return;
				}
				
				var $other = $('.search_tab_focus');
				$other.removeClass('search_tab_focus');
				$other.find('li').each(function(){
					var $$this = $(this);
					var imgSrc = $$this.css('backgroundImage');
					imgSrc = imgSrc.replace('.gif','_w.gif');
					$$this.css('backgroundImage',imgSrc);
				});
				
				$this.addClass('search_tab_focus');
				
				var id = $this.attr("id");
				var $li = $this.find('li');
				$li.each(function(){
					var $$this = $(this);
					var imgSrc = $$this.css('backgroundImage');
					imgSrc = imgSrc.replace('_w.gif','.gif');
					$$this.css('backgroundImage',imgSrc)
				});
				if (id == 'search_all'){
					PRODUCT_TYPE = 'JBSSF';
				}else if (id == 'search_success'){
					PRODUCT_TYPE = 'DPDDG';
				}else if (id == 'search_failed'){
					PRODUCT_TYPE = 'PDBDG';
				}else if (id == 'search_vod'){
					PRODUCT_TYPE = 'VOD';
				}else if (id == 'search_internet'){
					PRODUCT_TYPE = 'INTERNET';
				}
				tradeSearch();
			}
		);
		 $($searchTab.get(0)).click();
		 tradeSearch();
		 
	});

	
	var trade_id ;
	var trade_code;


	var PRODUCT_TYPE = 'JBSSF';
	function tradeSearch(page){
		var targetPage = '';
		if(!page || (page=='')){
			targetPage = 1;
		}else{
			targetPage = page;
		}
		$.ajax({
			type:'post',
			url:'Ordering_doProductSearch',
			data:{
				currentPage:targetPage,
				producttype:PRODUCT_TYPE
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
				if (html.indexOf('忘记登录密码') > -1){
					location.href="Login_logout";
				}else{
					$('#pageInfoDiv').html(html);
				}
				
			},
			error:function(){
				$.unblockUI();
			}
		});
	}

</script>

</head>

<body>
<div id="fade" class="black_overlay"></div>
<div class="container">
<jsp:include page="../top.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>

<div id="content">
	<div id="order_sub_content">
		<div class="trade_search_condition">
			<ul>
				<li ><div class="logodiv"><img src="${image_path}/dinggou.png" /></div><div class="logodiv">产品订购</div></li>
			</ul>
		</div>
		<div class="search_area">
			<div class="search_tab" id="search_all">
				<ul>
					<li class="search_tab_left"></li>
					<li class="search_tab_right"></li>
					<li class="search_tab_content">
						云主机
					</li>
				</ul>
			</div>
			
			<div class="search_tab" id="search_success">
				<ul>
					<li class="search_tab_left"></li>
					<li class="search_tab_right"></li>
					<li class="search_tab_content">
						办公用品
					</li>
				</ul>
			</div>
			
			<div class="search_tab" id="search_failed">
				<ul>
					<li class="search_tab_left"></li>
					<li class="search_tab_right"></li>
					<li class="search_tab_content">
						产品TinyShop
					</li>
				</ul>
			</div>
			<div class="search_tab" id="search_vod">
				<ul>
					<li class="search_tab_left"></li>
					<li class="search_tab_right"></li>
					<li class="search_tab_content">
						产品TinyOA
					</li>
				</ul>
			</div>
			<div class="search_tab" id="search_internet">
				<ul>
					<li class="search_tab_left"></li>
					<li class="search_tab_right"></li>
					<li class="search_tab_content">
						产品sch
					</li>
				</ul>
			</div>
			
			<div style="height:26px;">&nbsp;</div>
			<div class="search_tab_bottom"></div>
			
			<div id="pageInfoDiv">
				
			</div>
			
		</div>
	</div>
</div>

<jsp:include page="../bottom.jsp"></jsp:include>

</div>
</body>
</html>