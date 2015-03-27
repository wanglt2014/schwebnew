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
<title>${sitename}--后台管理系统--数据字典</title>
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
<!-- 		<div> -->
<!-- 			分类名称:<input type="text" id="productcategoryNamequery"> 供应商:<input -->
<!-- 				class="easyui-combobox" id="supplierCodequery" -->
<!-- 				data-options=" -->
<!-- 					url:'Productcategory_querySupplierCode', -->
<!-- 					method:'get', -->
<!-- 					valueField:'supplierCode', -->
<!-- 					textField:'supplierName', -->
<!-- 					panelHeight:'auto'"> -->
<!-- 			<a href="javascript:void(0)" class="easyui-linkbutton" -->
<!-- 				iconCls="icon-search" onclick="queryProductcategory()">搜索</a> -->
<!-- 		</div> -->
	</div>
	<table id="productcategorydg" title="列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Dictionary_query"
		toolbar="#productcategorytoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="dictionarycode" width="50">编码</th>
				<th field="dictionaryvalue" width="50">值</th>
				<th field="dictionarytype" width="50">分类</th>
				<th field="dictionaryremark" width="50">备注</th>
			</tr>
		</thead>
	</table>
	<div id="productcategorytoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newDictionary()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editDictionary()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyDictionary()">删除</a>
	</div>

	<div id="dictionarydlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dictionarydlg-buttons">
		<div class="ftitle">字典信息</div>
		<form id="dictionaryfm" method="post" novalidate>
			<div class="fitem">
				<label>编码:</label> <input name="dictionarycode"
					class="easyui-validatebox" required="true" maxlength="20">
			</div>
			<div class="fitem">
				<label>值</label> <input name="dictionaryvalue"
					class="easyui-validatebox" required="true" maxlength="20">
			</div>
			<div class="fitem">
				<label>分类:</label> <input name="dictionarytype"
					class="easyui-validatebox" required="true" maxlength="20">
			</div>
			<div class="fitem">
				<label>备注:</label>
				 <input name="dictionaryremark"
					class="easyui-validatebox" required="true" maxlength="50">
			</div>

		</form>
	</div>
	<div id="dictionarydlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveDictionary()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dictionarydlg').dialog('close')">取消</a>
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
		function newDictionary() {
			$('#dictionarydlg').dialog('open').dialog('setTitle', '新增分类');
			$('#dictionaryfm').form('clear');
			url = 'Dictionary_save';
		}
		function editDictionary() {
			var row = $('#productcategorydg').datagrid('getSelected');
			if (row) {
				$('#dictionarydlg').dialog('open').dialog('setTitle',
						'编辑分类');
				$('#dictionaryfm').form('clear');
				$('#dictionaryfm').form('load', row);
				url = 'Dictionary_update?id=' + row.dictionaryid;
			}
		}
		function saveDictionary() {
			$('#dictionaryfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#dictionarydlg').dialog('close'); // close the dialog
						$('#productcategorydg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyDictionary() {
			var row = $('#productcategorydg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个分类吗?', function(r) {
					if (r) {
						$.post('Dictionary_delete', {
							id : row.dictionaryid
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
#dictionaryfm {
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