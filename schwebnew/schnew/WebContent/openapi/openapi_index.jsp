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
<title>${sitename}--后台管理系统--openapi管理</title>
   
</head>
<body>
		<div id="openapitb" style="padding: 5px; height: auto;width:auto;">
			<div>
				标题:<input type="text"  id="openapitext">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryopenapi()">搜索</a>
			</div>
		</div>
    <table id="openapidg" title="openapi类表" class="easyui-datagrid" style="width:auto;height:616px"
            url="OpenApi_queryapi"
            toolbar="#toolbaropenapi" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
             <th field="id" width="30">ID</th>
                <th field="text" width="30">名字</th>
                <th field="apiurl" width="50">URL</th>
                <th field="apitype" width="30" >返回类型</th>
                <th field="httptype" width="100">http类型</th>
                <th field="parent" width="50">所属上级</th>
                <th field="apidesc" width="30" formatter="apiformatpreview">预览</th>
            </tr>
        </thead>
    </table>
    <div id="toolbaropenapi">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openapiOpenApi()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editOpenApi()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyOpenApi()">删除</a>
    </div>
    
    <div id="openapidlg" class="easyui-dialog" style="width:860px;height:auto;padding:10px 20px"
            closed="true" buttons="#openapidlg-buttons">
        <div class="ftitle">openapi详细信息</div>
        <form id="openapifm" method="post" novalidate>
            <div class="fitem">
                <label>标题</label>
                <input name="text" class="easyui-validatebox" required="true" >
            </div>
            <div class="fitem">
                <label>URL:</label>
                <input name="apiurl" class="easyui-validatebox" >
            </div>
            <div class="fitem">
                <label>api返回类型:</label>
                 <input name="apitype" class="easyui-validatebox"  >
            </div>
            <div class="fitem">
                <label>http方式</label>
                <input name="httptype" class="easyui-validatebox"  >
            </div>
            <div class="fitem">
                <label>所属上级</label>
                <input name="parent" class="easyui-combotree" data-options="url:'OpenApi_query',method:'get',required:true" style="width:200px;" required="true" >
            </div>
            <div  style="display: none;">
           		 <textarea name="apidesc" id="apidesc" class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/>
            </div>
             <div class="fitem" style="">
                <label>openapi内容:</label>
                <br/>
                <!--style给定宽度可以影响编辑器的最终宽度-->
				<script type="text/plain" id="myEditoropenapi" name="myEditoropenapi" style="width:750px;height:240px;">
    				<p>这里我可以写一些输入提示</p>
				</script>
            </div>
          
        </form>
        
    </div>
    <div id="openapidlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveOpenApi()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#openapidlg').dialog('close')">取消</a>
    </div>
    
    <script type="text/javascript">
        var url;
        window.UEDITOR_HOME_URL="${request_path}";
        var um = UM.getEditor('myEditoropenapi');
        function apiformatpreview(value,rowData,rowIndex) {
    		var s ='<a href="OpenApi_queryApiDetail?id='+rowData.id+'" class="easyui-linkbutton" target="_blank"">预览</a>';
    		return s;
   	    }
        function queryopenapi(){
        	var openapiname = $('#openapitext').val();
        	$('#openapidg').datagrid('load', {
        		openapiname :openapiname
        	});
        }
        function openapiOpenApi(){
            $('#openapidlg').dialog('open').dialog('setTitle','发表openapi');
            $('#openapifm').form('clear');
            UM.getEditor('myEditoropenapi').setContent('', false);
            url = 'OpenApi_save';
        }
        function editOpenApi(){
         
            var row = $('#openapidg').datagrid('getSelected');
            if (row){
                $('#openapidlg').dialog('open').dialog('setTitle','编辑openapi');
                $('#openapifm').form('clear');
                $('#openapifm').form('load',row);
                if(null==row.apidesc||row.apidesc==""){
                	UM.getEditor('myEditoropenapi').setContent('', false);
                }else{
              	  UM.getEditor('myEditoropenapi').setContent(row.apidesc, false);
                }
                url = 'OpenApi_update?id='+row.id;
            }
        }
        function saveOpenApi(){
        	$("#apidesc").val(UM.getEditor('myEditoropenapi').getContent());
            $('#openapifm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result!="true"){
                    	jAlert('系统错误，请联系管理员','错误提示');
                    } else {
                        $('#openapidlg').dialog('close');        // close the dialog
                        $('#openapidg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyOpenApi(){
            var row = $('#openapidg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','你想要删除这个openapi吗?',function(r){
                    if (r){
                        $.post('OpenApi_deleteOpenApi',{id:row.id},function(result){
                            if (result="true"){
                                $('#openapidg').datagrid('reload');    // reload the user data
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
        #openapifm{
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