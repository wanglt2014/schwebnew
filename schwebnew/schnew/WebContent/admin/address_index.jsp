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
<title>${sitename}--后台管理系统--地址管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="addresstb" style="padding: 5px; height: auto">
		<div>
			 用户ID:<select class="easyui-combogrid" name="userIdaddressquery" id="userIdaddressquery"
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
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryAddress()">搜索</a>
		</div>
	</div>
	<table id="addressdg" title="地址管理" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Address_query"
		toolbar="#addresstoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="consignee" width="50">收货人姓名</th>
				<th field="telephone" width="50">手机号</th>
				<th field="postcode" width="50">邮政编码</th>
				<th field="addressHead" width="150">收货人地址</th>
				<th field="addressDetail" width="150">收货人门牌号</th>
				<th field="id" width="80">地址ID</th>
				<th field="userid" width="80">用户ID</th>
			</tr>
		</thead>
	</table>
	<div id="addresstoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newAddress()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editAddress()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyAddress()">删除</a>
	</div>

	<div id="addressdlg" class="easyui-dialog"
		style="width: 400px; height: 360px; padding: 10px 20px" closed="true"
		buttons="#addressdlg-buttons">
		<div class="ftitle">会员服务信息</div>
		<form id="addressfm" method="post" novalidate>
			<div class="fitem">
				<label>用户id:</label>
				 <select class="easyui-combogrid" name="userid"
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
        " required="true"></select>
			</div>
			
			<div class="fitem">
                <label>收货人姓名:</label>
                <input name="consignee" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>手机号:</label>
               <input name="telephone" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>邮政编码:</label>
                <input name="postcode" class="easyui-validatebox" required="true"/>
            </div>
			<div class="fitem">
				<label>收货人地址:</label> 
				<input name="addressHead" type="text" class="easyui-validatebox"/>
			</div>
			<div class="fitem">
				<label>门牌号:</label> 
				<input name="addressDetail" type="text" class="easyui-validatebox"/>
			</div>
		</form>
	</div>
	<div id="addressdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveAddress()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#addressdlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;

		function queryAddress() {
			var g =$('#userIdaddressquery').combogrid('grid');
			var r = g.datagrid('getSelected');
			var userIdquery = "";
			if(null!=r){
				userIdquery=r.userid;
			}
			$('#addressdg').datagrid('load', {
				userIdquery : userIdquery
			});
		}
		function newAddress() {
			$('#addressdlg').dialog('open').dialog('setTitle', '新增地址');
			$('#addressfm').form('clear');
			url = 'Address_save';
		}
		function editAddress() {
			var row = $('#addressdg').datagrid('getSelected');
			if (row) {
				$('#addressdlg').dialog('open').dialog('setTitle', '编辑地址');
				$('#addressfm').form('clear');
				$('#addressfm').form('load', row);
				url = 'Address_update?id=' + row.id;
			}
		}
		function saveAddress() {
			$('#addressfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#addressdlg').dialog('close'); // close the dialog
						$('#addressdg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyAddress() {
			var row = $('#addressdg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个地址吗?', function(r) {
					if (r) {
						$.post('Address_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#addressdg').datagrid('reload'); // reload the user data
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
#addressfm {
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