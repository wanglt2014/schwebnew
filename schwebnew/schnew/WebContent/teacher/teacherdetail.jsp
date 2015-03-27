<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String request_path = request.getContextPath();
	// 当前导航栏位置
	request.setAttribute("cur_nav", 4);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>教务教学通知_${tTeacherdetail.teachername}</title>
<link rel="shortcut icon" href="favicon.ico" />
<jsp:include page="../pre.jsp"></jsp:include>
<%-- <script language="JavaScript" type="text/javascript" --%>
<%-- 	src="${js_path}/fileUploadHandle.js"></script> --%>
  <script type="text/javascript">
//   $(document).ready(function(){
//     $("#dialog").dialog();
//   });
  </script>
<style type="text/css">
.container {width: 100%;}
.photo { width: 40%;position:absolute; text-align: right;height: 300px;height:auto;}
.content_left {float: left;text-align: center; margin-left: 45%; width: 45%;}
.content_all {width: 80%;text-align: center; position: absolute;margin-left: 10%;}
.base_info{margin-top: 10px;text-align: center;}
.div_baseinfo{font-size: 14px;height: 100%;height: auto;min-height: 350px;}
.baseInfo{width: 100%;height: 100%;height: auto;}
.ul_teacher{list-style:disc; !important;}
td.p20{width: 20%;height: 30px;}
td.p15{width: 15%;height: 30px;}
</style>
</head>

<body >
	<div id="fade" class="black_overlay"></div>
	<div class="container" style="position: relative;">

		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>


		<div style="position: relative; margin: 5px 0px 10px 0px; height: auto;height:100%;" >
			<div id="index_top">

				<div id="news_right_content_detail" >
					<div class="one_artic_detail" >
<!-- 						<div class="title_detail_nolist" align="center"> -->
<%-- 							<b style="font-size: 15px; font-family: sans-serif;"><c:out --%>
<%-- 									value="${tTeacherdetail.teachername}" /> </b> --%>
<!-- 						</div> -->
<!-- 						<div class="artic_author_detail" align="center"> -->
<!-- 							作者: -->
<%-- 							<c:out value="${tTeacherdetail.author}" /> --%>
<!-- 							时间: -->
<%-- 							<c:out value="${tTeacherdetail.createdate}" /> --%>
<!-- 							<div class="bdsharebuttonbox" style="text-align: right;"> -->
<%-- 								<label for="fontsize">字体大小:</label> <select id="fontsize"> --%>
<!-- 									<option value="12px">小号</option> -->
<!-- 									<option value="14px">较小</option> -->
<!-- 									<option value="15px" selected="selected">中号</option> -->
<!-- 									<option value="18px">较大</option> -->
<!-- 									<option value="24px">大号</option> -->
<%-- 								</select> --%>
<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						<div class="normal_summary"> -->
<!-- 							描述： -->
<%-- 							<c:out value="${bsArticledetail.articlesummary}" escapeXml="false" /> --%>
<!-- 						</div>  -->
						<div class="div_baseinfo">
							<h3 class="title_teacher">基本信息</h3>
							<hr class="line_teacher" />
<%-- 							<c:out value="${bsArticledetail.content}" escapeXml="false" /> --%>
<%-- 							<s:property value="tTeacherdetail.iimageurll"/> --%>
<%-- 							<div align="center" style="width: 100%"><img src="<s:property value="tTeacherdetail.iimageurll"/>" WIDTH="200" HEIGHT="200" BORDER="0" alt=""/></div> --%>
							<div class="baseInfo">
								<div class="content_left">
								<div style="margin-top: 20px;" >
	<!-- 							<label>姓名:</label>  -->
								<h1><s:property value="tTeacherdetail.teachername"/></h1>
								<div class="base_info">
								<s:property value="tTeacherdetail.titlename"/>
								<s:if test="tTeacherdetail.tutorType==1">硕导</s:if>
								<s:else>博导</s:else>
								</div>
								<div class="base_info">
								<s:property value="tTeacherdetail.departmentname"/> 专业
								</div>
								<div class="base_info">
								<s:property value="tTeacherdetail.introduction"/>
								</div>
	<%-- 							<div><s:property value="tTeacherdetail.birthday"/></div> --%>
								</div>
								</div>
								<div id="photo" class="photo">
								<img class="img_photo" src="<s:property value="tTeacherdetail.iimageurll"/>" alt=""/>
								</div>
							</div>
