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
<meta charset="UTF-8">
<title>${sitename}--OPenAPI</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="openlogtb" style="padding: 5px; height: auto">
		<div>
			创建起始日期: <input id="startdatalog" class="easyui-datetimebox"
				style="width: 150px"> 创建结束日期: <input id="enddatalog"
				class="easyui-datetimebox" style="width: 150px"> 应用ID:<select
				class="easyui-combogrid" name="appidquery" id="appidquery"
				style="width: 150px"
				data-options="
            panelWidth: 500,
            idField: 'id',
            textField: 'appname',
            url: 'OpenApp_queryApp',
            method: 'get',
             pageSize: 10,//每页显示的记录条数，默认为10  
             pageList: [10],//可以设置每页记录条数的列表 
              pagination : true,//是否分页  
               rownumbers:true,//序号  
            columns: [[
                {field:'id',title:'应用ID',width:120},
                {field:'appname',title:'应用名字',width:80,align:'right'},
                {field:'appurl',title:'应用url',width:80,align:'right'}
            ]],
            fitColumns: true
        "></select>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryAppLog()">搜索</a>
		</div>
	</div>
	<table id="openappdg" title="日志列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="OpenLog_query"
		pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="appid" width="50">应用ID</th>
				<th field="apiurl" width="100">访问地址</th>
				<th field="accesstime" width="150" formatter="formatterdate">访问时间</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		function queryAppLog() {
			var startdate = $('#startdatalog').datebox('getValue');
			var enddate = $('#enddatalog').datebox('getValue');
			var g = $('#appidquery').combogrid('grid');
			var r = g.datagrid('getSelected');
			var appid = "";
			if (null != r) {
				appid = r.id;
			}
			$('#openappdg').datagrid('load', {
				startdate : startdate,
				enddate : enddate,
				appid : appid
			});
		}
	</script>
	<style type="text/css">
#openappfm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
</body>
</html>