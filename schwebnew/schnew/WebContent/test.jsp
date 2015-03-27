<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	request.setAttribute("cur_nav", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" charset="UTF-8" content="感谢您使用${sitename}" />
<title>${sitename}</title>
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/index.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/flash.css" />
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js" ></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js" ></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.cookie.js" ></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js" ></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/flash.js" ></script>
<%-- <script language="JavaScript" type="text/javascript" src="${js_path}/jquery.min.js" ></script> --%>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.jScroll.js" ></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.cycle.js" ></script>

	<style>
.pics { height:  232px; width:   232px; padding: 0; margin:  0; } 
.pics img { padding: 15px; border:  1px solid #ccc; background-color: #eee; width:  200px; height: 200px; top:  0; left: 0 } 
    </style>
<script type="text/javascript">
$(function(){
// 	$(".scroll_three").jScroll({speed: 2000, scroll: 2});//底部logo滚动
// 	$('#banner').cycle({fx:'scrollLeft',pager:'#btn'});//顶部图片滚动
	$('#biuuu').cycle('fade'); 
});
</script>

</head>
<body >
<div id="biuuu" class="pics"> 
       <img  src="${image_path}/ibanner1.jpg" width="720" height="252"/>
       <img  src="${image_path}/ibanner2.jpg" width="720" height="252"/>
       <img  src="${image_path}/ibanner3.jpg" width="720" height="252"/>
       <img  src="${image_path}/ibanner4.jpg" width="720" height="252"/>
</div> 
</body>
</html>