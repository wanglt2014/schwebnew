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
<title>${sitename}--后台管理系统--会员服务管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="userservicetb" style="padding: 5px; height: auto">
		<div>
			会员卡号:<input type="text" id="userserviceiccardquery"> 
			 用户ID:<select class="easyui-combogrid" name="userIdquery" id="userIdquery"
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
				iconCls="icon-search" onclick="queryUserService()">搜索</a>
		</div>
	</div>
	<table id="userservicedg" title="会员服务" class="easyui-datagrid"
		style="width: auto; height: 616px" url="UserService_query"
		toolbar="#userservicetoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="userId" width="50">用户ID</th>
				<th field="productName" width="50">产品名字</th>
				<th field="productPrice" width="50">产品价格</th>
				<th field="productCode" width="50">产品代码</th>
				<th field="orderIccard" width="50">会员卡号</th>
				<th field="serviceEndTime" width="50" formatter="formatterdate">服务结束时间</th>
			</tr>
		</thead>
	</table>
	<div id="userservicetoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newUserService()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUserService()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyUserService()">删除</a>
	</div>

	<div id="userservicedlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#userservicedlg-buttons">
		<div class="ftitle">会员服务信息</div>
		<form id="userservicefm" method="post" novalidate>
			<div class="fitem">
				<label>用户id:</label>
				 <select class="easyui-combogrid" name="userId"
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
			<div class="fitem">
				<label>产品名称:</label>
			 <select class="easyui-combogrid"
					name="productCode" style="width: 150px"
					data-options="
            panelWidth: 500,
            idField: 'productCode',
            textField: 'productName',
            url: 'Product_query',
             pageSize: 10,//每页显示的记录条数，默认为10  
             pageList: [10],//可以设置每页记录条数的列表 
              pagination : true,//是否分页  
               rownumbers:true,//序号  
            method: 'get',
            columns: [[
                {field:'productName',title:'产品名称',width:120},
                {field:'productPrice',title:'产品价格',width:80,align:'right'},
                {field:'productCode',title:'产品代码',width:80,align:'right'}
            ]],
            fitColumns: true
        ">
				</select>
			</div>
			<div class="fitem">
				<label>服务结束日期:</label> <input name="serviceEndTime" type="text"
					class="easyui-datebox" id="serviceEndTime" required="true" />
			</div>


		</form>
	</div>
	<div id="userservicedlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveUserService()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#userservicedlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;

		function queryUserService() {
			var userserviceiccardquery = $('#userserviceiccardquery').val();
			var g =$('#userIdquery').combogrid('grid');
			var r = g.datagrid('getSelected');
			var userIdquery = "";
			if(null!=r){
				userIdquery=r.userid;
			}
			$('#userservicedg').datagrid('load', {
				userserviceiccardquery : userserviceiccardquery,
				userIdquery:userIdquery
			});
		}
		function newUserService() {
			$('#userservicedlg').dialog('open').dialog('setTitle', '新增服务');
			$('#userservicefm').form('clear');
			url = 'UserService_save';
		}
		function editUserService() {
			var row = $('#userservicedg').datagrid('getSelected');
			if (row) {
				$('#userservicedlg').dialog('open').dialog('setTitle', '编辑服务');
				$('#userservicefm').form('clear');
				$('#userservicefm').form('load', row);
				$('#serviceEndTime').datebox('setValue',
						timeStamp2String(row.serviceEndTime));
				url = 'UserService_update?id=' + row.id;
			}
		}
		function saveUserService() {
			$('#userservicefm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#userservicedlg').dialog('close'); // close the dialog
						$('#userservicedg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyUserService() {
			var row = $('#userservicedg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个服务吗?', function(r) {
					if (r) {
						$.post('UserService_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#userservicedg').datagrid('reload'); // reload the user data
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
#userservicefm {
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