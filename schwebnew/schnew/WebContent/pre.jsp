<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
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
<link rel="stylesheet" type="text/css" href="${css_path}/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/global.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/1200.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/comments.css"/>
	
<!-- 统一引用 -->
<link rel="stylesheet" type="text/css" href="${css_path}/subindex.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/news.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/schoolEX.css" />
<link rel="stylesheet" type="text/css" href="${css_path}/jqueryUi/jquery-ui.css" />
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.cookie.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.alerts.js"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/jquery.ui.draggable.js"></script>
<%-- <script language="JavaScript" type="text/javascript" src="${js_path}/top.js" charset="UTF-8"></script> --%>
<script language="JavaScript" type="text/javascript" src="${js_path}/footer.js" charset="UTF-8"></script>
<script language="JavaScript" type="text/javascript" src="${js_path}/Calculation.js" charset="UTF-8"></script>
<script>
$(document).ready(function() {
     $("#fontsize").change(
        function()
        {
            $("#articcontentdetail").css({fontSize:this.value});//dom
        }
      )
});

</script>

