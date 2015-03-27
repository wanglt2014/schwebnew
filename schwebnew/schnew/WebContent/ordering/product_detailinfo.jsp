<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

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

	// 当前导航栏位置
	request.setAttribute("cur_nav", 1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" name="description"
	content="<s:property value="product.productInfo.substring(0,100)" />" />
<title>产品详情_<s:property value="product.productName" />
</title>

<link rel="stylesheet" type="text/css" href="${css_path}/common.css" />
<link rel="stylesheet" type="text/css"
	href="${css_path}/product_search.css" />

<link rel="stylesheet" type="text/css"
	href="${css_path}/jqueryUi/jquery-ui.css" />
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/jquery.blockUI.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/etUtil.js"></script>
<script language="JavaScript" type="text/javascript"
	src="${js_path}/productdetail.js"></script>
<script language="JavaScript" type="text/javascript">
	function productchoose(id) {
		$.ajax({
			type : 'post',
			url : 'ShopCart_addItem',
			data : {
				productid : id
			},
			success : function(data) {
				$("#submitForm").action = 'Ordering_doProductChoose';
				$("#submitForm").submit();
			},
			error : function() {
				jAlert('系统错误，请联系管理员', '购物车提示');
			}
		});
		
	}

/* 	$(document).ready(function() {
		newsSearch();
	});
	function newsSearch(page) {
		var targetPage = '';
		if (!page || (page == '')) {
			targetPage = 1;
		} else {
			targetPage = page;
		}
		$.ajax({
			type : 'post',
			url : 'News_doqueryNews',
			data : {
				currentPage : targetPage
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
				$('#con_menu_2').html(html);

			},
			error : function() {
				$.unblockUI();
			}
		});
	} */
</script>



</head>

<body>
	<div id="fade" class="black_overlay"></div>
	<div class="container">


		<jsp:include page="../top.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>

		<div id="content">
			<form name="submitForm" id="submitForm"
				action="Ordering_doProductChoose">
				<div id="product_sub_content">
					<div class="trade_search_condition">
						<ul>
							<li><div class="logodiv">
									<img src="${image_path}/dinggou.png" />
								</div>
								<div class="logodiv">产品订购</div></li>
						</ul>
					</div>

					<div class="product_detail">
						<div class="ad_left">
							<div>
								<ul>
									<li class="detailtitle1">付费产品在线订购</li>
									<li class="detailtitle2">尊进的用户你好，欢迎你使用网上营业厅在线订购业务!</li>
								</ul>
							</div>
							<div class="split_xpx"></div>
							<div class="detail_center">
								<div class="center_left">
									<img src="${image_path}/${product.productImageUrl}.png"
										class="detail_pic" width="300px;" height="233px;" />

								</div>
								<div class="center_right">
									<div class="center_right_text1">${sitename}付费(产品/业务)在线销售</div>
									<div class="split_ypx"></div>
									<div class="center_right_text2">
										<ul class="ul_prompt_dot">
											<li>产品名称：<s:property value="product.productName" /></li>
										</ul>
									</div>
									<div class="split_ypx"></div>
									<div class="center_right_text3">
										<ul class="ul_prompt_dot">
											<li>产品价格：<span class="productprice"><fmt:formatNumber
														value="${product.productPrice}" type="currency"
														pattern="#0.00" /> </span>&nbsp;元每/月</li>
										</ul>
									</div>
									<div class="split_ypx"></div>
									<div class="choose_btn">
										<input type="text" name="id" id="productid"
											value="${product.id}" style="display: none;" /> <input
											type="button" value="快速购买" class="normal_btn"
											id="confirm_btn" onclick="productchoose(${product.id})" /> <input
											type="button" value="加入购物车" class="normal_btn"
											id="confirm_shop_cart" onclick="addcart()" />
									</div>

								</div>
							</div>
							<div class="detail_down">
								<div id="tab_usual1" class="cc_tabTitle"
									style="margin-top: -12px;">
									<ul class="cc_tabTitleFix" style="margin-top: 12px">
										<li><a id="menu1" onclick="setTab('menu',1,4)"
											class="hover selected">产品详情</a></li>
										<li><a id="menu2" onclick="setTab('menu',2,4)"
											class="hover">销售列表</a></li>
										<li><a id="menu3" onclick="setTab('menu',3,4)"
											class="hover">评论列表</a></li>
										<li><a id="menu4" onclick="setTab('menu',4,4)"
											class="hover">售后保障</a></li>
										<div id="tab_addcart" class="tab_addcart">
											<input type="button" value="快速购买" class="normal_btn"
												id="confirm_btn" onclick="productchoose(${product.id})" />
										</div>
									</ul>
								</div>
								<div id="con_menu_1" class="hover">
								<div id="tab_split_step" class="tab_split_step">
										  <ul >
										  	<li>
											 产品介绍
											</li>
										  </ul>
									  </div>
									<div class="detailtitle3">${product.productInfo}</div>
								</div>
								<div id="con_menu_2" style="float: left;" class="hover">
									<div class="tab_div">
									<div id="tab_split_step" class="tab_split_step">
										  <ul >
										  	<li>
											 销售数据
											</li>
										  </ul>
									  </div>
										<div class="content">
											<ul class="cc_cpList">
												<li class="cpList_qy1"><span>大文件</span>
													<p>稳定快速的大文件上传，支持多浏览器不限文件大小上传，文件夹上传，断点续传。</p></li>
												<li class="cpList_qy2"><span>推送准</span>
													<p>及时精准的文件共享推送，支持外链功能，文件可按权限共享给对方（如，只能查看，不能下载，不能删除等）</p></li>
												<li class="cpList_qy3"><span>管理细</span>
													<p>灵活多样的组织架构管理，可按用户的组织架构按部门职位划分文件权限。</p></li>
												<li class="cpList_qy4"><span>多层应用</span>
													<p>精细完整的帐号多层应用，系统分公共文件管理员、文件共享审核员、后台管理员，子帐号等多层用户。</p></li>
												<li class="cpList_qy5"><span>操作简单</span>
													<p>丰富超强的易用功能，支持OFFCIE、PDF、图片在线编辑、保存，版本管理等。</p></li>
												<li class="cpList_qy6"><span>无限空间</span>
													<p>海量电子文档存储，支持单服务器多分区、多硬盘；多服务器分布式数据存储，硬件无限扩展。</p></li>
												<li class="cpList_qy7"><span>多重兼容</span>
													<p>广泛完美的兼容性，兼容主流浏览器，客户端兼容所有PC操作系统、手机操作系统等移动设备。</p></li>
												<li class="cpList_qy8"><span>安全可靠</span>
													<p>文件可按编辑或者组织架构权限进行转发，存储可按级别分配存储区域。</p></li>
												<li class="cpList_qy9"><span>用户众多</span>
													<p>庞大忠实的用户群体，超300万装机量，正式服务用户超3万台。</p></li>

											</ul>

										</div>
										<div class="clear"></div>
									</div>
								</div>
								<div id="con_menu_3" style="float: left;"
									class="hover">
									<div  class="tab_div">
									<div id="tab_split_step" class="tab_split_step">
										  <ul >
										  	<li>
											 用户评论
											</li>
										  </ul>
									  </div>
									<div class="item">
										<div class="user">
											<div class="u-icon">
												<a target="_blank"> <img width="50" height="50"
													src="${image_path}/touxiang.jpg" /> </a>
											</div>
											<div class="u-name">
												<a target="_blank" href="#"> jd139832lbn </a>
											</div>
											<span class="u-level"><span style="color: ">
													银牌会员</span> </span>
										</div>
										<div class="i-item">
											<div class="o-topic">
												<span><a target="_blank" class="date-comment">留言日期:2014-05-30
														16:12</a><em class="fr hl_blue"></em> </span> <strong class="topic"><a
													target="_blank" href="#"></a> </strong>
											</div>
											<div class="comment-content">价格便宜，质量也不错，外观漂亮，送货、安装快速。</div>
											<div class="btns">
												<a href="#none" class="btn-reply btn-toggle fr">回复(0)</a> <a
													href="#none" class="btn-agree" name="agree">顶(0)</a> <a
													href="#none" class="btn-agree" name="noagree">踩(0)</a>
											</div>
										</div>
										<div class="corner tl"></div>
									</div>
									<div class="item">
										<div class="user">
											<div class="u-icon">
												<a target="_blank"> <img width="50" height="50"
													src="${image_path}/touxiang.jpg" /> </a>
											</div>
											<div class="u-name">
												<a target="_blank" href="#"> jd139832lbn </a>
											</div>
											<span class="u-level"><span style="color: ">
													银牌会员</span> </span>
										</div>
										<div class="i-item">
											<div class="o-topic">
												<span><a target="_blank" class="date-comment">留言日期:2014-05-30
														16:12</a><em class="fr hl_blue"></em> </span> <strong class="topic"><a
													target="_blank" href="#"></a> </strong>
											</div>
											<div class="comment-content">价格便宜，质量也不错，外观漂亮，送货、安装快速。</div>
											<div class="btns">
												<a href="#none" class="btn-reply btn-toggle fr">回复(0)</a> <a
													href="#none" class="btn-agree" name="agree">顶(0)</a> <a
													href="#none" class="btn-agree" name="noagree">踩(0)</a>
											</div>
										</div>
										<div class="corner tl"></div>
									</div>
									<div class="item">
										<div class="user">
											<div class="u-icon">
												<a target="_blank"> <img width="50" height="50"
													src="${image_path}/touxiang.jpg" /> </a>
											</div>
											<div class="u-name">
												<a target="_blank" href="#"> jd139832lbn </a>
											</div>
											<span class="u-level"><span style="color: ">
													银牌会员</span> </span>
										</div>
										<div class="i-item">
											<div class="o-topic">
												<span><a target="_blank" class="date-comment">留言日期:2014-05-30
														16:12</a><em class="fr hl_blue"></em> </span> <strong class="topic"><a
													target="_blank" href="#"></a> </strong>
											</div>
											<div class="comment-content">价格便宜，质量也不错，外观漂亮，送货、安装快速。</div>
											<div class="btns">
												<a href="#none" class="btn-reply btn-toggle fr">回复(0)</a> <a
													href="#none" class="btn-agree" name="agree">顶(0)</a> <a
													href="#none" class="btn-agree" name="noagree">踩(0)</a>
											</div>
										</div>
										<div class="corner tl"></div>
									</div>
									<div class="item">
										<div class="user">
											<div class="u-icon">
												<a target="_blank"> <img width="50" height="50"
													src="${image_path}/touxiang.jpg" /> </a>
											</div>
											<div class="u-name">
												<a target="_blank" href="#"> jd139832lbn </a>
											</div>
											<span class="u-level"><span style="color: ">
													银牌会员</span> </span>
										</div>
										<div class="i-item">
											<div class="o-topic">
												<span><a target="_blank" class="date-comment">留言日期:2014-05-30
														16:12</a><em class="fr hl_blue"></em> </span> <strong class="topic"><a
													target="_blank" href="#"></a> </strong>
											</div>
											<div class="comment-content">价格便宜，质量也不错，外观漂亮，送货、安装快速。</div>
											<div class="btns">
												<a href="#none" class="btn-reply btn-toggle fr">回复(0)</a> <a
													href="#none" class="btn-agree" name="agree">顶(0)</a> <a
													href="#none" class="btn-agree" name="noagree">踩(0)</a>
											</div>
										</div>
										<div class="corner tl"></div>
									</div>
									</div>
								</div>
								<div id="con_menu_4" class="hover" style="float: left;">
								<div  class="tab_div">
								<div id="tab_split_step" class="tab_split_step">
										  <ul >
										  	<li>
											 售后保障
											</li>
										  </ul>
									  </div>
									<div class="item-detail">
										本产品全国联保，享受三包服务，质保期为：一年质保<br>如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！<br>
												<br>售后服务电话：400-830-8300<br>品牌官方网站：<a
														target="_blank" href="http://www.huawei.com/cn/">http://www.huawei.com/cn/</a>
									</div>
									<div id="promises">
										<strong>服务承诺：</strong><br>
											${sitename}向您保证所售商品均为正品行货，京东自营商品开具机打发票或电子发票。凭质保证书及${sitename}发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由京东联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。${sitename}还为您提供具有竞争力的商品价格和<a
											target="_blank" href="http://www.jd.com/help/kdexpress.aspx">运费政策</a>，请您放心购买！
											<br> <br>
													注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！



											
									</div>
									<div id="state">
										<strong>权利声明：</strong><br>${sitename}上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是${sitename}重要的经营资源，未经许可，禁止非法转载使用。
											<p>
												<b>注：</b>本站商品信息均来自于厂商，其真实性、准确性和合法性由信息拥有者（厂商）负责。本站不提供任何保证，并不承担任何法律责任。
											</p>
									</div>
								</div>
								</div>
							</div>

						</div>

					</div>
				</div>
			</form>
		</div>

		<div id="floatOrder"></div>
		<jsp:include page="../bottom.jsp"></jsp:include>

	</div>
</body>
</html>