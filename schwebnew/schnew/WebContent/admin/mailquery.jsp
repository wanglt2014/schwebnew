<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>${sitename}--后台管理系统---邮件查询</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body >
   		<div id="maildlg" ></div>
		<div id="mailtb" style="padding: 5px; height: auto">
			<div>
				起始日期: <input id="startdataemail" class="easyui-datebox" style="width: 80px">
				结束日期: <input id="enddataemail" class="easyui-datebox" style="width: 80px">
				是否激活: <select id="emailisactive" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="all">全部</option>
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
				邮件接受者:<input type="text"  id="mailto">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryeamil()">搜索</a>
			</div>
		</div>
		<table class="easyui-datagrid" title="邮件查询" id="emaildatagrid" style="width:auto;height:616px"
			data-options="url:'${request_path}/Email_query',method:'get',pagination:true,singleSelect:true,fitColumns:true,rownumbers: true"  pageSize="20" >
			<thead>
				<tr>
					<th data-options="field:'mailcontent'" width="100" formatter="formatMenuid">邮件内容</th>
					<th data-options="field:'mailto',align:'right'" width="80" >邮件接收者</th>
					<th data-options="field:'createtime',align:'right'" width="80" formatter="formatterdate">发送时间</th>
					<th data-options="field:'code'" width="150">激活码</th>
					<th data-options="field:'isactive',align:'center'" width="50" formatter="formatterIsactive">是/否激活</th>
				</tr>
			</thead>
		</table>
</body>
</html>