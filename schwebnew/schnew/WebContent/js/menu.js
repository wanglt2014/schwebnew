var editingId;
function edit() {
	if (editingId != undefined) {
		$('#menutg').treegrid('select', editingId);
		return;
	}
	var row = $('#menutg').treegrid('getSelected');
	if (row) {
		editingId = row.id;
		$('#menutg').treegrid('beginEdit', editingId);
	}
}
function clearSystemConstant(){
	$.ajax({
		type : 'post',
		async : false,
		url : 'Cache_clearSystemConstant',
		success : function(data) {
			if(data=="true"){
				jAlert('清除成功！','提示');
			}else{
				jAlert('清除失败！','提示');
			}
		},
		error : function() {
			jAlert('系统错误，请联系管理员','错误提示');
		}
	});
}
function save() {
	if (editingId != undefined) {
		var t = $('#menutg');
		t.treegrid('endEdit', editingId);
		editingId = undefined;

		var rows = t.treegrid('getChildren');
		var ids = 0;
		for ( var i = 0; i < rows.length; i++) {
			var id = parseInt(rows[i].id);
			var menuname = rows[i].text;
			// alert(menuname);
			var menuorder = parseInt(rows[i].menuorder);
			var menuurl = rows[i].menuurl;
			var menulevel = parseInt(rows[i].menulevel);
			var menuparent = parseInt(rows[i].menuparent);
			$.ajax({
				type : 'post',
				url : 'Menu_updateoradd',
				data : {
					id : id,
					menuname : menuname,
					menuorder : menuorder,
					menuurl : menuurl,
					menulevel : menulevel,
					menuparent : menuparent
				},
				success : function(data) {
					if (data == 'false') {
						ids = 1;
					}
				},
				error : function() {
					ids = 1;
				}
			});
		}
		if (ids == 1) {
			jAlert('系统错误，请联系管理员', '错误提示');
		} else {
			$('#tt').tree('reload');
			jAlert('恭喜你，保存成功!', '错误提示');
		}
	}
}
function cancel() {
	if (editingId != undefined) {
		$('#menutg').treegrid('cancelEdit', editingId);
		editingId = undefined;
	}
}
function formatProgress(value) {
	if (value) {
		var s = '<div style="width:100%;border:1px solid #ccc">'
				+ '<div style="width:' + value
				+ '%;background:#cc0000;color:#fff">' + value + '%' + '</div>';
		'</div>';
		return s;
	} else {
		return '';
	}
}
function showemail(id) {
	$('#maildlg').dialog({
		title : '邮件详细内容',
		width : 605,
		height : 515,
		closed : false,
		cache : false,
		href : 'Email_detail?id=' + id + '',
		modal : true
	});
}
// 查询邮箱,查询完成，重新加载datagrid
function queryeamil() {
	var mailto = $('#mailto').val();
	var startdate = $('#startdataemail').datebox('getValue');
	var enddate = $('#enddataemail').datebox('getValue');
	var isactive = $('#emailisactive').combobox('getValue');
	$('#emaildatagrid').datagrid('load', {
		mailto : mailto,
		startdate : $.trim(startdate),
		enddate : $.trim(enddate),
		isactive : isactive
	});
}
function formatMenuid(value, rowData, rowIndex) {
	var s = '<a href="javascript:void(0)" class="easyui-linkbutton" onclick="showemail('
			+ rowData.id + ')">邮件详细内容</a>';
	return s;
}
function onContextMenu(e, row) {
	e.preventDefault();
	$(this).treegrid('select', row.id);
	$('#menumm').menu('show', {
		left : e.pageX,
		top : e.pageY
	});
}
var idIndex = 100;
function append() {
	idIndex++;
	var d2 = new Date();
	var menuname = 'New Task' + idIndex;
	d2.setMonth(d2.getMonth() + 1);
	var node = $('#menutg').treegrid('getSelected');
	$.ajax({
		type : 'post',
		url : 'Menu_updateoradd',
		data : {
			id : "",
			menuname : menuname,
			menuorder : "",
			menuurl : "",
			menulevel : "",
			menuparent : node.id
		},
		success : function(data) {
			if (data == 'true') {
				$('#menutg').treegrid('append', {
					parent : node.id,
					data : [ {
						id : "",
						text : menuname,
						menuurl : "",
						menuorder : "",
						menulevel : "",
						menuparent : node.id
					} ]
				});
				$('#tt').tree('reload');
			} else {
				jAlert('系统错误，请联系管理员', '错误提示');
			}
			;
		},
		error : function() {
			jAlert('系统错误，请联系管理员', '错误提示');
		}
	});

}
function removeIt() {
	var node = $('#menutg').treegrid('getSelected');
	if (node) {
		$('#menutg').treegrid('remove', node.id);
		$.ajax({
			type : 'post',
			url : 'Menu_deleteMenu',
			data : {
				id : node.id,
			},
			success : function(data) {
				if (data == 'false') {
					jAlert('系统错误，请联系管理员', '错误提示');
				} else {
					$('#tt').tree('reload');
					jAlert('恭喜你，删除成功!', '菜单提示');
				}
			},
			error : function() {
				jAlert('系统错误，请联系管理员', '错误提示');
			}
		});
	}
}
function collapse() {
	var node = $('#menutg').treegrid('getSelected');
	if (node) {
		$('#menutg').treegrid('collapse', node.id);
	}
}
function expand() {
	var node = $('#menutg').treegrid('getSelected');
	if (node) {
		$('#menutg').treegrid('expand', node.id);
	}
}

function formatterdateNOhour(val, row) {
	if (val == null || val == "NaN") {
		return "";
	} else {
		var date = new Date(val);
		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
				+ date.getDate();
	}
}

function formatterdate(val, row) {
	if (val == null || val == "NaN") {
		return "";
	} else {
		var date = new Date(val);
		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
				+ date.getDate() + ' ' + date.getHours() + ':'
				+ date.getMinutes();
	}
}
function formatterIsactive(val, row) {
	if (val == "yes") {
		return "已激活";
	} else if (val == "no") {
		return "未激活";
	} else {
		return val;
	}
}
function formatcode(value, rowData, rowIndex) {
	var suppliename = rowData.supplierCode;
	$.ajax({
		type : 'post',
		async : false,
		url : 'Productcategory_querySupplierNameByCode',
		data : {
			code : rowData.supplierCode,
		},
		success : function(data) {
			suppliename = data;
		},
		error : function() {
			suppliename = "查询出错";
		}
	});
	return suppliename;
}

function formatproductcatagroycode(value, rowData, rowIndex) {
	var suppliename = rowData.productcategoryCode;
	$.ajax({
		type : 'post',
		async : false,
		url : 'Productcategory_queryproductcategroyNameByCode',
		data : {
			code : rowData.productcategoryCode,
		},
		success : function(data) {
			suppliename = data;
		},
		error : function() {
			suppliename = "查询出错";
		}
	});
	return suppliename;
}
//function timeStamp2String(time) {
//	if (null == time || time == "NaN" || time == "") {
//		return "";
//	} else {
//		var date = new Date();
//		date.setTime(time);
//		var y = date.getFullYear();
//		var m = date.getMonth() + 1;
//		var d = date.getDate();
//		return m + '/' + d + '/' + y;
//	}
//}

function timeStamp2String(time) {
	if (null == time || time == "NaN" || time == "") {
		return "";
	} else {
		var date = new Date();
		date.setTime(time);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + m + '-' + d;
	}
}

function secondcollapseAll(row, data) {
	$.each(data, function(i, val) {
		$('#menutg').treegrid('collapseAll', data[i].id);
	});
}
