<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String request_path = request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	String basePath = request.getScheme() + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + request_path + "/";   
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${sitename}--后台管理系统--师资队伍</title>
<%-- <script type="text/javascript" src="${request_path}/js/jquery.js" ></script>  --%>
<%-- <link rel="stylesheet" type="text/css" href="${js_path}/plupload/queue/css/jquery.plupload.queue.css"> --%>
<%-- <%-- <script type="text/javascript" src="${js_path}/plupload/plupload.full.min.js"></script> --%> 
<%-- <script type="text/javascript" src="${request_path}/plupload/js/plupload.full.js"></script> --%>
<%-- <script type="text/javascript" src="${request_path}/plupload/js/i18n/cn.js"></script> --%>
<%-- <script type="text/javascript" src="${request_path}/js/plupload/queue/jquery.plupload.queue.js"></script> --%>
<%-- <script type="text/javascript" src="${request_path}/plupload/js/i18n/cn.js"></script> --%>
<%-- <script type="text/javascript" src="${js_path}/plupload/pluploadEXT.js"></script> --%>
</head>
<body>
<div id="teachertb" style="padding: 5px; height: auto">
		<div>
			教师姓名:<input type="text" id="teachernameQuery"> 
			所在专业:<input
				class="easyui-combobox" id="departmentQuery"
				data-options="
 					url:'Dictionary_queryDictionaryByType?type=department',
					method:'get', 
 					valueField:'dictionarycode', 
 					textField:'dictionaryvalue', 
					panelHeight:'auto',editable:false"> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="queryTearcher()">搜索</a>
		</div>
	</div>
	<table id="teacherdg" title="列表" class="easyui-datagrid"
		style="width: auto; height: 616px" url="Teacher_query"
		toolbar="#teachertoolbar" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true" pageSize="20">
		<thead>
			<tr>
				<th field="teachername" width="30">姓名</th>
				<th field="departmentname" width="50">所在专业</th>
				<th field="titlename" width="30" >职称</th>
				<th field="job" width="30"  formatter="formatJobtype">职务</th>
				<th field="tutortype" width="20" formatter="formatTutortype">硕/博导</th>
				<th field="sex" width="20" formatter="formatSextype">性别</th>
			</tr>
		</thead>
	</table>
	<div id="teachertoolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newTeacher()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editTeacher()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyTeacher()">删除</a>
	</div>
	<div id="teacherdlg" class="easyui-dialog"
		style="width: 800px; height: 720px; padding: 10px 20px" closed="true"
		buttons="#teacherdlg-buttons">
		<form id="teacherfm" method="post" novalidate>
		<div id="teacher_tab" class="easyui-tabs" style="height: 616px"
			data-options="fit:true,border:false,plain:true" >
			<div title="基本信息" style="padding:20px;" id="Tab1"> 
					<div class="ftitle">基本信息</div>
					
						<div class="fitem">
							<label>姓名:</label> 
							<input id="teachername" name="teachername" class="easyui-validatebox" required="true" maxlength="20">
						</div>
						<div class="fitem">
							<label>性别</label> 
							<select id="sex" name="sex" class="easyui-combobox" panelHeight="auto" editable="false"
								style="width: 100px">
								<option value="0" >男</option>
								<option value="1" >女</option>
							</select>
						</div>
						<div class="fitem">
							<label>出生年月:</label> 
							<input id="birthday" name="birthday" type="text" data-options="formatter:ww4,parser:w4" class="easyui-datebox" id="birthday" required="true" />
						</div>
						<div class="fitem">
							<label>所在专业:</label>
							<input
								class="easyui-combobox" id="department" name="department"
								data-options="
 				 					url:'Dictionary_queryDictionaryByType?type=department',
 									method:'get',
 				 					valueField:'dictionarycode',
 				 					textField:'dictionaryvalue',  
 									panelHeight:'auto',editable:false"> 
 							<input id="departmentname" name="departmentname" type="hidden" />
						</div>
						<div class="fitem">
							<label>职称:</label>
							<input
								class="easyui-combobox" id="title" name="title" editable="false"
								data-options="
 				 					url:'Dictionary_queryDictionaryByType?type=title',
 									method:'get',  
 				 					valueField:'dictionarycode',  
 				 					textField:'dictionaryvalue',  
 									panelHeight:'auto'"> 
 							<input id="titlename" name="titlename" type="hidden" />
						</div>
						<div class="fitem">
							<label>职务:</label>
							<input
								class="easyui-combobox" id="job" name="job"
								data-options="
			 						url:'Dictionary_queryDictionaryByType?type=job', 
									method:'get',
 				 					valueField:'dictionarycode',
				 					textField:'dictionaryvalue',
 									panelHeight:'auto',editable:false">
 							<input id="jobname" name="jobname" type="hidden" />
						</div>
						<div class="fitem">
							<label>硕/博导:</label>
							<select id="tutortype" name="tutortype" class="easyui-combobox" panelHeight="auto" editable="false"
								style="width: 100px">
								<option value="1">硕导</option>
								<option value="2">博导</option>
							</select>
						</div>
						<div class="fitem">
							<label>个人介绍:</label>
							<textarea id="introduction" rows=5 name="introduction"  class="textarea easyui-validatebox"></textarea>
						</div><br>
						<div class="fitem">
							<div class="wraper">
							<label>照片:</label>