<!-- 							<div id="dialog" title="Dialog Title">I'm in a dialog</div> -->
<!-- 						<div style="height:1px; margin-top:-1px;clear: both;overflow:hidden;"></div> -->
						</div>
						<s:if test="tSubjectDTO.subjectname!=null">
						<div class="div_baseinfo">
							<h3 class="title_teacher">讲授课程资料</h3>
							<hr class="line_teacher" />
							<div  class="baseInfo">
								<div class="content_all">
								<div style="margin-top: 20px;" >
								<table style="width: 100%;">
								<tr><th>课程名称</th><th>课程性质</th><th>教学大纲</th><th>教学进度表</th><th>课程资料</th></tr>
								<tr>
								<td class="p20">
								<i class="point">•</i>&nbsp;<s:property value="tSubjectDTO.subjectname"/></td>
								<td class="p20"><s:property value="tSubjectDTO.subjecttypename"/></td>
								<td class="p20">
								<s:if test="tSubjectDTO.subjectoutlinePath!=null">
								<a href="<%=request_path %>/${tSubjectDTO.subjectoutlinePath}">[教学大纲]</a>
								</s:if>
								<s:else></s:else>
								</td>
								<td class="p20">
								<s:if test="tSubjectDTO.subjectschedulePath!=null">
								<a href="<%=request_path %>/${tSubjectDTO.subjectschedulePath}">[教学进度表]</a>
								</s:if>
								<s:else></s:else>
								</td>
								<td class="p20">
								<s:if test="tSubjectDTO.subjectinfoPath!=null">
								<a href="<%=request_path %>/${tSubjectDTO.subjectinfoPath}">[课程资料]</a>
								</s:if>
								<s:else></s:else>
								</td>
								</tr>
								</table>
<!-- 								<ul class="ul_teacher"> -->
<%-- 								<li><i class="point">•</i>&nbsp;<s:property value="tSubject.subjectname"/>&nbsp;<s:property value="tSubject.subjecttypename"/>&nbsp;<a href="">[教学大纲]</a><a href="">[教学进度表]</a><a href="">[课程资料]</a></li> --%>
<!-- 								</ul> -->
								</div>
								</div>
							</div>
<!-- 							<div id="dialog" title="Dialog Title">I'm in a dialog</div> -->
<!-- 						<div style="height:1px; margin-top:-1px;clear: both;overflow:hidden;"></div> -->
						</div>
						</s:if>
						
						<s:if test="tResearchDTO.researchname!=null">
						<div class="div_baseinfo" >
							<h3 class="title_teacher">立项信息</h3>
							<hr class="line_teacher" />
							<div  class="baseInfo">
								<div class="content_all">
								<div style="margin-top: 20px;" >
								<table style="width: 100%;">
								<tr><th>项目名称</th><th>项目编号</th><th>项目级别</th><th>项目主持人</th><th>项目参与者</th><th>立项申请书电子版</th></tr>
								<tr>
								<td class="p15">
								<i class="point">•</i>&nbsp;<s:property value="tResearchDTO.researchname"/></td>
								<td class="p15"><s:property value="tResearchDTO.researchno"/></td>
								<td class="p15"><s:property value="tResearchDTO.researchlevel"/></td>
								<td class="p15"><s:property value="tResearchDTO.researchhost"/></td>
								<td class="p15"><s:property value="tResearchDTO.researchactor"/></td>
								<td class="p15">
								<s:if test="tSubjectDTO.subjectinfoPath!=null">
								<a href="<%=request_path %>/${tSubjectDTO.subjectinfoPath}">[立项申请书电子版]</a>
								</s:if>
								<s:else></s:else>
								</td>
								</tr>
								</table>
								</div>
								</div>
							</div>
						</div>
						</s:if>
						
						<s:if test="tResearchDTO.researchname!=null">
						<div class="div_baseinfo" >
							<h3 class="title_teacher">论文信息</h3>
							<hr class="line_teacher" />
							<div  class="baseInfo">
								<div class="content_all">
								<div style="margin-top: 20px;" >
								<table style="width: 100%;">
								<tr><th>论文名称</th><th>作者排序</th><th>期刊名称</th><th>刊登年份</th><th>杂志期号</th><th>论文电子版</th></tr>
								<tr>
								<td class="p15">
								<i class="point">•</i>&nbsp;<s:property value="tPaperDTO.papername"/></td>
								<td class="p15"><s:property value="tPaperDTO.paperauthor"/></td>
								<td class="p15"><s:property value="tPaperDTO.papernotename"/></td>
								<td class="p15"><s:property value="tPaperDTO.papernoteyear"/></td>
								<td class="p15"><s:property value="tPaperDTO.papernoteno"/></td>
								<td class="p15">
								<s:if test="tPaperDTO.paperdownloadPath!=null">
								<a href="<%=request_path %>/${tPaperDTO.paperdownloadPath}">[论文电子版]</a>
								</s:if>
								<s:else></s:else>
								</td>
								</tr>
								</table>
								</div>
								</div>
							</div>
						</div>
						</s:if>
						
						
						<div>
<%-- 						<s:if test="bsArticledetail.download.fileshowpath!='' and bsArticledetail.download.fileshowpath!=null"> --%>
<%-- 						<a href="<%=request_path %>/${bsArticledetail.download.fileshowpath}" id="filePath" title="" ><c:out value="${bsArticledetail.download.filename}" /></a> --%>
<%-- 						</s:if> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
			<%-- <input type="text" id="wordName" name="wordName"  style="display:none">
			 <input type="text" id="documentType" name="documentType" style="display:none">
			 <input type="text" id="serverName" name="serverName" style="display:none">
			 <input type="text" id="serverIp" name="serverIp" style="display:none">
			 <input type="text" id="restorePath" name="restorePath" value="${bsArticledetail.download.filepath}" style="display:none">
			 <input type="text" id="pwd" name="pwd" style="display:none">
			 <input type="text" id="account" name="account" style="display:none"> --%>
		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>