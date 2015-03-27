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
<title>${sitename}--后台管理系统--产品分类管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="productcategorytb" style="padding: 5px; height: auto">
		<div>
			分类名称:<input type="text" id="productcategoryNamequery"> 供应商:<input
				class="easyui-combobox" id="supplierCodequery"
				data-options="
					url:'Productcategory_querySupplierCode',
					method:'get',
					valueField:'supplierCode',
					textField:'supplierName',
					panelHeight:'auto'">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryProductcategory()">搜索</a>
		</div>
	</div>
	<table id="productcategorydg" title="供应商列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Productcategory_query"
		toolbar="#productcategorytoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="productcategoryCode" width="50">分类代码</th>
				<th field="productcategoryName" width="50">分类名字</th>
				<th field="productcategoryRemark" width="50">分类信息</th>
				<th field="supplierCode" width="50" formatter="formatcode">供应商代码</th>
			</tr>
		</thead>
	</table>
	<div id="productcategorytoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newProductcategory()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editProductcategory()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyProductcategory()">删除</a>
	</div>

	<div id="productcategorydlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#productcategorydlg-buttons">
		<div class="ftitle">供应商信息</div>
		<form id="productcategoryfm" method="post" novalidate>
			<div class="fitem">
				<label>分类代码:</label> <input name="productcategoryCode"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>分类名字</label> <input name="productcategoryName"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>分类信息:</label> <input name="productcategoryRemark"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>供应商代码:</label>
				<input
				class="easyui-combobox" id="supplierCode" name ="supplierCode" required="true"
				data-options="
					url:'Productcategory_querySupplierCode',
					method:'get',
					valueField:'supplierCode',
					textField:'supplierName',
					panelHeight:'auto'">
			</div>

		</form>
	</div>
	<div id="productcategorydlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveProductcategory()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#productcategorydlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;
		
		function queryProductcategory() {
			var productcategoryNamequery = $('#productcategoryNamequery').val();
			var supplierCodequery = $('#supplierCodequery').combobox('getValue');
			$('#productcategorydg').datagrid('load', {
				productcategoryNamequery : productcategoryNamequery,
				supplierCodequery : supplierCodequery
			});
		}
		function newProductcategory() {
			$('#productcategorydlg').dialog('open').dialog('setTitle', '新增分类');
			$('#productcategoryfm').form('clear');
			url = 'Productcategory_save';
		}
		function editProductcategory() {
			var row = $('#productcategorydg').datagrid('getSelected');
			if (row) {
				$('#productcategorydlg').dialog('open').dialog('setTitle',
						'编辑分类');
				$('#productcategoryfm').form('clear');
				$('#productcategoryfm').form('load', row);
				url = 'Productcategory_update?id=' + row.id;
			}
		}
		function saveProductcategory() {
			$('#productcategoryfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#productcategorydlg').dialog('close'); // close the dialog
						$('#productcategorydg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyProductcategory() {
			var row = $('#productcategorydg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个分类吗?', function(r) {
					if (r) {
						$.post('Productcategory_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#productcategorydg').datagrid('reload'); // reload the user data
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
#productcategoryfm {
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