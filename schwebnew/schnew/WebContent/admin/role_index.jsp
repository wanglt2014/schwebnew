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
<title>${sitename}--后台管理系统--产品角色管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="roletb" style="padding: 5px; height: auto">
		<div>
			角色名字:<input type="text" id="roleNamequery"> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryRole()">搜索</a>
		</div>
	</div>
	<table id="roledg" title="角色列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Role_query"
		toolbar="#roletoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="name" width="50">角色名字</th>
				<th field="isactive" width="70" formatter="formatterIsactive">是否激活</th>
				
			</tr>
		</thead>
	</table>
	<div id="roletoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newRole()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editRole()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyRole()">删除</a>
	</div>

	<div id="roledlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#roledlg-buttons">
		<div class="ftitle">角色信息</div>
		<form id="rolefm" method="post" novalidate>
		
			<div class="fitem">
				<label>名字</label> <input name="name" class="easyui-validatebox" maxlength="20"
					required="true">
			</div>
			<div class="fitem">
				<label>是否激活:</label> <select id="isactive" name ="isactive" class="easyui-combobox" panelHeight="auto" editable="false"
					style="width: 100px">
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
			</div>
			<div class="fitem">
				<label>菜单:</label><input name="menuid" id="menuid" class="easyui-validatebox" style="display: none;">
				 <select class="easyui-combogrid" id="resourcecombox" name="resourcecombox" style="width:150px" data-options="
            panelWidth: 500,
            multiple: true,
            singleSelect:false, 
            idField: 'id',
            textField: 'text',
            url: 'Menu_queryForRole',
            method: 'get',
              pageSize: 10,//每页显示的记录条数，默认为10  
             pageList: [10,20],//可以设置每页记录条数的列表 
              pagination : false,//是否分页  
               rownumbers:true,//序号  
            columns: [[
                {field:'ck',checkbox:true},
                {field:'text',title:'菜单名称',width:80,align:'center'},
                {field:'menuurl',title:'菜单URL',width:120},
                {field:'menulevel',title:'菜单级别',width:80,align:'center'},
            ]],
            fitColumns: true
        ">
    </select>
			</div>
			
			
		</form>
	</div>
	<div id="roledlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveRole()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#roledlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;

		function queryRole() {
			var roleNamequery = $('#roleNamequery').val();
			$('#roledg').datagrid('load', {
				roleNamequery : roleNamequery
			});
		}
		function newRole() {
			$('#roledlg').dialog('open').dialog('setTitle', '新增角色');
			$('#rolefm').form('clear');
			url = 'Role_save';
		}
		function editRole() {
			var row = $('#roledg').datagrid('getSelected');
			if (row) {
				$('#roledlg').dialog('open').dialog('setTitle', '编辑角色');
				$('#rolefm').form('clear');
				$('#rolefm').form('load', row);
				url = 'Role_update?id=' + row.id;
				$.ajax({
					type : 'post',
					url : 'Role_queryTRoleMenuByroleid',
					data : {
						roleid :  row.id,
					},
					success : function(data) {
						$('#resourcecombox').combogrid('setValues', data.split(","));
					},
					error : function() {
						jAlert('系统错误，请联系管理员','错误提示');
					}
				});
				
				
			}
		}
		function saveRole() {
			$('#menuid').val($('#resourcecombox').combogrid('getValues'));
			$('#rolefm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#roledlg').dialog('close'); // close the dialog
						$('#roledg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyRole() {
			var row = $('#roledg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个角色吗?', function(r) {
					if (r) {
						$.post('Role_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#roledg').datagrid('reload'); // reload the user data
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
#rolefm {
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