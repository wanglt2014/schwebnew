/* ********************** 
   Demo Note:  This demo uses a FileProgress class that handles the UI for displaying the file name and percent complete.
   The FileProgress class is not part of SWFUpload.
 ********************** */

/* **********************
 Event Handlers
 These are the custom event handlers to make web application behave when SWFUpload
 completes different tasks.  These aren't part of the SWFUpload package. They are 
 part of the application. Without these none of the actions SWFUpload makes will 
 show up application.
 ********************** */
var applicationuploadpath = "uploadfile";
var numberFilesSelected = 0;
var documentType;
var swfu;	
var serverName,serverIp,restorePath,pwd,account,wordName;
var settings;
$(document).ready(function(){		
	alert(111111111111111111);
	//documentType = $jQuery("#documentType").val();
//	initServerInfo();
	//Init SWFUpload plugin
	settings = {
		flash_url : request_path+"/js/swfupload/swfupload.swf",
//		upload_url: request_path+"/documentAction.do?method=upload&documentType='02'" +"&serverName="+$jQuery("#serverName").val()+"&serverIp="+serverIp+
//					"&restorePath="+$jQuery("#restorePath").val()+"&pwd="+$jQuery("#pwd").val()+"&account="+$jQuery("#account").val(),
		upload_url: "Teacher_upload",
		file_size_limit : "100MB",
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : 100,
		file_queue_limit : 100,
		custom_settings : {
			progressTarget : "progresslist_box"
		},
		debug: false,

		// Button settings
		button_image_url:request_path+"/js/swfupload/XPButtonUploadText_61x22.png",
		button_placeholder_id : "spanButtonPlaceholder",
		button_width : 61,
		button_height : 22,
		button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
		button_cursor : SWFUpload.CURSOR.HAND,
		button_action : SWFUpload.BUTTON_ACTION.SELECT_FILE,	

		// The event handler functions are defined in handlers.js
		//file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete
	};
	swfu = new SWFUpload(settings);
});

function fileQueued(file) {
		wordName = file.name;
		$jQuery("#wordName").val(wordName);
		
}


