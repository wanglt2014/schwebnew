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
<title>${sitename}--后台管理系统--供应商管理</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<div id="suppliertb" style="padding: 5px; height: auto">
		<div>
				供应商名称:<input type="text"  id="supplierNamequery">
				供应商联系人:<input type="text"  id="contanctnamequery">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querySupplier()">搜索</a>
			</div>
		</div>
    <table id="supplierdg" title="供应商列表" class="easyui-datagrid" style="width:auto;height:616px"
            url="Supplier_query"
            toolbar="#suppliertoolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
                <th field="supplierCode" width="50">供应商代码</th>
                <th field="supplierName" width="50">供应商名字</th>
                <th field="supplierInfo" width="50">供应商信息</th>
                <th field="supplierUrl" width="50">供应商网址</th>
                <th field="contactname" width="50">联系人名字</th>
                <th field="contactemail" width="50">联系人邮箱</th>
                <th field="contactphone" width="50">联系人号码</th>
            </tr>
        </thead>
    </table>
    <div id="suppliertoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newSupplier()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editSupplier()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroySupplier()">删除</a>
    </div>
    
    <div id="supplierdlg" class="easyui-dialog" style="width:400px;height:380px;padding:10px 20px"
            closed="true" buttons="#supplierdlg-buttons">
        <div class="ftitle">供应商信息</div>
        <form id="supplierfm" method="post" novalidate>
            <div class="fitem">
                <label>供应商代码:</label>
                <input name="supplierCode" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>供应商名字</label>
                <input name="supplierName" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>供应商信息:</label>
                <input name="supplierInfo" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>供应商网址:</label>
                <input name="supplierUrl" class="easyui-validatebox"  required="true">
            </div>
            <div class="fitem">
                <label>联系人名字:</label>
                <input name="contactname" class="easyui-validatebox" required="true">
            </div>
             <div class="fitem">
                <label>联系人邮箱:</label>
                <input name="contactemail" class="easyui-validatebox" validType="email" required="true">
            </div>
            <div class="fitem">
                <label>联系人号码:</label>
                <input name="contactphone" class="easyui-validatebox" required="true">
            </div>
           
        </form>
    </div>
    <div id="supplierdlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveSupplier()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#supplierdlg').dialog('close')">取消</a>
    </div>
    <script type="text/javascript">
        var url;
        function querySupplier(){
        	var supplierNamequery = $('#supplierNamequery').val();
        	var contanctnamequery = $('#contanctnamequery').val();
        	$('#supplierdg').datagrid('load', {
        		supplierNamequery: supplierNamequery,
        		contanctnamequery: contanctnamequery
        	});
        }
        function newSupplier(){
            $('#supplierdlg').dialog('open').dialog('setTitle','新增用户');
            $('#supplierfm').form('clear');
            url = 'Supplier_save';
        }
        function editSupplier(){
            var row = $('#supplierdg').datagrid('getSelected');
            if (row){
                $('#supplierdlg').dialog('open').dialog('setTitle','编辑用户');
                $('#supplierfm').form('clear');
                $('#supplierfm').form('load',row);
                url = 'Supplier_update?id='+row.id;
            }
        }
        function saveSupplier(){
            $('#supplierfm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result!="true"){
                    	jAlert('系统错误，请联系管理员','错误提示');
                    } else {
                        $('#supplierdlg').dialog('close');        // close the dialog
                        $('#supplierdg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroySupplier(){
            var row = $('#supplierdg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','你想要删除这个供应商吗?',function(r){
                    if (r){
                        $.post('Supplier_delete',{id:row.id},function(result){
                            if (result="true"){
                                $('#supplierdg').datagrid('reload');    // reload the user data
                            } else {
                            	jAlert('系统错误，请联系管理员','错误提示');
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
    <style type="text/css">
        #supplierfm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
</body>
</html>