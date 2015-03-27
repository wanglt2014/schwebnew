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
<title>${sitename}--后台管理系统--资料下载</title>
</head>
<body>
		<div id="downloadtb" style="padding: 5px; height: auto;width:auto;">
			<div>
				作者:<input type="text"  id="authorQuery">
				资料名称:<input type="text"  id="filenameQuery">
				 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querynews()">搜索</a>
			</div>
		</div>
    <table id="downloaddg" title="资料列表" class="easyui-datagrid" style="width:auto;height:616px"
            url="Download_query"
            toolbar="#downloadtoolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20">
        <thead>
            <tr>
            	<th field="filename" width="50" >文件名称</th>
                <th field="author" width="30">作者</th>
                <th field="createdate" width="60" >创建日期</th>
                <th field="directions" width="210">描述</th>
                <th field="downloadid" width="30" formatter="formatpreview">预览</th>
            </tr>
        </thead>
    </table>
    <div id="downloadtoolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="insertDownload()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDownload()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDownload()">删除</a>
    </div>
    
    <div id="downloaddlg" class="easyui-dialog" style="width:860px;height:auto;padding:10px 20px"
            closed="true" buttons="#downloaddlg-buttons">
        <div class="ftitle">资料信息</div>
        <form id="downloadfm" method="post" novalidate>
		 	<div class="fitem" id="uploadFileDIV">
                <label>上传文件:</label>
            	<input id="uploader_count" name="uploader_count" value="0" style="display: none;"/>
				<ul id="file-listForDownload" style="text-align: left;margin:0px 0px 0px 30px; ">
				</ul>
				<div class="btn-wraper">
					<input type="button" value="选择文件..." id="browseForDownload" />
					<input type="button" value="清空" id="clear-btn" />
					<p class="tip2">注意：只能上传10M以内的文件</p>
				</div>
			</div>
            <div class="fitem">
                <label>文件名称</label>
                <input id="filename" name="filename"  class="easyui-validatebox" required="true" size="50px;" maxlength="20"/>
            </div>
            <div class="fitem">
                <label>作者:</label>
                <input id="author" name="author" class="easyui-validatebox" required="true" maxlength="20"/>
            </div>
            <div class="fitem">
                <label>描述:</label>
                <textarea id="directions" name="directions" maxlength="500"  class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/>
            </div>
            <div class="fitem">
                <label>时间:</label>
                <input id="createdate"  name="createdate" type="text" class="easyui-datebox"  required="true" />
            </div>
<!--             <div  style="display: none;"> -->
<!--            		 <textarea name="content" id="content" class="easyui-validatebox"  required="true" style="width: 500px;height: 100px;"/> -->
<!--             </div> -->
           
        </form>
        
    </div>
    <div id="downloaddlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveDownload()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#downloaddlg').dialog('close')">取消</a>
    </div>
    
    <script type="text/javascript">
        var url;
//         var allBox = $(":checkbox");
//         allBox.click(function () {
//             allBox.removeAttr("checked");
//             $(this).attr("checked", "checked");
//         });
        function formatpreview(value,rowData,rowIndex) {
    		var s ='<a href="Download_downloaddetail?id='+rowData.downloadid+'" class="easyui-linkbutton" target="_blank"">预览</a>';
    		return s;
   	    }
        