function fileQueueError(file, errorCode) {
	var progress = new FileProgress(file, this.customSettings.progressTarget,
			this,1);
	$jQuery("#uploadfile").addClass("input_tips");
	try {
		if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
			document.getElementById("uploadfile").value=QUEUE_LIMIT_EXCEEDED_STATUS;
			progress.setText(QUEUE_LIMIT_EXCEEDED_STATUS,QUEUE_LIMIT_EXCEEDED_TIPS);
			return;
		}
		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			document.getElementById("uploadfile").value=FILE_EXCEEDS_SIZE_LIMIT_STATUS;
			progress.setText(FILE_EXCEEDS_SIZE_LIMIT_STATUS,FILE_EXCEEDS_SIZE_LIMIT_TIPS);
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			document.getElementById("uploadfile").value=QUEUE_ZERO_BYTE_FILE_STATUS;
			progress.setText(QUEUE_ZERO_BYTE_FILE_STATUS,QUEUE_ZERO_BYTE_FILE_TIPS);
			break;
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
			document.getElementById("uploadfile").value=INVALID_FILETYPE_STATUS;
			progress.setText(INVALID_FILETYPE_STATUS,INVALID_FILETYPE_TIPS);
			break;
		default:
			if (file !== null) {
				document.getElementById("uploadfile").value=UPLOAD_COMPLETE;
				progress.setText(UNHANDLED_QUEUE_ERROR_STATUS,UNHANDLED_QUEUE_ERROR_TIPS);
			}
			break;
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function openProgressBox() {
	tb_show(POPUP_TITLE,"#TB_inline?height=100&width=700&inlineId=progressBoxContainer",false); 
}

function closePorgressBox() {
	tb_remove();
	//document.getElementById("showUploadControl").style.display="inline";
	//document.getElementById("showUploadControl").value=SHOW_UPLOADING_WINDOW;
}

function fileDialogComplete(numFilesSelected, numFilesQueued,
		totalNumberInTheQueue) {
	try {
		this.addPostParam("uploadpath", applicationuploadpath);
		numberFilesSelected++;
		fileDisplay(numberFilesSelected, this);
		if (numFilesSelected != 0) {
			//$("#showUploadControl").removeAttr("disabled");
			openProgressBox();
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}
}
function fileDisplay(queued, swfinstance) {
	try {
		this.currentfile = swfinstance.getFile(queued - 1);
		var progress = new FileProgress(this.currentfile,
				swfinstance.customSettings.progressTarget, swfinstance, 1);
		if (this.currentfile.filestatus != SWFUpload.FILE_STATUS.QUEUED) {
			progress.setQueuedError();
			progress.setComplete(this.currentfile, true);
			progress.setText(FILE_EXCEEDS_SIZE_LIMIT_STATUS,FILE_EXCEEDS_SIZE_LIMIT_TIPS);
		} else {
			progress.setQueued();
			progress.setText(UPLOAD_READY_STATUS,UPLOAD_READY_TIPS);
		}
	} catch (ex) {

	}
}

function queueComplete(numberUploaded) {
	closePorgressBox();
}

function uploadStart(file) {
	try {
		$jQuery("#uploadfile").removeClass("input_tips");
	} catch (ex) {
	}
	return true;
}

function uploadProgress(file, bytesLoaded, bytesTotal) {
	try {
		var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);
		var progress = new FileProgress(file,
				this.customSettings.progressTarget, this, 1);
		progress.setProgress(percent);
		progress.setText(UPLOAD_PROCESSING_STATUS,UPLOAD_PROCESSING_TIPS);

	} catch (ex) {
		this.debug(ex);
	}
}

function uploadSuccess(file, serverData, receivedResponse) {
	try {
		var progress = new FileProgress(file,
				this.customSettings.progressTarget, this, 1);
		progress.setSuccess();
		progress.setText(UPLOAD_SUCCESS_STATUS,UPLOAD_SUCCESS_TIPS);
		alert(file.name +" "+ UPLOAD_COMPLETE);
		$jQuery("#wordName").val(file.name);
		progress.setComplete(file, true);
		document.getElementById("uploadfile").value=UPLOAD_COMPLETE;
	} catch (ex) {
		this.debug(ex);
	}
	this.startUpload();
}

/*
 * 这个函数是文件上传失败后的处理动作，参数与加载队列失败相同，也是建立progress对象，然后seterror和设置cancelbutton的可用与否
 */
function uploadError(file, errorCode, message) {
	var progress = new FileProgress(file, this.customSettings.progressTarget,
			this, 1);
	$jQuery("#uploadfile").addClass("input_tips");
	try {
		// progress.setError();
		// progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
			document.getElementById("uploadfile").value=UPLOAD_HTTP_ERROR_TIPS;
			progress.setText(UPLOAD_HTTP_ERROR_STATUS,UPLOAD_HTTP_ERROR_TIPS);
			// this.debug("Error Code: HTTP Error, File name: " + file.name + ",
			// Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
			document.getElementById("uploadfile").value=UPLOAD_FAILED_TIPS;
			progress.setText(UPLOAD_FAILED_STATUS,UPLOAD_FAILED_TIPS);
			// this.debug("Error Code: Upload Failed, File name: " + file.name +
			// ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
			document.getElementById("uploadfile").value=IO_ERROR_TIPS;
			progress.setText(IO_ERROR_STATUS,IO_ERROR_TIPS);
			// this.debug("Error Code: IO Error, File name: " + file.name + ",
			// Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
			document.getElementById("uploadfile").value=SECURITY_ERROR_TIPS;
			progress.setText(SECURITY_ERROR_STATUS,SECURITY_ERROR_TIPS);
			// this.debug("Error Code: Security Error, File name: " + file.name
			// + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
			document.getElementById("uploadfile").value=UPLOAD_LIMIT_EXCEEDED_TIPS;
			progress.setText(UPLOAD_LIMIT_EXCEEDED_STATUS,UPLOAD_LIMIT_EXCEEDED_TIPS);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
			document.getElementById("uploadfile").value=FILE_VALIDATION_FAILED_TIPS;
			progress.setText(FILE_VALIDATION_FAILED_STATUS,FILE_VALIDATION_FAILED_TIPS);
			// this.debug("Error Code: File Validation Failed, File name: " +
			// file.name + ", File size: " + file.size + ", Message: " +
			// message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			document.getElementById("uploadfile").value=FILE_CANCELLED_TIPS;
			// If there aren't any files left (they were all cancelled) disable
			// the cancel button
			progress.setText(FILE_CANCELLED_STATUS,FILE_CANCELLED_TIPS);
//			progress.setComplete(file, true);
			progress.setCancelled(isfadein);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			document.getElementById("uploadfile").value=FILE_STOPPED_TIPS;
			progress.setText(UPLOAD_STOPPED_STATUS,FILE_STOPPED_TIPS);
			break;
		default:
			document.getElementById("uploadfile").value=UNHANDLED_ERROR_TIPS;
			progress.setText(UNHANDLED_ERROR_STATUS,UNHANDLED_ERROR_TIPS);
			break;
		}
		return null;
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadComplete(file) {
//	var progress = new FileProgress(file, this.customSettings.progressTarget,
//			this, 1);
//	progress.setComplete(file, true);
}

function addImage(src) {
	var newImg = document.createElement("img");
	newImg.style.margin = "5px";
	document.getElementById("thumbnails").appendChild(newImg);
	if (newImg.filters) {
		try {
			newImg.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 0;
		} catch (e) {
			newImg.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + 0 + ')';
		}
	} else {
		newImg.style.opacity = 0;
	}

	newImg.onload = function() {
		fadeIn(newImg, 0);
	};
	newImg.src = src;
}

function fadeIn(element, opacity) {
	var reduceOpacityBy = 5;
	var rate = 30; // 15 fps

	if (opacity < 100) {
		opacity += reduceOpacityBy;
		if (opacity > 100) {
			opacity = 100;
		}
		if (element.filters) {
			try {
				element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
			} catch (e) {
				element.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + opacity + ')';
			}
		} else {
			element.style.opacity = opacity / 100;
		}
	}
	if (opacity < 100) {
		setTimeout(function() {
			fadeIn(element, opacity);
		}, rate);
	}
	
}

//初始化页面数据信息
function initServerInfo() {
	alert(4555555);
//	var sURL = request_path + "/documentAction.do?method=getServerSetup";
//	// 调用AJAX请求函数
//	$jQuery.ajax({
//		url : sURL,
//		async: false,
//		type : "post",
//		dataType : "json",
//		data : {
//			"documentType" : documentType
//		},
//		success : function(data) {
//			if (data.errorMessage == undefined) {
//				$jQuery("#serverName").val(data.serverName);
//				$jQuery("#serverIp").val(data.serverIp);
//				serverIp = data.serverIp;
//				$jQuery("#restorePath").val(data.restorePath);
//				$jQuery("#pwd").val(data.pwd);
//				$jQuery("#account").val(data.account);
//			} else {
//				alert(data.errorMessage);
//			}
//		},
//		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert("操作失败，可能是网络原因");
//		}
//	});
};