<!-- 							<input id="oldfileName" name="oldfileName" value="" style="display: none;"/> -->
<!-- 							<input id="tampFileName" name="tampFileName" value="" style="display: none;"/> -->
<!-- 								<input id="uploader_count" name="uploader_count" value="0" style="display: none;"/> -->
								<ul id="file-list" style="text-align: left;margin:0px 0px 0px 30px; ">
								</ul>
								<img class="img_photo" id="img_photo" src="" alt=""/>
								<div class="btn-wraper">
									<input type="button" value="选择文件..." id="browse" />
									<input type="button" value="开始上传" id="upload-btn" />
									<input type="button" value="清空" id="clear-btn" />
									<p class="tip2">注意：只能上传1M以内，格式为jpg,gif,png,bmp的照片</p>
								</div>
							</div>
						</div>
			</div> 
			<div title="讲授课程资料" closable="false" style="overflow:auto;padding:20px;" id="Tab2" > 
					<div class="ftitle">讲授课程资料</div>
						<div class="fitem">
							<label>课程性质:</label>
							<input
								class="easyui-combobox" id="subjecttype" name="subjecttype"
								data-options="
   				 					url:'Dictionary_queryDictionaryByType?type=subjectType',  
   									method:'get',    
   				 					valueField:'dictionarycode',    
   				 					textField:'dictionaryvalue',    
   									panelHeight:'auto',editable:false">
   							<input id="subjecttypename" name="subjecttypename" type="hidden" />   
						</div>
						<div class="fitem">
							<label>课程编号:</label> <input name="subjectno"
								class="easyui-validatebox" required="true" maxlength="20">
						</div>
						<div class="fitem">
							<label>课程名称:</label> <input name="subjectname"
								class="easyui-validatebox" required="true" maxlength="20">
						</div>
						<div class="fitem">
							<label>课程介绍:</label>
							<textarea id="subjectText" rows=5 name="subjecttext"  class="textarea easyui-validatebox" maxlength="500"></textarea>
						</div>
						<div class="fitem" id="outlineObj" >
							<div class="wraper">
							<label>教学大纲:</label> 
							<ul id="file-list-outline" style="text-align: left;margin:0px 0px 0px 30px; ">
							</ul>
							<div class="btn-wraper">
								<input type="button" value="选择文件..." id="browseOutline" />
								<input type="button" value="清空" id="outline-clear-btn" />
								<p class="tip2">注意：只能上传20M以内的文件</p>
							</div>
							</div>
						</div>
						<div class="fitem" id="scheduleObj">
							<div class="wraper">
							<label>教学进度表:</label> 
							<ul id="file-list-schedule" style="text-align: left;margin:0px 0px 0px 30px; ">
							</ul>
							<div class="btn-wraper">
								<input type="button" value="选择文件..." id="browseSchedule" />
								<input type="button" value="清空" id="schedule-clear-btn" />
								<p class="tip2">注意：只能上传20M以内的文件</p>
							</div>
							</div>
						</div>
						<div class="fitem" id="subjectObj">
							<div class="wraper">
							<label>课程资料:</label> 
