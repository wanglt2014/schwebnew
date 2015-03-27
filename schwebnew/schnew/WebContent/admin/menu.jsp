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
<title>${sitename}--后台管理系统</title>
</head>
<body>
	<div style="margin: 10px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="edit()">Edit</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="save()">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="cancel()">Cancel</a>
	</div>
	<table title="菜单管理" class="easyui-treegrid" id="menutg"
		data-options="url: '${request_path}/Menu_query',method: 'get',rownumbers: true,idField: 'id', fit:true,treeField: 'text',iconCls: 'icon-ok',animate: true, fitColumns: true,onContextMenu: onContextMenu">
		<thead>
			<tr>
				<th data-options="field:'text', editor:'text'" width="220">名字</th>
				<th data-options="field:'menuurl',editor:'text'" width="100"
					align="right">动作</th>
				<th data-options="field:'menuorder',editor:'numberbox'" width="150">层级排序</th>
				<th data-options="field:'menulevel',editor:'numberbox'" width="150">菜单级别</th>
				<th data-options="field:'id',editor:'numberbox'" width="150">菜单id</th>
				<th data-options="field:'menuparent',editor:'numberbox'" width="150">父级菜单id</th>
			</tr>
		</thead>
	</table>
	<div id="menumm" class="easyui-menu" style="width: 120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
		<div onclick="removeIt()" data-options="iconCls:'icon-remove'">删除</div>
		<div class="menu-sep"></div>
		<div onclick="collapse()">收缩</div>
		<div onclick="expand()">展开</div>
	</div>
</body>
</html>