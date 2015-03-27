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
<title>${sitename}--后台管理系统--用户管理</title>
   
</head>
<body>
		<div id="newstb" style="padding: 5px; height: auto;width:auto;">
			<div>
				创建起始日期: <input id="startdatacreatenew" class="easyui-datebox" style="width: 80px">
				创建结束日期: <input id="enddatacreatenew" class="easyui-datebox" style="width: 80px">
				文章类型: <select id="newtype" class="easyui-combobox" panelHeight="auto" editable="false"
					style="width: 100px">
					<option value="">全部</option>
					<option value="regulation">教学规章制度</option>
					<option value="notice">教务教学通知</option>
				</select>
				作者:<input type="text"  id="author">
				标题:<input type="text"  id="title">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querynews()">搜索</a>
			</div>
		</div>
    <table id="newdg" title="文章列表" class="easyui-datagrid" style="width:auto;height:616px"
            url="News_query"
            toolbar="#toolbarnew" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
                <th field="author" width="30">作者</th>
                <th field="createdate" width="50" formatter="formatterdate">创建日期</th>
                <th field="type" width="30" formatter="formatnewstype">类型</th>
                <th field="title" width="100">标题</th>
                <th field="summary" width="250">概要</th>
                <th field="updatedate" width="50" formatter="formatterdate">更新日期</th>
                <th field="id" width="30" formatter="formatpreview">预览</th>
            </tr>
        </thead>
    </table>
    <div id="toolbarnew">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newNews()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editNews()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyNews()">删除</a>
    </div>
    
    <div id="newdlg" class="easyui-dialog" style="width:860px;height:auto;padding:10px 20px"
            closed="true" buttons="#newdlg-buttons">
        <div class="ftitle">文章详细信息</div>
        <form id="newsfm" method="post" novalidate>
            <div class="fitem">
                <label>类型:</label>
                 <input type="checkbox" name="type"  value="media" checked="checked" />媒体报道
                  <input type="checkbox" name="type"  value="news" checked="checked" />公司新闻
                 <input type="checkbox" name="type" value="notice" checked="checked" />公告通知
            </div>
            <div class="fitem">
                <label>标题</label>
                <input name="title" class="easyui-validatebox" required="true" size="50px;" maxlength="20"/>
            </div>
            <div class="fitem">
                <label>作者:</label>
                <input name="author" class="easyui-validatebox" required="true" maxlength="20"/>
            </div>
            <div class="fitem">
                <label>概要:</label>
                <textarea name="summary"  class="easyui-validatebox" maxlength="500"  required="true" style="width: 500px;height: 100px;"/>
            </div>
            <div class="fitem">
                <label>时间:</label>
                <input name="createdate" type="text" class="easyui-datebox" id="createdate" required="true" />
            </div>
            <div  style="display: none;">
           		 <textarea name="content" id="content" class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/>
            </div>
             <div class="fitem" style="">
                <label>文章内容:</label>
                <br/>
                <!--style给定宽度可以影响编辑器的最终宽度-->
				<script type="text/plain" id="myEditornew" name="myEditornew" style="width:750px;height:240px;">
    				<p>这里我可以写一些输入提示</p>
				</script>
            </div>
          
        </form>
        
    </div>
    <div id="newdlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNews()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#newdlg').dialog('close')">取消</a>
    </div>
    
    <script type="text/javascript">
        var url;
        var allBox = $(":checkbox");
        allBox.click(function () {
            allBox.removeAttr("checked");
            $(this).attr("checked", "checked");
        });
       // window.UEDITOR_HOME_URL="http://www.59et.com/";
       // alert(window.UEDITOR_HOME_URL);
        var um = UM.getEditor('myEditornew');
        function formatpreview(value,rowData,rowIndex) {
    		var s ='<a href="News_newsdetail?id='+rowData.id+'" class="easyui-linkbutton" target="_blank"">预览</a>';
    		return s;
   	    }
        
        function formatnewstype(value,rowData,rowIndex) {
        	var s="";
    		if(value=="notice"){
    			s ="公告通知";
    		}else if(value=="media"){
    			s ="媒体报道";
    		}else if(value=="news"){
    			s ="公司新闻";
    		}
    		return s;
   	    }
        function querynews(){
        	var startdatacreatenew = $('#startdatacreatenew').datebox('getValue');
        	var enddatacreatenew = $('#enddatacreatenew').datebox('getValue');
        	var newtype =  $('#newtype').combobox('getValue');
        	var newauthor = $('#newauthor').val();
        	var newtitle = $('#newtitle').val();
        	$('#newdg').datagrid('load', {
        		startdatacreatenew:startdatacreatenew,
        		enddatacreatenew:enddatacreatenew,
        		newtype:newtype,
        		newauthor:newauthor,
        		newtitle:newtitle
        	});
        }
        function newNews(){
            $('#newdlg').dialog('open').dialog('setTitle','发表文章');
            $('#newsfm').form('clear');
            UM.getEditor('myEditornew').setContent('', false);
            url = 'News_save';
        }
        function editNews(){
            var row = $('#newdg').datagrid('getSelected');alert(row.content);
            if (row){
                $('#newdlg').dialog('open').dialog('setTitle','编辑文章');
                $('#newsfm').form('clear');
                $('#newsfm').form('load',row);
                $('#createdate').datebox('setValue', timeStamp2String(row.createdate));
                UM.getEditor('myEditornew').setContent(row.content, false);
                url = 'News_update?id='+row.id;
            }
        }
        function saveNews(){
        	$("#content").val(UM.getEditor('myEditornew').getContent());alert($("#content").val());
            $('#newsfm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result!="true"){
                    	jAlert('系统错误，请联系管理员','错误提示');
                    } else {
                        $('#newdlg').dialog('close');        // close the dialog
                        $('#newdg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyNews(){
            var row = $('#newdg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','你想要删除这骗文章吗?',function(r){
                    if (r){
                        $.post('News_deleteArticle',{id:row.id},function(result){
                            if (result="true"){
                                $('#newdg').datagrid('reload');    // reload the user data
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
        #newsfm{
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