<!-- 							<input id="uploader_subject_count" name="uploader_subject_count" value="0" style="display: none;"/> -->
							<ul id="file-list-subject" style="text-align: left;margin:0px 0px 0px 30px; ">
							</ul>
							<div class="btn-wraper">
								<input type="button" value="选择文件..." id="browseSubject" />
								<input type="button" value="清空" id="subject-clear-btn" />
								<p class="tip2">注意：只能上传20M以内的文件</p>
							</div>
							</div>
						</div>
			</div> 
			<div title="立项"  closable="false" style="overflow:auto;padding:20px;" id="Tab3"> 
				<div class="ftitle">立项</div>
				<div class="fitem">
					<label>项目级别:</label> <input name="researchlevel"
						class="easyui-validatebox" maxlength="20">
				</div>
				<div class="fitem">
					<label>项目名称:</label> <input name="researchname"
						class="easyui-validatebox" required="true" maxlength="20">
				</div>
				<div class="fitem">
					<label>项目编号:</label> <input name="researchno" maxlength="20"
						class="easyui-validatebox" >
				</div>
				<div class="fitem">
					<label>项目资金:</label> <input name="researchmoney"
						class="easyui-numberbox" max="2000000000" >
				</div>
				<div class="fitem">
					<label>配套资金:</label> <input name="researchmatchmoney"
						class="easyui-numberbox" max="2000000000" >
				</div>
				<div class="fitem">
					<label>项目主持人:</label> <input name="researchhost"
						class="easyui-validatebox" maxlength="20">
				</div>
				<div class="fitem">
					<label>项目参与者:</label> <input name="researchactor"
						class="easyui-validatebox" maxlength="40">
				</div>
				<div class="fitem">
					<label>项目开始时间:</label> 
					<input id="researchbegindate" name="researchbegindate" type="text" data-options="formatter:ww4,parser:w4" class="easyui-datebox"  />
				</div>
				<div class="fitem">
					<label>项目结束时间:</label> 
					<input id="researchenddate" name="researchenddate" type="text" data-options="formatter:ww4,parser:w4" class="easyui-datebox"  />
				</div>
				<div class="fitem" id="projectObj">
					<div class="wraper">
					<label>立项申请书电子版:</label> 
<!-- 					<input id="uploader_project_count" name="uploader_project_count" value="0" style="display: none;"/> -->
					<ul id="file-list-project" style="text-align: left;margin:0px 0px 0px 30px; ">
					</ul>
					<div class="btn-wraper">
						<input type="button" value="选择文件..." id="browseProject" />
						<input type="button" value="清空" id="project-clear-btn" />
						<p class="tip2">注意：只能上传20M以内的文件</p>
					</div>
					</div>
				</div>
