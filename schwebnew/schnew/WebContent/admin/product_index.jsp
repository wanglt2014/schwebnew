<%@page import="org.apache.struts2.components.Include"%>
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
<title>${sitename}--后台管理系统--产品管理</title>
   
</head>
<body>
		<div id="producttb" style="padding: 5px; height: auto;width:auto;">
			<div>
				创建起始日期: <input id="startdatacreatproduct" class="easyui-datebox" style="width: 80px">
				创建结束日期: <input id="enddatacreatproduct" class="easyui-datebox" style="width: 80px">
				是否激活: <select id="productisactive" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="all">全部</option>
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
				分类:<input
				class="easyui-combobox" id="queryproductcategoryCodequery"
				data-options="
					url:'Productcategory_queryproductcategory',
					method:'get',
					valueField:'productcategoryCode',
					textField:'productcategoryName',
					panelHeight:'auto'">
				产品名称:<input type="text"  id="productnamequery">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryproduct()">搜索</a>
			</div>
		</div>
    <table id="productdg" title="新闻类表" class="easyui-datagrid" style="width:auto;height:616px"
            url="Product_query"
            toolbar="#toolbarproduct" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
                <th field="productCode" width="50">产品代码</th>
                <th field="productName" width="50">产品名称</th>
                <th field="productPrice" width="100" >产品价格(单位:元)</th>
                <th field="productImageUrl" width="100">图片名字</th>
                <th field="productcategoryCode" width="50" formatter="formatproductcatagroycode" >产品分类</th>
                <th field="supplierCode" width="50" formatter="formatcode">供应商</th>
                <th field="isactice" width="50" formatter="formatterIsactive">是否激活</th>
                <th field="createdate" width="50" formatter="formatterdate">创建日期</th>
                 <th field="id" width="50" formatter="formatpreview">预览</th>
            </tr>
        </thead>
    </table>
    <div id="toolbarproduct">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newProduct()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editProduct()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyProduct()">删除</a>
    </div>
    
    <div id="productdlg" class="easyui-dialog" style="width:860px;height:auto;padding:10px 20px"
            closed="true" buttons="#productdlg-buttons">
        <div class="ftitle">产品详细信息</div>
        <form id="productfm" method="post" novalidate>
            <div class="fitem">
                <label>产品代码:</label>
                 <input type="text" name="productCode"  />
            </div>
            <div class="fitem">
                <label>产品名称:</label>
                 <input type="text" name="productName"  />
            </div>
            <div class="fitem">
                <label>产品价格:</label>
                 <input type="text" name="productPrice"  />(单位:元)
            </div>
            <div class="fitem">
                <label>图片名字:</label>
                 <input type="text" name="productImageUrl"  />
            </div>
            <div class="fitem">
                <label>供应商:</label>
               <input
				class="easyui-combobox" name="supplierCode"
				data-options="
					url:'Productcategory_querySupplierCode',
					method:'get',
					valueField:'supplierCode',
					textField:'supplierName',
					panelHeight:'auto'">
            </div>
            <div class="fitem">
                <label>产品分类:</label>
                <input
				class="easyui-combobox" name="productcategoryCode"
				data-options="
					url:'Productcategory_queryproductcategory',
					method:'get',
					valueField:'productcategoryCode',
					textField:'productcategoryName',
					panelHeight:'auto'">
            </div>
            <div class="fitem">
                <label>是否激活:</label>
                <select name="isactice" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="yes">已激活</option>
					<option value="no">未激活</option>
				</select>
            </div>
            <div class="fitem">
                <label>时间:</label>
                <input name="createdate" type="text" class="easyui-datebox" id="createdate" required="true" />
            </div>
            <div  style="display: none;">
           		 <textarea name="content" id="content" class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/>
            </div>
             <div class="fitem" style="">
                <label>产品内容:</label>
                <br/>
                <!--style给定宽度可以影响编辑器的最终宽度-->
				<script type="text/plain" id="myEditorproduct" name="myEditorproduct" style="width:750px;height:240px;">
    				<p>这里我可以写一些输入提示</p>
				</script>
            </div>
          
        </form>
        
    </div>
    <div id="productdlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveProduct()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#productdlg').dialog('close')">取消</a>
    </div>
    
    <script type="text/javascript">
        var url;
        window.UEDITOR_HOME_URL="${request_path}";
        var um = UM.getEditor('myEditorproduct');
        function formatpreview(value,rowData,rowIndex) {
    		var s ='<a href="Ordering_queryProductInfo?id='+rowData.id+'" class="easyui-linkbutton" target="_blank"">预览</a>';
    		return s;
   	    }
        function queryproduct(){
        	var startdatacreatproduct = $('#startdatacreatproduct').datebox('getValue');
        	var enddatacreatproduct = $('#enddatacreatproduct').datebox('getValue');
        	var queryproductcategoryCodequery =  $('#queryproductcategoryCodequery').combobox('getValue');
        	var productisactive =  $('#productisactive').combobox('getValue');
        	var productnamequery = $('#productnamequery').val();
        	$('#productdg').datagrid('load', {
        		startdatacreatproduct:startdatacreatproduct,
        		enddatacreatproduct:enddatacreatproduct,
        		productisactive:productisactive,
        		queryproductcategoryCodequery:queryproductcategoryCodequery,
        		productnamequery:productnamequery
        	});
        }
        function newProduct(){
            $('#productdlg').dialog('open').dialog('setTitle','发布产品');
            $('#productfm').form('clear');
            UM.getEditor('myEditorproduct').setContent('', false);
            url = 'Product_save';
        }
        function editProduct(){
            var row = $('#productdg').datagrid('getSelected');
            if (row){
                $('#productdlg').dialog('open').dialog('setTitle','编辑产品');
                $('#productfm').form('clear');
                $('#productfm').form('load',row);
                $('#createdate').datebox('setValue', timeStamp2String(row.createdate));
                UM.getEditor('myEditorproduct').setContent(row.productInfo, false);
                url = 'Product_update?id='+row.id;
            }
        }
        function timeStamp2String(time){
           		var date = new Date();
           		date.setTime(time);
            	var y = date.getFullYear();
            	var m = date.getMonth()+1;
            	var d = date.getDate();
            	return m+'/'+d+'/'+y;
        }
        function saveProduct(){
        	$("#content").val(UM.getEditor('myEditorproduct').getContent());
            $('#productfm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result!="true"){
                    	jAlert('系统错误，请联系管理员','错误提示');
                    } else {
                        $('#productdlg').dialog('close');        // close the dialog
                        $('#productdg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyProduct(){
            var row = $('#productdg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','你想要删除这个产品吗?',function(r){
                    if (r){
                        $.post('Product_deleteBsProduct',{id:row.id},function(result){
                            if (result="true"){
                                $('#productdg').datagrid('reload');    // reload the user data
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
        #productfm{
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