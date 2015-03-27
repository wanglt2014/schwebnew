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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>${sitename}--后台管理系统---action执行时间</title>
<link rel="stylesheet" type="text/css"
	href="${css_path}/admin/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/icon.css">
<link rel="stylesheet" type="text/css" href="${css_path}/admin/demo.css">
<script type="text/javascript" src="${js_path}/jquery.js"></script>
<script type="text/javascript"
	src="${js_path}/easyui/jquery.easyui.min.js"></script>

</head>
<body>

<%
    String url = request.getContextPath() + "/DisplayChart.rpt?filename=" ;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%>
<table><tr>
<td style="width: 50%"><img src="<%= url %>${fileName}" ></td>
<td style="width: 50%" align="center">
<table class="easyui-datagrid" title="action执行时间" id="emaildatagrid" style="width:330px;height:auto"
			data-options="url:'${request_path}/ExcuteTime_query',method:'get',pagination:false,singleSelect:true,fitColumns:true,rownumbers: true"  pageSize="20" >
			<thead>
				<tr>
					<th data-options="field:'excuteTime'" width="80">耗时</th>
					<th data-options="field:'actionName'" width="120">Action名字</th>
					<th data-options="field:'createtime',align:'right'" width="100" formatter="formatterdate">执行时间</th>
				</tr>
			</thead>
</table>
</td>
</tr></table>
</body>
</html>