<!-- 				<div class="ftitle">著作</div> -->
				</div>
				<div title="论文"  closable="false" style="overflow:auto;padding:20px;" id="Tab4"> 
					<div class="ftitle">论文</div>
					<div class="fitem">
						<label>论文名称:</label> <input name="papername"
							class="easyui-validatebox" required="true" maxlength="20">
					</div>
					<div class="fitem">
						<label>作者排序:</label> <input name="paperauthor" maxlength="20"
							class="easyui-validatebox" >
					</div>
					<div class="fitem">
						<label>期刊名称:</label> <input name="papernotename" maxlength="20"
							class="easyui-validatebox" >
					</div>
					<div class="fitem">
						<label>刊登年份:</label> <input name="papernoteyear"
							class="easyui-numberbox"  maxlength="4">
					</div>
					<div class="fitem">
						<label>杂志期号:</label> <input name="papernoteno" maxlength="20"
							class="easyui-validatebox" >
					</div>
					<div class="fitem" id="paperObj">
						<label>论文电子版:</label> 
<!-- 						<input id="uploader_Paper_count" name="uploader_Paper_count" value="0" style="display: none;"/> -->
						<ul id="file-list-paper" style="text-align: left;margin:0px 0px 0px 30px; ">
						</ul>
						<div class="btn-wraper">
							<input type="button" value="选择文件..." id="browsePaper" />
							<input type="button" value="清空" id="paper-clear-btn" />
							<p class="tip2">注意：只能上传20M以内的文件</p>
						</div>
					</div>
				</div>
				<div title="获奖"  closable="false" style="overflow:auto;padding:20px;" id="Tab5"> 
					<div class="ftitle">获奖</div>
					包括教学获奖、科研获奖、社会服务获奖，以及若干可自定义的备选项
				</div>
			</div>
