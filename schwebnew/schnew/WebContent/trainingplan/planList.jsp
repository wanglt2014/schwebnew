<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%
	// 当前导航栏位置
	request.setAttribute("cur_nav", 5);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="人才培养方案" />
<title>人才培养方案_${sitename}</title>

<link rel="shortcut icon" href="favicon.ico" />
<jsp:include page="../pre.jsp"></jsp:include>

<script language="JavaScript" type="text/javascript">
	$(document).ready(function() {
		var defultId = "${defultId}";
		showContent(defultId);
	});
	function showContent(tempId) {
		var targetPage = 1;
// 		if (!page || (page == '')) {
// 			targetPage = 1;
// 		} else {
// 			targetPage = page;
// 		}
		$.ajax({
			type : 'post',
			url : 'TrainingPlan_showDepDetail',
			data : {
				currentPage : targetPage,
				id : tempId,
			},
			beforeSend : function(html) {
				$.blockUI({
					showOverlay : false,
					message : '数据加载中...',
					css : {
						border : 'none',
						padding : '5px',
						backgroundColor : '#000',
						'-webkit-border-radius' : '10px',
						'-moz-border-radius' : '10px',
						opacity : .5,
						color : '#fff',
						top : '170px',
						left : $(window).width() / 2 + 'px',
						width : '150px',
						height : '20px'
					}
				});
			},
			success : function(html) {
				$.unblockUI();
				$('#news_right_content').html(html);

			},
			error : function() {
				$.unblockUI();
			}
		});
	}
</script>
</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container" style="position: relative;">
		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
		<div style="position: relative; margin: 5px 0px 10px 0px;">
			<div id="index_top">
				<div id="news_left_content">
<%-- 					<c:if test="${!empty(notifylist)}"> --%>
						<div id="right_content_top">
							<ul>
								<li class="normal_title_left"></li>
								<li class="normal_title_right"></li>
								<li class="normal_title_content">
									人才培养方案&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</li>
							</ul>
							<div class="normal_content_top">
								<ul class="news_content">
									<s:iterator var="department" value="tdepartmentList" status="st">
										<li><a href="javascript:void(0);"  onclick="showContent(${department.departmentid});"><s:property
													value="#department.departmentname" /> </a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
<%-- 					</c:if> --%>
				</div>
				<div id="news_right_content"></div>
			</div>
		</div>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</div>
</body>
</html>