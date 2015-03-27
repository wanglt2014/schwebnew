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
	<div id="ordertb" style="padding: 5px; height: auto">
		<div>
			会员卡号:<input type="text" id="ordericcardorderquery"> 
			 用户ID:<select class="easyui-combogrid" name="userIdorderquery" id="userIdorderquery"
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
				iconCls="icon-search" onclick="queryOrder()">搜索</a>
		</div>
	</div>
	<table id="orderdg" title="会员服务" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Order_query"
		toolbar="#ordertoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="userId" width="70">用户ID</th>
				<th field="addressId" width="50">地址ID</th>
				<th field="productId" width="50">产品ID</th>
				<th field="productNumber" width="50">产品数量</th>
				<th field="orderTotalPrice" width="50">订单总价</th>
				<th field="orderCreateTime" width="50" formatter="formatterdate">订单创建时间</th>
				<th field="orderStatus" width="50" formatter="formatorderstatus">订单状态</th>
				<th field="orderId" width="80">订单ID</th>
				<th field="payTradeNo" width="80">支付交易ID</th>
				<th field="orderUpdateTime" width="50" formatter="formatterdate">订单更新时间</th>
				
				
			</tr>
		</thead>
	</table>
	<div id="ordertoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newOrder()">新增</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editOrder()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyOrder()">删除</a>
	</div>

	<div id="orderdlg" class="easyui-dialog"
		style="width: 400px; height: 430px; padding: 10px 20px" closed="true"
		buttons="#orderdlg-buttons">
		<div class="ftitle">会员服务信息</div>
		<form id="orderfm" method="post" novalidate>
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
        " required="true"></select>
			</div>
			<div class="fitem">
				<label>产品名称:</label>
			 <select class="easyui-combogrid"
					name="productId" style="width: 150px"
					data-options="
            panelWidth: 500,
            idField: 'id',
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
        " required="true">
				</select>
			</div>
			<div class="fitem">
                <label>产品订购数量:</label>
                <input name="productNumber" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>产品状态:</label>
                <select id="orderStatus" name="orderStatus" class="easyui-combobox" panelHeight="auto" required="true"
					style="width: 100px">
					<option value="1">订单创建</option>
					<option value="2">支付完成</option>
					<option value="3">订单撤销</option>
					<option value="4">订单已发货</option>
					<option value="4">订单完成</option>
				</select>
            </div>
            <div class="fitem">
                <label>产品总价:</label>
                <input name="orderTotalPrice" class="easyui-validatebox" required="true"/>
            </div>
             <div class="fitem">
                <input name="orderId" class="easyui-validatebox"  style="display: none;" />
            </div>
			<div class="fitem">
				<label>订单创建时间:</label> <input name="orderCreateTime" type="text"
					class="easyui-datebox" id="orderCreateTime" required="true" />
			</div>
			<div class="fitem">
				<label>订单更新时间:</label> <input name="orderUpdateTime" type="text"
					class="easyui-datebox" id="orderUpdateTime" />
			</div>
			<div class="fitem">
				<label>收货地址:</label> 
				 <select class="easyui-combogrid"
					name="addressId" style="width: 150px"
					data-options="
            panelWidth: 500,
            idField: 'id',
            textField: 'addressHead',
            url: 'Address_query',
             pageSize: 10,//每页显示的记录条数，默认为10  
             pageList: [10],//可以设置每页记录条数的列表 
              pagination : true,//是否分页  
               rownumbers:true,//序号  
            method: 'get',
            columns: [[
                {field:'addressHead',title:'所在地区',width:120},
                {field:'addressDetail',title:'详细地址',width:80,align:'right'},
                {field:'consignee',title:'收货人',width:80,align:'right'}
            ]],
            fitColumns: true
        " required="true">
				</select>
			</div>
		</form>
	</div>
	<div id="orderdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveOrder()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#orderdlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		var url;

		function queryOrder() {
			var ordericcardorderquery = $('#ordericcardorderquery').val();
			var g =$('#userIdorderquery').combogrid('grid');
			var r = g.datagrid('getSelected');
			var userIdquery = "";
			if(null!=r){
				userIdquery=r.userid;
			}
			$('#orderdg').datagrid('load', {
				orderid : ordericcardorderquery,
				userIdquery : userIdquery
			});
		}
		function newOrder() {
			$('#orderdlg').dialog('open').dialog('setTitle', '新增服务');
			$('#orderfm').form('clear');
			url = 'Order_save';
		}
		function editOrder() {
			var row = $('#orderdg').datagrid('getSelected');
			if (row) {
				$('#orderdlg').dialog('open').dialog('setTitle', '编辑服务');
				$('#orderfm').form('clear');
				$('#orderfm').form('load', row);
				 $('#orderCreateTime').datebox('setValue', timeStamp2String(row.orderCreateTime));
				 $('#orderUpdateTime').datebox('setValue', timeStamp2String(row.orderUpdateTime));
				url = 'Order_update?id=' + row.id;
			}
		}
		function saveOrder() {
			$('#orderfm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					if (result != "true") {
						jAlert('系统错误，请联系管理员', '错误提示');
					} else {
						$('#orderdlg').dialog('close'); // close the dialog
						$('#orderdg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyOrder() {
			var row = $('#orderdg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你想要删除这个服务吗?', function(r) {
					if (r) {
						$.post('Order_delete', {
							id : row.id
						}, function(result) {
							if (result = "true") {
								$('#orderdg').datagrid('reload'); // reload the user data
							} else {
								jAlert('系统错误，请联系管理员', '错误提示');
							}
						}, 'json');
					}
				});
			}
		}
		function  formatorderstatus(val){
			if(val=="1"){
				return "订单创建";
			}else if(val=="2"){
				return "支付完成";
			}else if(val=="3"){
				return "订单撤销";
			} if(val=="4"){
				return "订单已发货";
			}if(val=="5"){
				return "订单完成";
			}else{
				return "非法数据";
			}
		}
	</script>
	<style type="text/css">
#orderfm {
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