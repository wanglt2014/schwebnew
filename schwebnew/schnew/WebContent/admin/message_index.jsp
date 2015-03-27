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
<title>${sitename}--后台管理系统--消息管理</title>
   
</head>
<body>
		<div id="leavemessagetb" style="padding: 5px; height: auto;width:auto;">
			<div>
					留言内容(likel):<input type="text"  id="leavemessagetitle">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryleavemessage()">搜索</a>
			</div>
		</div>
    <table id="leavemessagedg" title="留言列表" class="easyui-datagrid" style="width:auto;height:616px"
            url="LeaveMessage_query"
            toolbar="#toolbarleavemessage" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
           		<th field="name" width="30">姓名</th>
                <th field="email" width="30">邮箱</th>
                <th field="telephone" width="100">联系电话</th>
                <th field="message" width="250">留言内容</th>
                 <th field="leaveTime" width="50" formatter="formatterdate">创建日期</th>
            </tr>
        </thead>
    </table>
    <div id="toolbarleavemessage">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editLeavemessage()">查看留言</a>
    </div>
    
    <div id="leavemessagedlg" class="easyui-dialog" style="width:860px;height:auto;padding:10px 20px"
            closed="true" >
        <div class="ftitle">留言详细信息</div>
        <form id="leavemessagefm" method="post" novalidate>
            <div class="fitem">
                <label>姓名:</label>
                <input name="name" class="easyui-validatebox" required="true" size="50px;">
            </div>
            <div class="fitem">
                <label>邮箱:</label>
                <input name="email" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>电话:</label>
                <input name="telephone" class="easyui-validatebox" required="true"/>
            </div>
            <div class="fitem">
                <label>联系电话:</label>
                <textarea name="message"  class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/>
            </div>
            <div class="fitem">
                <label>留言时间:</label>
                <input name="leaveTime" type="text" class="easyui-datebox" id="leaveTime" required="true" />
            </div>
          
        </form>
        
    </div>
    
    <script type="text/javascript">
        
        function queryleavemessage(){
        	var leavemessagetitle = $('#leavemessagetitle').val();
        	$('#leavemessagedg').datagrid('load', {
        		leavemessagetitle:leavemessagetitle
        	});
        }
        function editLeavemessage(){
            var row = $('#leavemessagedg').datagrid('getSelected');
            if (row){
                $('#leavemessagedlg').dialog('open').dialog('setTitle','查看留言');
                $('#leavemessagefm').form('clear');
                $('#leavemessagefm').form('load',row);
                $('#leaveTime').datebox('setValue', timeStamp2String(row.leaveTime));
            }
        }
       
      
    </script>
    <style type="text/css">
        #leavemessagefm{
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