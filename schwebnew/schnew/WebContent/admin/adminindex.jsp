<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", -10);
	String request_path = request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	String basePath = request.getScheme() + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + request_path + "/";   
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">   
<title>${sitename}--后台管理系统</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<link rel="stylesheet" type="text/css"
	href="${css_path}/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/comments.css" />

<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript" src="${js_path}/menu.js"></script>
<script type="text/javascript" src="${js_path}/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="${js_path}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${js_path}/jquery.alerts.js"></script>
<link type="text/css" rel="stylesheet" href="${request_path}/umeditor/themes/default/css/umeditor.css" >
<script language="JavaScript"> 
function getMyName(){ 
   var image_accessurl_upload="<%=session.getAttribute("image_accessurl_upload")%>"; 
   alert(image_accessurl_upload); 
} 
</script> 

<script type="text/javascript" charset="utf-8" src="${request_path}/umeditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${request_path}/umeditor/umeditor.min.js"></script>
<script type="text/javascript" src="${request_path}/umeditor/lang/zh-cn/zh-cn.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/footer.js" charset="UTF-8"></script>
<%--引入SWFUpload控制文件 --%>
<script type="text/javascript">
	var request_path ="<%=request_path%>";
</script>
<%-- <link rel="stylesheet" href="${js_path}/swfupload/swfupload.css" type="text/css" media="screen" /> --%>
<%-- <script type="text/javascript"	src="${js_path}/swfupload/fileprogress.js"></script> --%>
<%-- <script type="text/javascript"	src="${js_path}/swfupload/singlefileprogress.js"></script> --%>
<%-- <script type="text/javascript"	src="${js_path}/swfupload/swfupload.js"></script> --%>
<%-- <script type="text/javascript"	src="${js_path}/swfupload/swfupload.queue.js"></script> --%>
<%-- <script type="text/javascript"	src="${js_path}/swfupload/SWFUpload_zh.js"></script> --%>

<!-- <script type="text/javascript" -->
<%-- 	src="${basePath}js/ajaxfileupload.js"></script> --%>
<!-- <script type="text/javascript" -->
<%-- 	src="${basePath}js/fileUploadHandle.js"></script> --%>
<%-- <link rel="stylesheet" type="text/css" href="${js_path}/uploadify/uploadify.css"> --%>
<%-- <script type="text/javascript" src="${js_path}/jquery-1.7.2.min.js"></script> --%>
<%-- <script type="text/javascript" src="${js_path}/uploadify/jquery.uploadify.js"></script> --%>
<!--  <script type="text/javascript"  -->
<%--  	src="${js_path}/swfobject.js"></script>  --%>
<%-- <link rel="stylesheet" type="text/css" href="${js_path}/plupload/queue/css/jquery.plupload.queue.css"> --%>
<%-- <script type="text/javascript" src="${request_path}/plupload/js/plupload.full.js"></script> --%>
<%-- <script type="text/javascript" src="${request_path}/js/plupload/queue/jquery.plupload.queue.js"></script> --%>

<script type="text/javascript" src="${js_path}/plupload/plupload.full.min.js"></script>
<script type="text/javascript" src="${js_path}/plupload/pluploadEXT.js"></script>
<%-- <script type="text/javascript" src="${request_path}/plupload/js/i18n/cn.js"></script> --%>

<%-- <script type="text/javascript" src="${js_path}/plupload/queue/jquery.plupload.queue.js"></script> --%>
<%-- <script type="text/javascript" src="${js_path}/plupload/i18n/cn.js"></script> --%>

<script language="JavaScript" type="text/javascript" src="${js_path}/util.js" charset="UTF-8"></script>
<script type="text/javascript" src="${js_path}/easyui/easyui-lang-zh_CN.js"></script>
	<style>
	body{ font-size: 12px;}
	body,p,div{ padding: 0; margin: 0;}
	.wraper{ padding: 30px 0; text-align: left;}
	.btn-wraper{ text-align: left;}
	.btn-wraper input{ margin: 0 10px;}
	#file-list{ width: 350px; margin: 20px auto;}
	#file-list li{ margin-bottom: 10px;}
	.file-name{ line-height: 30px;}
	.progress{ height: 4px; font-size: 0; line-height: 4px; background: orange; width: 0;}
	.tip1{text-align: center; font-size:14px; padding-top:10px;}
    .tip2{text-align: center; font-size:12px; padding-top:10px; color:#b00}
    .catalogue{ position: fixed; _position:absolute; _width:200px; left: 0; top: 0; border: 1px solid #ccc;padding: 10px; background: #eee}
    .catalogue a{ line-height: 30px; color: #0c0}
    .catalogue li{ padding: 0; margin: 0; list-style: none;}
    </style>
</head>
<script type="text/javascript">
	$(function() {
		$('#tt').tree(
				{
					onClick : function(node) {
						if ($.trim(node.menuurl) == ""
								|| $.trim(node.menuurl) == "undefined"
								|| $.trim(node.menuurl) == null) {

						} else {
							var url = "${request_path}/" + node.menuurl;
							open1(node.text, url); // alert node text property when clicked
						}
					}
				});
	});

	function open1(name, url) {
		if ($('#right_tab').tabs('exists', name)) {
			$('#right_tab').tabs('select', name);
		} else {
			var iframestr=" <iframe  src="+url+" style=\"border: 0; width: 100%; height: 99%;\"></iframe>";
			if (url.indexOf("html") >= 0|| url.indexOf("monitoring")>= 0) {
				$('#right_tab').tabs('add', {
					title : name,
					content : iframestr,
					closable : true
				});
				//$("#tab_iframe_div").html(iframestr);
			} else {
				$('#right_tab').tabs('add', {
					title : name,
					href : url,
					closable : true

				});
			}

		}
	}
</script>
<body>
	<div></div>
	<div class="easyui-layout" style="width: auto; height: 790px;">
		<div data-options="region:'north'"
			style="height: 80px;background: url(${image_path}/body_bg.png) repeat-x scroll center 0 rgba(0, 0, 0, 0);">
			<font style="font-size: 30px; line-height: 75px; font-style: italic;">后台管理系统</font>
			<div style="float: right; margin-bottom: 5px; margin-top: 50px;">
				<c:if test="${!empty(user)}">
				管理员：<c:out value="${user.username}" />
					<a href="Admin_logout">[退出]</a>
				&nbsp;|&nbsp;
			</c:if>
					<a href="${request_path}"
					target="_blank">网站前台</a> &nbsp;|&nbsp;
			</div>
		</div>
		<div data-options="region:'west',split:true" title="系统菜单"
			style="width: auto; max-width: 177px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<ul id="tt" class="easyui-tree"
					data-options="url:'${request_path}/Menu_query',method:'get',animate:true,dnd:true">
				</ul>
			</div>
		</div>
		<div data-options="region:'center',title:'主界面',iconCls:'icon-ok'"
			style="width: auto;">
			<div id="right_tab" class="easyui-tabs"
				data-options="fit:true,border:false,plain:true">
				<div title="关于" id="tab_iframe_div"
					data-options="href:'${request_path}/admin/about.html'"
					style="padding: 10px">
				
				</div>

			</div>
		</div>
	</div>
	<div id="bottom"><jsp:include page="../bottom.jsp"></jsp:include></div>
</body>
</html>