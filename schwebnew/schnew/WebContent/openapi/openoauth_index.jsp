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
	<div id="openoauthtb" style="padding: 5px; height: auto">
		<div>
		 应用ID:<select
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
				iconCls="icon-search" onclick="queryOpenOauth()">搜索</a>
		</div>
	</div>
	<table id="openoauthdg" title="授权列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="OpenOauth_query"
		 toolbar="#openoauthtoolbar"  pagination="true" rownumbers="true" fitColumns="true"
		singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="appid" width="50">应用ID</th>
				<th field="code" width="200">请求的code</th>
				<th field="accessToken" width="200">访问的token</th>
				<th field="userid" width="100">用户id</th>
				<th field="accessAuth" width="100">访问权限</th>
				<th field="tokenExpires" width="100">失效时间(秒)</th>
				<th field="codeIsactive" width="100" formatter="formatterIsactive">code是否使用</th>
				<th field="tokenIsactive" width="100" formatter="formatterIsactive">token是否有效e</th>
				<th field="uptime" width="100" formatter="formatterdate">更新时间</th>
			</tr>
		</thead>
	</table>
	<div id="openoauthtoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newOpenOauth()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editOpenOauth()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyOpenOauth()">删除</a>
	</div>

	<div id="openoauthdlg" class="easyui-dialog"
		style="width: 430px; height: 380px; padding: 10px 20px" closed="true"
		buttons="#openoauthdlg-buttons">
		<div class="ftitle">应用信息</div>
		<form id="openoauthfm" method="post" novalidate>
			<div class="fitem">
				<label>应用id:</label> <select
				class="easyui-combogrid" name="appid" id="appid"
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
			</div>
			<div class="fitem">
				<label>CODE</label> <input name="code" class="easyui-validatebox"
					required="true" size="35">
			</div>
			<div class="fitem">
				<label>访问token</label> <input name="accessToken"
					class="easyui-validatebox" required="true" size="35">
			</div>
			<div class="fitem" >
				<label>用户id</label> <select class="easyui-combogrid" name="userid" id="userid"
					style="width: 150px"
					data-options="
            panelWidth: 500,
            idField: 'userid',
            textField: 'userid',
            url: 'User_query',
            method: 'get',
             pageSize: 10,//每页显示的记录条数，默认为10  
             pageList: [10],//可以设置每页记录条数的列表 
              pagination : true,//是否分页  
               rownumbers:true,//序号  
            columns: [[
                {field:'userid',title:'用户ID',width:120},
                {field:'iccard',title:'会员卡号',width:80,align:'right'},
                {field:'username',title:'用户姓名',width:80,align:'right'}
            ]],
            fitColumns: true
        "></select>
			</div>
			<div class="fitem" >
				<label>访问权限</label> <input name="accessAuth"
					class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>失效时间</label> <input name="tokenExpires"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem" >
				<label>code是否有效</label>   <select name="codeIsactive" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
			</div>
			<div class="fitem" >
				<label>token是否有效</label>  <select name="tokenIsactive" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
			</div>
			<div class="fitem" >
				<label>更新时间</label> <input name="uptime" type="text" class="easyui-datebox" id="uptime" required="true" />
			</div>
		</form>
	</div>
	<div id="openoauthdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveOpenOauth()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#openoauthdlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		function queryOpenOauth() {
			var g = $('#appidquery').combogrid('grid');
			var r = g.datagrid('getSelected');
			var appid = "";
			if (null != r) {
				appid = r.id;
			}
			$('#openoauthdg').datagrid('load', {
				appid : appid
			});
		}
		var url;
		function newOpenOauth() {
			$('#openoauthdlg').dialog('open').dialog('setTitle', '新增应用');
			$('#openoauthfm').form('clear');
			url = 'OpenOauth_save';
		}
		function editOpenOauth() {
			var row = $('#openoauthdg').datagrid('getSelected');
			if (row) {
				$('#openoauthdlg').dialog('open').dialog('setTitle', '编辑应用');
				$('#openoauthfm').form('clear');
				$('#openoauthfm').form('load', row);
				 $('#uptime').datebox('setValue', timeStamp2String(row.uptime));
				url = 'OpenOauth_edit?id=' + row.id;
			}
		}
		function saveOpenOauth() {
			$('#openoauthfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#openoauthdlg').dialog('close'); // close the dialog
						$('#openoauthdg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyOpenOauth() {
			var row = $('#openoauthdg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个应用吗?', function(r) {
					if (r) {
						$.post('OpenOauth_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#openoauthdg').datagrid('reload'); // reload the user data
							} else {
								jAlert('系统错误，请联系管理员', '错误提示');
							}
						}, 'json');
					}
				});
			}
		}
	</script>
	<style type="text/css">
#openoauthfm {
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