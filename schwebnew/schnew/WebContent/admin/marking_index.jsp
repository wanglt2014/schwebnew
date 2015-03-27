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
<title>${sitename}--后台管理系统--市场合作管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<div id="markingtb" style="padding: 5px; height: auto">
		<div>
			联系人名字:<input type="text" id="markingNamequery"> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryMarking()">搜索</a>
		</div>
	</div>
	<table id="markingdg" title="商务合作列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Marking_query"
		toolbar="#markingtoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="province" width="30">省份</th>
				<th field="saleName" width="50">名字</th>
				<th field="saleQq" width="50">QQ</th>
				<th field="salePhone" width="50">电话</th>
				<th field="saleEmail" width="70">邮箱</th>
				<th field="areaname" width="50">负责区域</th>
				<th field="remark" width="100">备注</th>
				<th field="classstyle" width="50">类型</th>
				<th field="href" width="100">URL</th>
			</tr>
		</thead>
	</table>
	<div id="markingtoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newMarking()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editMarking()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyMarking()">删除</a>
	</div>

	<div id="markingdlg" class="easyui-dialog"
		style="width: 400px; height: 380px; padding: 10px 20px" closed="true"
		buttons="#markingdlg-buttons">
		<div class="ftitle">商务合作信息</div>
		<form id="markingfm" method="post" novalidate>
			<div class="fitem">
				<label>省份:</label> <select id="province" name="province" class="easyui-combobox"
					panelHeight="auto" style="width: 100px">
					<option value="宁夏">宁夏</option>
					<option value="重庆">重庆</option>
					<option value="河南">河南</option>
					<option value="湖北">湖北</option>
					<option value="湖南">湖南</option>
					<option value="澳门">澳门</option>
					<option value="香港">香港</option>
					<option value="海南">海南</option>
					<option value="广东">广东</option>
					<option value="福建">福建</option>
					<option value="江西">江西</option>
					<option value="浙江">浙江</option>
					<option value="安徽">安徽</option>
					<option value="上海">上海</option>
					<option value="江苏">江苏</option>
					<option value="山东">山东</option>
					<option value="河北">河北</option>
					<option value="天津">天津</option>
					<option value="北京">北京</option>
					<option value="辽宁">辽宁</option>
					<option value="吉林">吉林</option>
					<option value="新疆">新疆</option>
					<option value="甘肃">甘肃</option>
					<option value="青海">青海</option>
					<option value="西藏">西藏</option>
					<option value="四川">四川</option>
					<option value="云南">云南</option>
					<option value="贵州">贵州</option>
					<option value="广西">广西</option>
					<option value="内蒙古">内蒙古</option>
					<option value="陕西">陕西</option>
					<option value="山西">山西</option>
					<option value="台湾">台湾</option>
					<option value="黑龙江">黑龙江</option>
				</select>
			</div>
			<div class="fitem">
				<label>名字</label> <input name="saleName" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>QQ:</label> <input name="saleQq" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>邮箱:</label> <input name="saleEmail"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>电话:</label> <input name="salePhone"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>负责区域:</label> <input name="areaname"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>备注:</label> <input name="remark" class="easyui-validatebox"
					required="true" size="30">
			</div>
			<div class="fitem">
				<label>类型:</label> <input name="classstyle"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>URL:</label> <input name="href" class="easyui-validatebox"
					size="30">
			</div>
		</form>
	</div>
	<div id="markingdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveMarking()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#markingdlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;

		function queryMarking() {
			var markingNamequery = $('#markingNamequery').val();
			$('#markingdg').datagrid('load', {
				markingNamequery : markingNamequery
			});
		}
		function newMarking() {
			$('#markingdlg').dialog('open').dialog('setTitle', '新增分类');
			$('#markingfm').form('clear');
			url = 'Marking_save';
		}
		function editMarking() {
			var row = $('#markingdg').datagrid('getSelected');
			if (row) {
				$('#markingdlg').dialog('open').dialog('setTitle', '编辑分类');
				$('#markingfm').form('clear');
				$('#markingfm').form('load', row);
				url = 'Marking_update?id=' + row.id;
			}
		}
		function saveMarking() {
			$('#markingfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#markingdlg').dialog('close'); // close the dialog
						$('#markingdg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyMarking() {
			var row = $('#markingdg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个分类吗?', function(r) {
					if (r) {
						$.post('Marking_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#markingdg').datagrid('reload'); // reload the user data
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
#markingfm {
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