</form>
	</div>
	<div id="teacherdlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveTeacher()">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#teacherdlg').dialog('close')">取消</a>
	</div>
	<script>
	function formatTutortype(value,rowData,rowIndex) {
    	var s="";
		if(value=="1"){
			s ="硕导";
		}else if(value=="2"){
			s ="博导";
		}
		return s;
	    }
	
	function formatSextype(value,rowData,rowIndex) {
    	var s="";
		if(value=="0"){
			s ="男";
		}else if(value=="1"){
			s ="女";
		}
		return s;
	    }
	
	function formatJobtype(value,rowData,rowIndex) {
		var s="";
		$.ajax({
			type : 'post',
			url : 'Dictionary_queryDictionaryByType?type=job',
			async:false,
			success : function(datas) {
				var datasArr=eval(datas);  
				for(var i=0;i<datasArr.length;i++){
					if(value==datasArr[i].dictionarycode){
						s= datasArr[i].dictionaryvalue;
					}
				}  
			},
			error : function() {
				jAlert('系统错误，请联系管理员','错误提示');
			}
		});
		return s;
	}
	
	
	var url;
	function queryTearcher() {
		var teachernamequery = $('#teachernameQuery').val();
		var departmentquery = $('#departmentQuery').combobox('getValue');
		$('#teacherdg').datagrid('load', {
			teachernamequery : teachernamequery,
			departmentquery : departmentquery
		});
	}
	function newTeacher() {
		uploaderForPic.init();
		deleteAllUploader();
		$('#teacherdlg').dialog('open').dialog('setTitle', '新增教师');
		$('#teacherfm').form('clear');
		url = 'Teacher_save';
		$('#sex').combobox('select',0);
		$('#tutortype').combobox('select',1);
		$('#img_photo').hide();
		
		var data = $('#department').combobox('getData');
		 $("#department ").combobox('select',data[0].dictionarycode);
		 var data = $('#title').combobox('getData');
		 $("#title ").combobox('select',data[0].dictionarycode);
		 var data = $('#job').combobox('getData');
		 $("#job ").combobox('select',data[0].dictionarycode);
		 var data = $('#subjecttype').combobox('getData');
		 $("#subjecttype ").combobox('select',data[0].dictionarycode);
// 		 $('#file-list').html("");
// 		 uploaderForPic.destroy();
		
	}
	function editTeacher() {
		var row = $('#teacherdg').datagrid('getSelected');
		if (row) {
			$('#teacherdlg').dialog('open').dialog('setTitle',
					'编辑教师');
			$('#teacherfm').form('clear');
			$('#teacherfm').form('load', row);
			$('#img_photo').show();
			$('#img_photo').attr('src',row.iimageurll);
			dispalyAllUploader();
			var subjectid,paperid,researchid;
// 			alert(JSON.stringify(row));
			//从后台获取数据
			$.ajax({
				type : 'post',
				url : 'Teacher_queryTeacherOtherInfo?teacherId='+row.id,
				async:false,
				success : function(datas) {
					var json = eval('(' + datas + ')'); 
//  					alert(JSON.stringify(json.subject.subjectid)+"!!!"+JSON.stringify(json.tPaper.paperid)+"@@@@"+JSON.stringify(json.tResearch.researchid));
 					subjectid = json.subject.subjectid;
 					paperid = json.tPaper.paperid;
 					researchid=json.tResearch.researchid;
 					$('#teacherfm').form('load', json.subject);
					$('#teacherfm').form('load', json.tPaper);
					$('#teacherfm').form('load', json.tResearch);
				},
				error : function() {
					jAlert('系统错误，请联系管理员','错误提示');
				}
			});
// 			alert(subjectid+"##"+paperid+"$$"+researchid);
			url = 'Teacher_update?id=' + row.id+'&subjectid='+subjectid+'&paperid='+paperid+'&researchid='+researchid;
		}
	}
	
	function saveTeacher() {
	var picLen = uploaderForPic.files.length;
	var outlineLen = uploaderForOutline.files.length;
	var scheduleLen = uploaderForSchedule.files.length;
	var subjectLen = uploaderForSubject.files.length;
	var probjectLen = uploaderForProject.files.length;
	var paperLen = uploaderForPaper.files.length;
//  	alert(picLen+"&&"+outlineLen+"&&"+scheduleLen+"&&+"+subjectLen+"&&"+probjectLen+"&&"+paperLen);
	var valid = $('#teacherfm').form('validate');
		if(valid==true){
			$('#departmentname').val($('#department').combobox('getText'));
			$('#titlename').val($('#title').combobox('getText'));
			$('#jobname').val($('#job').combobox('getText'));
			$('#subjecttypename').val($('#subjecttype').combobox('getText'));
			$('#teacherfm').form('submit', {
    			url : url,
    			onSubmit : function() {
    				return $(this).form('validate');
    			},
    			success : function(result) {
    				if (result != "true") {
    					jAlert('系统错误，请联系管理员', '错误提示');
    				} else {
    					deleteAllUploader();
//     					destroyAllUploader();
    					$('#teacherdlg').dialog('close'); // close the dialog
    					$('#teacherdg').datagrid('reload'); // reload the user data
    				}
    			}
    		});
		if (picLen > 0) {
			uploaderForPic.start();
		}
		if (outlineLen > 0) {
			uploaderForOutline.start();
		}
		if (scheduleLen > 0) {
			uploaderForSchedule.start();
		}
		if (subjectLen > 0) {
			uploaderForSubject.start();
		}
		if (probjectLen > 0) {
			uploaderForProject.start();
		}
		if (paperLen > 0) {
			uploaderForPaper.start();
		}
    	
		}else{
			alert("信息填写不完整");
		}
	            		
// 	        } else {
// 				alert('请先上传数据文件.');
// 			}
	}
	function destroyTeacher() {
		var row = $('#teacherdg').datagrid('getSelected');
		if (row) {
			$.messager.confirm('确认', '是否要删除?', function(r) {
				if (r) {
					$.post('Teacher_delete', {
						id : row.id
					}, function(result) {
// 						alert(result);
						if (result = "true") {
							
						} else {
							jAlert('系统错误，请联系管理员', '错误提示');
						}
					}, 'json');
					$('#teacherdg').datagrid('reload'); // reload the user data
				}
			});
		}
	}
	
	//销毁所有上传控件
	function deleteAllUploader(){
		uploaderForPic.splice(0,10);
		uploaderForOutline.splice(0,10);
		uploaderForSchedule.splice(0,10);
		uploaderForSubject.splice(0,10);
		uploaderForProject.splice(0,10);
		uploaderForPaper.splice(0,10);
	}
	
	//销毁所有上传控件
	function destroyAllUploader(){
		uploaderForPic.destroy();
		uploaderForOutline.destroy();
		uploaderForSchedule.destroy();
		uploaderForSubject.destroy();
		uploaderForProject.destroy();
		uploaderForPaper.destroy();
	}
	
	//隐藏所有上传控件
	function dispalyAllUploader(){
		$('#outlineObj').hide();
		$('#scheduleObj').hide();
		$('#subjectObj').hide();
		$('#projectObj').hide();
		$('#paperObj').hide();
	}
	
	//照片 上传控件##########################################
	var uploaderForPic = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browse',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'pic'
