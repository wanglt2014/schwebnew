<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- 左侧菜单 -->
<div id="menu">
	<ul>
		<li id="menu_setting" class="menu_item ${cur_menu eq 'menu_setting' ? 'menu_focus' : ''}">个人资料</li>
		<li id="menu_balance" class="menu_item ${cur_menu eq 'menu_balance' ? 'menu_focus' : ''}">我的订单</li>
		<li id="menu_updatepasswd" class="menu_item ${cur_menu eq 'menu_updatepasswd' ? 'menu_focus' : ''}">修改密码</li>
		
	</ul>
</div>
<!-- 左侧菜单 -->