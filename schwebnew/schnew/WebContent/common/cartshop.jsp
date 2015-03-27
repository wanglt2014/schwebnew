<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function () {
	//全选
	$("#invert").click(function () {
		if($("#invert").attr("checked")){
			$(".gwc_tb2 input[name=newslist]").each(function () {
				$(this).attr("checked", true);
				var id = $(this).attr("id");
				var productid =id.substring(9,id.length);
				updateCheck(productid,"yes");
			});
		}else{
			$(".gwc_tb2 input[name=newslist]").each(function () {
				$(this).attr("checked", false);
				var id = $(this).attr("id");
				var productid =id.substring(9,id.length);
				updateCheck(productid,"no");
			});
		}
		GetCount();
	});
});
</script>


</head>

<div class="nav2_ico2"></div>
<div class="gwc" id="gwc" style=" margin:auto;">
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb1">
		<tr>
			<td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect" style="display: none;"/></td>
			<td class="tb1_td1"><b>选框</b></td>
			<td class="tb1_td3"><b>当前购物车里面的商品信息</b></td>
			<td class="tb1_td4"><b>单价</b></td>
			<td class="tb1_td5"><b>数量</b></td>
			<td class="tb1_td6"><b>小计</b></td>
			<td class="tb1_td7"><b>操作</b></td>
		</tr>
	</table>
		<input type="text" style="display: none;"id="image_path_url" value="${image_path}" />
	<div  id="shop_cart_items">	   
		<!-- 购物车商品 -->
	</div>
	
	<table cellpadding="0" cellspacing="0" class="gwc_tb3">
		<tr>
			<td class="tb1_td1"></td>
			<td class="tb1_td1"><input id="invert" type="checkbox" /></td>
			<td class="tb3_td1">
				全选
			</td>
			<td class="tb3_td2">已选商品 <label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> 件</td>
			<td class="tb3_td3">合计(不含运费):<span>￥</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
			<td class="tb3_td4"><span id="jz1">结算</span><a href="ShopCart_commit"  style=" display:none;"  class="jz2" id="jz2">结算</a></td>
		</tr>
	</table>

</div>