//         	  two: '2',
//         	  three: { //值还可以是一个字面量对象
//         	    a: '4',
//         	    b: '5'
//         	  },
//         	  four: ['6', '7', '8']  //也可以是一个数组
        	},
        filters: {
  		  mime_types : [ //只允许上传图片文件和rar压缩文件
  		    { title : "图片文件", extensions : "jpg,gif,png,bmp" }
  		  ],
  		  max_file_size : '1000kb', //最大只能上传100kb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
	uploaderForPic.init(); //初始化
	
	//绑定文件上传删除事件
	uploaderForPic.bind('FilesRemoved',function(uploader,file){
		$('#file-list').html("");
	});
	
	//绑定文件添加进队列事件
	uploaderForPic.bind('FilesAdded',function(uploader,files){
		$.each(uploader.files, function (i, file) { 
			if (uploader.files.length <= 1) { 
		            return; 
		        } 
		        uploaderForPic.removeFile(file); 
		    });
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;">';
				html += '<input type="hiddent" name="uploader_pic_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_pic_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list');
			!function(i){
				previewImage(files[i],function(imgsrc){
					$('#file-'+files[i].id).append('<img src="'+ imgsrc +'" />');
				})
		    }(i);
		    $('#img_photo').hide();
		}
	});
	
	//教学大纲 上传控件##########################################
	var uploaderForOutline = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browseOutline',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'outline'
        	},
        filters: {
  		  max_file_size : '20mb', //最大只能上传100kb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
 	
// 	uploaderForSubject.init(); //初始化
	//绑定文件添加进队列事件
	uploaderForOutline.bind('FilesAdded',function(uploader,files){
		$.each(uploader.files, function (i, file) { 
			if (uploader.files.length <= 1) { 
		            return; 
		        } 
			uploaderForOutline.removeFile(file); 
		    });
// 		var count = $("#uploader_subject_count").val();
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
// 			count++;
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
				html += '<input type="hiddent" name="uploader_outline_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_outline_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list-outline');
		}
// 		$("#uploader_subject_count").val(count);
	});
	
	//绑定文件上传进度事件
	uploaderForOutline.bind('UploadProgress',function(uploader,file){
		$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
	});
	
	//绑定文件上传删除事件
	uploaderForOutline.bind('FilesRemoved',function(uploader,file){
		$('#file-list-outline').html("");
	});
	
	//清空按钮
	$('#outline-clear-btn').click(function(){
		uploaderForOutline.splice(0,10); ////删除文件按钮
	});
	
	//教学进度表 上传控件##########################################
	var uploaderForSchedule = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browseSchedule',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'schedule'
        	},
        filters: {
  		  max_file_size : '20mb', //最大只能上传100kb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
 	
// 	uploaderForSubject.init(); //初始化
	//绑定文件添加进队列事件
	uploaderForSchedule.bind('FilesAdded',function(uploader,files){
		$.each(uploader.files, function (i, file) { 
			if (uploader.files.length <= 1) { 
		            return; 
		        } 
			uploaderForSchedule.removeFile(file); 
		    });
// 		var count = $("#uploader_subject_count").val();
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
// 			count++;
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
				html += '<input type="hiddent" name="uploader_schedule_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_schedule_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list-schedule');
		}
// 		$("#uploader_subject_count").val(count);
	});
	
	//绑定文件上传进度事件
	uploaderForSchedule.bind('UploadProgress',function(uploader,file){
		$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
	});
	
	//绑定文件上传删除事件
	uploaderForSchedule.bind('FilesRemoved',function(uploader,file){
		$('#file-list-schedule').html("");
	});
	
	//清空按钮
	$('#schedule-clear-btn').click(function(){
		uploaderForSchedule.splice(0,10); ////删除文件按钮
	});
	
	//课程资料 上传控件##########################################
	var uploaderForSubject = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browseSubject',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'subject'
        	},
        filters: {
  		  max_file_size : '20mb', //最大只能上传100kb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
 	
// 	uploaderForSubject.init(); //初始化
	//绑定文件添加进队列事件
	uploaderForSubject.bind('FilesAdded',function(uploader,files){
		$.each(uploader.files, function (i, file) {
			if (uploader.files.length <= 1) { 
		            return; 
		        } 
			uploaderForSubject.removeFile(file); 
		    });
// 		var count = $("#uploader_subject_count").val();
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
// 			count++;
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
				html += '<input type="hiddent" name="uploader_subject_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_subject_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list-subject');
		}
// 		$("#uploader_subject_count").val(count);
	});
	
	//绑定文件上传进度事件
	uploaderForSubject.bind('UploadProgress',function(uploader,file){
		$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
	});
	
	//绑定文件上传删除事件
	uploaderForSubject.bind('FilesRemoved',function(uploader,file){
		$('#file-list-subject').html("");
	});
	
	//清空按钮
	$('#subject-clear-btn').click(function(){
		uploaderForSubject.splice(0,10); ////删除文件按钮
	});


	//立项上传控件###################################################
	var uploaderForProject = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browseProject',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'project'
        	},
        filters: {
  		  max_file_size : '20mb', //最大只能上传20mb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
// 	uploaderForProject.init(); //初始化
	
	//绑定文件添加进队列事件
	uploaderForProject.bind('FilesAdded',function(uploader,files){
		$.each(uploader.files, function (i, file) { 
			if (uploader.files.length <= 1) { 
		            return; 
		        } 
			uploaderForProject.removeFile(file); 
		    });
// 		var count = $("#uploader_project_count").val();
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
// 			count++;
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
				html += '<input type="hiddent" name="uploader_project_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_project_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list-project');
		}
// 		$("#uploader_project_count").val(count);
	});
	
	//绑定文件上传进度事件
	uploaderForProject.bind('UploadProgress',function(uploader,file){
		$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
	});
	
	//绑定文件上传删除事件
	uploaderForProject.bind('FilesRemoved',function(uploader,file){
		$('#file-list-project').html("");
	});
	
	//清空按钮
	$('#project-clear-btn').click(function(){
		uploaderForProject.splice(0,10); ////删除文件按钮
	});
	
	//论文上传控件###################################################
	var uploaderForPaper = new plupload.Uploader({ //实例化一个plupload上传对象
		browse_button : 'browsePaper',
		multi_selection: false,
 		url : 'File_uploadForTeacher',
 		file_data_name : 'fileData',
// 		url : '${request_path}/pupload/upload.php', //服务器端的上传页面地址
        flash_swf_url : '${js_path}/plupload/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : '${js_path}/plupload/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        unique_names : true,  // 上传的文件名是否唯一   
        multipart_params: {
        	  filetype: 'paper'
        	},
        filters: {
  		  max_file_size : '20mb', //最大只能上传100kb的文件
  		  prevent_duplicates : true //不允许队列中存在重复文件
        }
	});
