<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	String website = url.substring(0, url.indexOf(uri));
	String request_path = website + request.getContextPath();
	String image_path = request_path + "/images/blue-themes";
	String css_path = request_path + "/css/blue-themes";
	String js_path = request_path + "/js";
	request.setAttribute("request_path", request_path);
	request.setAttribute("image_path", image_path);
	request.setAttribute("css_path", css_path);
	request.setAttribute("js_path", js_path);

	// 本页左侧菜单位置
	request.setAttribute("cur_menu", "menu_index");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  name="description"  content="介绍${sitename}团队成员，以及各个成员的职责，分工。" />
<title>团队介绍--${sitename}</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/question.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/team.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/team.js"></script>
<script language="JavaScript" type="text/javascript">
$(document).ready(function(){
	//top menu on hover
	
	var allItems = $('#__hdmenu span');
	allItems.click(function(){
	var link = $(this).parent().attr('link');
	if(link.indexOf('http://') == 0){
	window.open(link);
	} else{
	window.location.href = link;
	}
	});
	}); 
$(function(){
	// build dom
	for(var i = 0; i < team_info.length; i++){
	personData = team_info[i];
	var $div = $('<div id="' + personData.id + '" class="om-ui-team-person"><div>');
	$div.append('<div class="card-bg card-style-' + (i%4+1) + '">');
	$div.append('<div class="intro"><div class="name">' + personData.name + '</div><div class="e-name">' + personData.ename + '</div><div class="title">'+personData.title+'</div></div>');
	$div.append('<div class="person-pic"><a href="#"><img alt="' + personData.name + '" src="${image_path}' + personData.pic + '" /></a></div>');
	$('#om-ui-team').append($div);
// 	var $dialogbox = $('<div target="' + personData.id + '" class="dialog-box"><span class="content">' + personData.say + '</span><div class="dialog-box-before"></div><div class="dialog-box-after"></div></div>');
// 	$('body').append($dialogbox);
	} 
	$('#om-ui-team').append($('<div class="clear-float"></div>'));
	$('.om-ui-team-person').each(function(n){
	$(this).append('<div class="team-info">Software</div>');
	});
	// bind event
	$('.dialog-box').hover(function(){
	// do nothing
	},function(){
	$(this).hide();
	}).click(function(){
	return false;
	});
	$('.om-ui-team-person').hover(function(){
	$('.dialog-box').hide();
	var left = $(this).offset().left + 40;
	var top = $(this).offset().top + 80;
	$('.dialog-box[target="' + this.id + '"]').css({left:left,top:top}).show();
	},function(){
	// do nothing
	}).click(function(){
	return false;
	});
	$(document).click(function(){
	$('.dialog-box').hide();
	});
	setTimeout(function(){$('.dialog-box').hide();},0);
	}); 
</script>

</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container">
		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>

		<div id="content">
			<div class="porductIntro" style="padding: 0 10px; font-size: 14px;">
				<h2>团队介绍</h2>
				<p />
				<div class="split_spx"></div>
				<div class="content" id="__content">
					<div id="om-ui-team">
					</div>
				</div>
			</div>
		</div>


		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>