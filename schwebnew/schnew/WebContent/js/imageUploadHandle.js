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

window.onload=function(){
	var swfu;
	//Init SWFUpload plugin
	var settings = {
		flash_url : webpath+"/view/mmccframework/plugin/swfupload/swfupload.swf",
		upload_url: webpath+"/UploadFiles.do",
		file_size_limit : "10MB",
		file_types : "*.jpg",
		file_types_description : FILE_TYPE_IMAGE,
		file_upload_limit : 0,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "progresslist_box"
		},
		debug: false,

		// Button settings
		button_image_url:webpath+"/view/mmccframework/plugin/swfupload/XPButtonUploadText_61x22.png",
		button_placeholder_id : "spanButtonPlaceholder",
		button_width : 61,
		button_height : 22,
		button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
		button_cursor : SWFUpload.CURSOR.HAND,
		button_action : SWFUpload.BUTTON_ACTION.SELECT_FILE,	

		// The event handler functions are defined in handlers.js
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
};

function fileQueueError(file, errorCode) {
	var progress = new FileProgress(file, this.customSettings.progressTarget,
			this, 1);
	try {
		if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
			progress.setText(QUEUE_LIMIT_EXCEEDED_STATUS,
					QUEUE_LIMIT_EXCEEDED_TIPS);
			return;
		}
		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			progress.setText(FILE_EXCEEDS_SIZE_LIMIT_STATUS,
					FILE_EXCEEDS_SIZE_LIMIT_TIPS);
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			progress.setText(QUEUE_ZERO_BYTE_FILE_STATUS,
					QUEUE_ZERO_BYTE_FILE_TIPS);
			break;
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
			progress.setText(INVALID_FILETYPE_STATUS, INVALID_FILETYPE_TIPS);
			break;
		default:
			if (file !== null) {
				progress.setText(UNHANDLED_QUEUE_ERROR_STATUS,
						UNHANDLED_QUEUE_ERROR_TIPS);
			}
			break;
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function openProgressBox() {
	tb_show(POPUP_TITLE,
			"#TB_inline?height=100&width=700&inlineId=progressBoxContainer",
			false);
}

function closePorgressBox() {
	tb_remove();
}

function fileDialogComplete(numFilesSelected, numFilesQueued,
		totalNumberInTheQueue) {
	try {
		this.addPostParam("uploadpath", applicationuploadpath);
		numberFilesSelected++;
		fileDisplay(numberFilesSelected, this);
		if (numFilesSelected != 0) {
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
			progress.setText(FILE_EXCEEDS_SIZE_LIMIT_STATUS,
					FILE_EXCEEDS_SIZE_LIMIT_TIPS);
		} else {
			progress.setQueued();
			progress.setText(UPLOAD_READY_STATUS, UPLOAD_READY_TIPS);
		}
	} catch (ex) {

	}
}

function queueComplete(numberUploaded) {
	var s;
	alert(numberUploaded
			+ " "
			+ (s = ((numberUploaded === 0 || numberUploaded === 1) ? FILE
					: FILES)) + " " + UPLOAD_COMPLETE);
	closePorgressBox();
}

function uploadStart(file) {
	try {
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
		progress.setText(UPLOAD_PROCESSING_STATUS, UPLOAD_PROCESSING_TIPS);

	} catch (ex) {
		this.debug(ex);
	}
}

function uploadSuccess(file, serverData, receivedResponse) {
	try {
		var progress = new FileProgress(file,
				this.customSettings.progressTarget, this, 1);
		var src = webpath + "/" + applicationuploadpath + "/" + file.name;
		progress.setSuccess();
		progress.setText(UPLOAD_SUCCESS_STATUS, UPLOAD_SUCCESS_TIPS);
		jQuery
				.ajax( {
					url : webpath
							+ "/getUploadedImages.do?filename=" + file.name,
					type : "post",
					async : false,
					dataType : "text",
					success : function(msg) {
						if (msg === src) {
							document.getElementById("image").style.display="inline";
							document.getElementById("image").src=msg;

						} else {
							document.getElementById("image").style.display="inline";
							document.getElementById("image").src=src;
						}
						
					}
				});
	$jQuery("#uploadImage").attr("value",file.name);
	$jQuery("#uploadImage").attr("title",file.name);
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
	try {
		// progress.setError();
		// progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
			progress.setText(UPLOAD_HTTP_ERROR_STATUS, UPLOAD_HTTP_ERROR_TIPS);
			// this.debug("Error Code: HTTP Error, File name: " + file.name + ",
			// Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
			progress.setText(UPLOAD_FAILED_STATUS, UPLOAD_FAILED_TIPS);
			// this.debug("Error Code: Upload Failed, File name: " + file.name +
			// ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
			progress.setText(IO_ERROR_STATUS, IO_ERROR_TIPS);
			// this.debug("Error Code: IO Error, File name: " + file.name + ",
			// Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
			progress.setText(SECURITY_ERROR_STATUS, SECURITY_ERROR_TIPS);
			// this.debug("Error Code: Security Error, File name: " + file.name
			// + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
			progress.setText(UPLOAD_LIMIT_EXCEEDED_STATUS,
					UPLOAD_LIMIT_EXCEEDED_TIPS);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
			progress.setText(FILE_VALIDATION_FAILED_STATUS,
					FILE_VALIDATION_FAILED_TIPS);
			// this.debug("Error Code: File Validation Failed, File name: " +
			// file.name + ", File size: " + file.size + ", Message: " +
			// message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			// If there aren't any files left (they were all cancelled) disable
			// the cancel button
			progress.setText(FILE_CANCELLED_STATUS, FILE_CANCELLED_TIPS);
			progress.setComplete(file, true);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			progress.setText(UPLOAD_STOPPED_STATUS, FILE_STOPPED_TIPS);
			break;
		default:
			progress.setText(UNHANDLED_ERROR_STATUS, UNHANDLED_ERROR_TIPS);
			break;
		}
		return null;
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadComplete(file) {
	var progress = new FileProgress(file, this.customSettings.progressTarget,
			this, 1);
	progress.setComplete(file, true);
	this.startUpload();
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
	AutoImgSize(newImg, "90px", "90px");
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

function AutoImgSize(thisImg, scaleWidth, scaleHeight) {
	var imgWidth = thisImg.width;
	var imgHeight = thisImg.height;
	var WH = imgWidth / imgHeight;

	if (imgWidth > imgHeight) {
		thisImg.width = scaleWidth;
		thisImg.height = scaleWidth / WH;
	} else {
		thisImg.height = scaleHeight;
		thisImg.width = scaleHeight * WH;
	}

	if (thisImg.width == 0 || thisImg.height == 0) {
		thisImg.width = scaleWidth;
		thisImg.height = scaleHeight;
	}
}