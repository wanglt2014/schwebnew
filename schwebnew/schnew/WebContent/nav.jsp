<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<link rel="shortcut icon" href="favicon.ico" />
<!-- nav导航  etUtil.js-->
<div id="nav">
	<ul>
		<li class="nav_title ${cur_nav eq 0 ? 'nav_focus' : ''}" id="nav_link_index">首页</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 1 ? 'nav_focus' : ''}" id="nav_link_tongzhi">教务教学通知</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 2 ? 'nav_focus' : ''}" id="nav_link_zhidu">教学规章制度</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 3 ? 'nav_focus' : ''}" id="nav_link_download">教学资料下载</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 4 ? 'nav_focus' : ''}" id="nav_link_teacher">师资队伍</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 5 ? 'nav_focus' : ''}" id="nav_link_plan">人才培养方案</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 6 ? 'nav_focus' : ''}" id="nav_link_result">人才培养成果</li><li class="nav_split"></li>
		<li class="nav_title ${cur_nav eq 7 ? 'nav_focus' : ''}" id="nav_link_bbs">论坛</li>
	</ul>
</div>
<!-- nav导航 -->
<%-- <jsp:include page="common/customer.jsp"></jsp:include> --%>