// 	uploaderForPaper.init(); //初始化
	
	//绑定文件添加进队列事件
	uploaderForPaper.bind('FilesAdded',function(uploader,files){
// 		var count = $("#uploader_paper_count").val();
		for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			var file_id = files[i].id;//ID,临时文件名
// 			count++;
			//构造html来更新UI
// 			var html = '<li id="file-' + files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p></li>';
			var html = '<li id="file-' + file_id +'" style="text-align: left;"><p class="file-name">' + file_name + '</p><p class="progress"></p>';
				html += '<input type="hiddent" name="uploader_paper_tmpname" value="' + file_id + '" />';
				html += '<input type="hiddent" name="uploader_paper_name" value="' + file_name + '" /></li>';
			$(html).appendTo('#file-list-paper');
		}
// 		$("#uploader_paper_count").val(count);
	});
	
	//绑定文件上传进度事件
	uploaderForPaper.bind('UploadProgress',function(uploader,file){
		$('#file-'+file.id+' .progress').css('width',file.percent + '%');//控制进度条
	});
	
	//绑定文件上传删除事件
	uploaderForPaper.bind('FilesRemoved',function(uploader,file){
		$('#file-list-paper').html("");
	});

	//清空按钮
	$('#paper-clear-btn').click(function(){
		uploaderForPaper.splice(0,10); ////删除文件按钮
	});
