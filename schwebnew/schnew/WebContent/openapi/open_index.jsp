<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%
	String request_path = request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="开发平台，提供手机端的接口，以及基于oauth2开发的api,方便大家调试">
<title>${sitename}_OPEN_API</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/admin/openapi.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/comments.css"/>
<link rel="stylesheet" type="text/css" href="${css_path}/jquery.alerts.css" />
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript" src="${js_path}/menu.js"></script>
<script type="text/javascript" src="${js_path}/jquery.json-2.4.min.js"></script>
<script type="text/javascript"src="${js_path}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${js_path}/jquery.alerts.js" ></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/footer.js" charset="UTF-8"></script>

</head>
<script type="text/javascript">
	$(function() {
		$('#tt').tree({
			onClick : function(node) {
				if($.trim(node.apiurl)==""||$.trim(node.apiurl)=="undefined"||$.trim(node.apiurl)==null){
					
				}else{
					var url = "${request_path}/OpenApi_queryApiDetail?id="+node.id;
					open1(node.text,url); // alert node text property when clicked
				}
			}
		});
	});
	
	function open1(name,url) {
		if ($('#right_tab').tabs('exists', name)) {
			$('#right_tab').tabs('select', name);
		} else {
			$('#right_tab').tabs('add', {
				title : name,
				href : url,
				closable : true
				
			});
		}
	}
</script>
<body  >
	<div class="easyui-layout" style="width: auto; height: 790px;" >
		<div data-options="region:'north'" style="height: 80px;background: url(${image_path}/body_bg.png) repeat-x scroll center 0 rgba(0, 0, 0, 0);">
			<font style="font-size: 30px; line-height: 75px; font-style: italic;">sch_OPen_API开发指南</font>
			<div style="float: right;margin-bottom: 5px;margin-top: 50px;">

			<c:if test="${!empty(user)}">
				欢迎您：<c:out value="${user.username}" />
				<a href="Login_logout">[退出]</a>
				&nbsp;|&nbsp;
			</c:if>
			<a href="#" onclick="open1('应用管理','OpenApp_index')">应用管理</a> &nbsp;|&nbsp;
			<a href="${request_path}" target="_blank">网站前台</a> &nbsp;
		</div>
		</div>
		<div data-options="region:'west',split:true" title="Open_API" style="width: auto;max-width:177px; ">
			<div class="easyui-accordion" data-options="fit:true,border:false" >
				<ul id="tt" class="easyui-tree"
					data-options="url:'${request_path}/OpenApi_query',method:'get',animate:true,dnd:true">
				</ul>
			</div>
		</div>
		<div data-options="region:'center',title:'API说明',iconCls:'icon-ok'"  style="width: auto;">
			<div id="right_tab" class="easyui-tabs"
				data-options="fit:true,border:false,plain:true">
				<div title="关于"
					data-options="href:'${request_path}/openapi/about.jsp'"
					style="padding: 10px"></div>
			
			</div>
		</div>
	</div>
	
</body>
<div id="bottom"><jsp:include page="../bottom.jsp"></jsp:include></div>
</html>