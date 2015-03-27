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
	<table id="openappdg" title="你的应用列表" class="easyui-datagrid"
		style="width: auto; height: 650px" url="OpenApp_queryApp"
		toolbar="#openapptoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="appname" width="50">应用名字</th>
				<th field="appurl" width="100">应用网址</th>
				<th field="appdesc" width="50">应用描述</th>
				<th field="appreturnurl" width="150">回调地址</th>
				<th field="appsecret" width="150">应用密钥</th>
				<th field="id" width="50">应用id</th>
				<th field="accesscount" width="50">调用限额</th>
				<th field="isactive" width="70" formatter="formatterIsactive">是否激活</th>
			</tr>
		</thead>
	</table>
	<div id="openapptoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newOpenApp()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editOpenApp()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyOpenApp()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cut" plain="true" onclick="resetSecret()">重置密钥</a>
	</div>

	<div id="openappdlg" class="easyui-dialog"
		style="width: 400px; height: 380px; padding: 10px 20px" closed="true"
		buttons="#openappdlg-buttons">
		<div class="ftitle">应用信息</div>
		<form id="openappfm" method="post" novalidate>
			<div class="fitem">
				<label>应用名字:</label> <input name="appname"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>应用URL</label> <input name="appurl" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>应用描述:</label> <input name="appdesc"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>应用密钥:</label> <input name="appsecret"
					class="easyui-validatebox">
			</div>
			<div class="fitem" >
				<label>是否激活:</label> <select id="isactive" name="isactive" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
			</div>
			<div class="fitem">
				<label>回调地址:</label> <input name="appreturnurl"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>应用调用限额:</label> <input name="accesscount"
					class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>用户id:</label><select class="easyui-combogrid" name="userid" id="userid"
					style="width: 150px"
					data-options="
            panelWidth: 550,
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

		</form>
	</div>
	<div id="openappdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveOpenApp()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#openappdlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;
		function newOpenApp() {
			$('#openappdlg').dialog('open').dialog('setTitle', '新增应用');
			$('#openappfm').form('clear');
			url = 'OpenApp_save';
		}
		function editOpenApp() {
			var row = $('#openappdg').datagrid('getSelected');
			if (row) {
				$('#openappdlg').dialog('open').dialog('setTitle', '编辑应用');
				$('#openappfm').form('clear');
				$('#openappfm').form('load', row);
				url = 'OpenApp_editApp?id=' + row.id;
			}
		}
		function resetSecret() {
			var row = $('#openappdg').datagrid('getSelected');
			if (row) {
				$('#openappfm').form('clear');
				$('#openappfm').form('load', row);
				url = 'OpenApp_resetSecret?id=' + row.id;
				saveOpenApp();
			}
		}
		function saveOpenApp() {
			$('#openappfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#openappdlg').dialog('close'); // close the dialog
						$('#openappdg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyOpenApp() {
			var row = $('#openappdg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个应用吗?', function(r) {
					if (r) {
						$.post('OpenApp_deleteApp', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#openappdg').datagrid('reload'); // reload the user data
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