// 	$(function() {
// 		var uploaderQueue = $("#uploaderQueue").pluploadQueue({
// 		runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
// 		url : 'File_uploadForTeacher',
// 		max_file_size : '30mb',
// 		unique_names : true,
// 		chunk_size: '2mb',
// 		// Specify what files to browse for
// // 		filters : [
// // 			{title : "xls, xlsx文档", extensions : "xls,xlsx"}
// // 		],
// 		// Flash settings
// 		flash_swf_url : '${js_path}/plupload/plupload.flash.swf',
// 		// Silverlight settings
// 		silverlight_xap_url : '${js_path}/plupload/plupload.silverlight.xap'
// 		});
		
// 		$("#uploaderQueueProject").pluploadQueue({
// 			runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
// 			url : 'File_uploadForTeacher',
// 			max_file_size : '10mb',
// 			unique_names : true,
// 			chunk_size: '2mb',
// 			// Specify what files to browse for
// //	 		filters : [
// //	 			{title : "xls, xlsx文档", extensions : "xls,xlsx"}
// //	 		],
// 			// Flash settings
// 			flash_swf_url : '${js_path}/plupload/plupload.flash.swf',
// 			// Silverlight settings
// 			silverlight_xap_url : '${js_path}/plupload/plupload.silverlight.xap'
// 			});
		
// 		$("#uploaderQueuePaper").pluploadQueue({
// 			runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
// 			url : 'File_uploadForTeacher',
// 			max_file_size : '10mb',
// 			unique_names : true,
// 			chunk_size: '2mb',
// 			// Specify what files to browse for
// //	 		filters : [
// //	 			{title : "xls, xlsx文档", extensions : "xls,xlsx"}
// //	 		],
// 			// Flash settings
// 			flash_swf_url : '${js_path}/plupload/plupload.flash.swf',
// 			// Silverlight settings
// 			silverlight_xap_url : '${js_path}/plupload/plupload.silverlight.xap'
// 			});
		
// 	});
	$('#teacher_tab').tabs({ 
	    border:false, 
	    onSelect:function(title,index){ 
// 	        alert(title+' is selected'+index); 
	        if(index==0){
	        	uploaderForPic.init();
	        }
			if(index==1){
				uploaderForSubject.init(); //初始化
				uploaderForSchedule.init(); //初始化
				uploaderForOutline.init(); //初始化
	        }
			if(index==2){
				uploaderForProject.init();
			}
			if(index==3){
				uploaderForPaper.init(); //初始化
			}
	    } 
	});
	</script>
	<style type="text/css">
#teacherfm {
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