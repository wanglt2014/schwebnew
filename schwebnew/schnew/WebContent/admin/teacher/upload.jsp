<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", -10);
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

<html> 
<head><title>test</title> 

<style type="text/css">@import url(${request_path}/plupload/js/jquery.plupload.queue/jquery.plupload.queue.css);</style>
<script src="${request_path}/js/jquery.js" type="text/javascript"></script> 
<script type="text/javascript" src="${request_path}/plupload/js/plupload.full.js"></script>
<script type="text/javascript" src="${request_path}/plupload/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="${request_path}/plupload/js/i18n/cn.js"></script>
<script type="text/javascript">
// Convert divs to queue widgets when the DOM is ready
	$(function() {
		$("#uploader").pluploadQueue({
			// General settings
			runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
			url : 'FileUpload.action',
			max_file_size : '10mb',
			unique_names : true,
			chunk_size: '2mb',
			// Specify what files to browse for
			filters : [
				{title : "xls, xlsx文档", extensions : "xls,xlsx"}
			],
	
			// Flash settings
			flash_swf_url : '/example/plupload/js/plupload.flash.swf',
			// Silverlight settings
			silverlight_xap_url : '/example/plupload/js/plupload.silverlight.xap'
		});
		$('form').submit(function(e) {
	        var uploader = $('#uploader').pluploadQueue();
	        if (uploader.files.length > 0) {
	            // When all files are uploaded submit form
	            uploader.bind('StateChanged', function() {
	                if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
	                    $('form')[0].submit();
	                }
	            });
	            uploader.start();
	        } else {
				alert('请先上传数据文件.');
			}
	        return false;
    	});
	});
	
	
</script>

</head>

<body>
	<div>
		<div style="width: 750px; margin: 0px auto">
			<form id="formId" action="Submit.action" method="post">
				<div id="uploader">
					<p>您的浏览器未安装 Flash, Silverlight, Gears, BrowserPlus 或者支持 HTML5 .</p>
				</div>
				<input type="submit" value="完成"/>
			</form>
		</div>
	</div>
</body>

</html>