//         function formatnewstype(value,rowData,rowIndex) {
//         	var s="";
//     		if(value=="notice"){
//     			s ="教务教学通知";
//     		}else if(value=="regulation"){
//     			s ="教学规章制度";
//     		}
//     		return s;
//    	    }
        
        function querynews(){
//         	var startdatacreatenew = $('#startdatacreatenew').datebox('getValue');
//         	var enddatacreatenew = $('#enddatacreatenew').datebox('getValue');
//         	var newtype =  $('#articletype').combobox('getValue');
        	var downloadauthor = $('#authorQuery').val();
        	var filename = $('#filenameQuery').val();
        	$('#downloaddg').datagrid('load', {
//         		startdatacreatenew:startdatacreatenew,
//         		enddatacreatenew:enddatacreatenew,
//         		newtype:newtype,
        		downloadauthor:downloadauthor,
        		filename:filename
        	});
        }
        function insertDownload(){
            $('#downloaddlg').dialog('open').dialog('setTitle','新增资料');
            $('#downloadfm').form('clear');
            $('#uploadFileDIV').show();
//             UM.getEditor('myEditornew').setContent('', false);
            url = 'Download_save';
            uploaderForDownload.init(); //初始化
            uploaderForDownload.splice(0,10);
        }
        function editDownload(){
            var row = $('#downloaddg').datagrid('getSelected');
            if (row){
                $('#downloaddlg').dialog('open').dialog('setTitle','编辑资料');
                $('#downloadfm').form('clear');
                $('#uploadFileDIV').hide();
                $('#downloadfm').form('load',row);
                
                url = 'Download_update?id='+row.downloadid;
            }
        }
        function saveDownload(){
//         	$("#content").val(UM.getEditor('myEditornew').getContent());
        	var valid = $('#downloadfm').form('validate');
    		if(valid==true){
            $('#downloadfm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result!="true"){
                    	uploaderForDownload.refresh();
                    	jAlert('系统错误，请联系管理员','错误提示');
                    } else {
                    	uploaderForDownload.splice(0,10); 
                    	$('#file-listForDownload').html("");
                        $('#downloaddlg').dialog('close');        // close the dialog
                        $('#downloaddg').datagrid('reload');    // reload the user data
                    }
                }
            });
            if(url.indexOf("save") > 0){
            	uploaderForDownload.start();
            }
    		}else{
    			alert("信息填写不完整");
    		}
        }
        function destroyDownload(){
            var row = $('#downloaddg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','是否要删除?',function(r){
                    if (r){
                        $.post('Download_deleteDownloadInfo',{id:row.downloadid},function(result){
                            if (result="true"){
                                $('#downloaddg').datagrid('reload');    // reload the user data
                            } else {
                            	jAlert('系统错误，请联系管理员','错误提示');
                            }
                        },'json');
                    }
                });
            }
        }
        
        
      //上传控件##########################################
    	var uploaderForDownload = new plupload.Uploader({ //实例化一个plupload上传对象
    		browse_button : 'browseForDownload',
    		multi_selection: false,
     		url : 'File_uploadForOther',
     		file_data_name : 'fileData',
//     		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
            flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
            silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            unique_names : true,  // 上传的文件名是否唯一   
            multipart_params: {
            	  filetype: 'article'
            	},
            filters: {
//       		  mime_types : [ //只允许上传图片文件和rar压缩文件
//       		    { title : "图片文件", extensions : "jpg,gif,png,bmp" }
//       		  ],
      		  max_file_size : '10mb', //最大只能上传10mb的文件
      		  prevent_duplicates : true //不允许队列中存在重复文件
            }
    	});
//     	uploaderForDownload.init(); //初始化
    	
    	//绑定文件上传删除事件
    	uploaderForDownload.bind('FilesRemoved',function(uploader,file){
//     		alert("删除");
    		$('#file-listForDownload').html("");
    	});
    	
    	//绑定文件添加进队列事件
    	uploaderForDownload.bind('FilesAdded',function(uploader,files){
    		$.each(uploader.files, function (i, file) { 
    			if (uploader.files.length <= 1) { 
    		            return; 
    		        } 
    		        uploaderForDownload.removeFile(file); 
    		    });
    		for(var i = 0, len = files.length; i<len; i++){
    			var file_name = files[i].name; //文件名
    			var file_id = files[i].id;//ID,临时文件名
    			//构造html来更新UI
    			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
//     			var html = '<li id="file-' + file_id +'" style="text-align: left;">';
    				html += '<input type="hidden" name="uploader_tmpname" value="' + file_id + '" />';
    				html += '<input type="hidden" name="uploader_name" value="' + file_name + '" /></li>';
    			$(html).appendTo('#file-listForDownload');
    			$('#filename').val(file_name);
    		}
    	});
    </script>
    <style type="text/css">
        #downloadfm{
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