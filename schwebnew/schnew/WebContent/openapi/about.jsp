<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<div class="platform-intro">
		<h2 style="margin: 10px 0; font-size: 20px;">
			Cus开放平台<sup>Beta</sup>
		</h2>
		<ul style="margin-left: 10px;">
			<li>一、采用 <a href="#" target="_blank">OAuth2 协议</a> 认,基于http协议通信证</li>
			<li>二、Cus系统<a href="#" target="_blank">开放 接口</a> 如下:</li>
		</ul>
	<table class="doc-table">
<tbody><tr>
<th><strong>Name</strong></th>
<th><strong>Type</strong></th>
<th><strong>Description</strong></th>
<th><strong>Default</strong></th>
</tr>
<tr>
<td>id</td>
<td>string</td>
<td>The id attribute of tab panel.</td>
<td>null</td>
</tr>
<tr>
<td>title</td>

<td>string</td>
<td>The tab panel title text.</td>
<td></td>
</tr>
<tr>
<td>content</td>
<td>string</td>
<td>The tab panel content.</td>
<td></td>
</tr>
<tr>
<td>href</td>

<td>string</td>
<td>A URL to load remote content to fill the tab panel.</td>
<td>null</td>
</tr>
<tr>
<td>cache</td>
<td>boolean</td>
<td>True to cache the tab panel, valid when href property is setted.</td>
<td>true</td>
</tr>

<tr>
<td>iconCls</td>
<td>string</td>
<td>An icon CSS class to show on tab panel title.</td>
<td>null</td>
</tr>
<tr>
<td>width</td>
<td>number</td>
<td>The width of tab panel.</td>

<td>auto</td>
</tr>
<tr>
<td>height</td>
<td>number</td>
<td>The height of tab panel.</td>
<td>auto</td>
</tr>
<tr>
<td>collapsible</td>
<td>boolean</td>
<td>True to allow tab panel to be collapsed.
</td><td>false</td>
</tr>
</tbody></table>
		<h2 style="margin: 10px 0; font-size: 20px;">API 使用条款</h2>
		<ul style="margin-left: 10px;">
			<li>1、CUS 用户是资源的拥有者，需尊重和保护用户的权益。</li>
			<li>2、不能在应用中使用 CUS 的名称。</li>
			<li>3、未经用户允许，不准爬取或存储用户的资源。</li>
			<li>4、禁止滥用 API，请求频率过快将导致请求终止。</li>
			<li>最终解释权归 CUS 所有</li>
		</ul>
		<br>
		<h2 style="margin: 10px 0; font-size: 20px;">
			<strong>OAuth</strong>2 认证基本流程
		</h2>
		<img src="${image_path}/oauth2.jpg">
		<ul style="margin-left: 10px;">
			<li>图(2) OAuth2 获取 AccessToken 步骤说明：</li>
			<li style="margin: 10px 0 0 20px;"><em>(A)</em>：应用通过 浏览器 或
				Webview 将用户引导到 Cus<a
				href="http://www.cus.net/openapi/docs/oauth2_authorize"
				target="_blank">三方认证页面</a> 上<br>https://www.cus.net/action/oauth2/authorize?response_type=code&amp;client_id=<em>{client_id}<sup>①</sup>
			</em>&amp;redirect_uri=<em>{redirect_uri}<sup>②</sup> </em></li>
			<li style="margin: 10px 0 0 20px;"><em>(B)</em>：用户对应用进行授权</li>
			<li style="margin: 10px 0 0 20px;"><em>(C)</em>：Cus认证服务器 通过
				回调地址（redirect_uri）将 用户授权码 传递给 应用服务器 或者直接在 Webview 中跳转到携带
				用户授权码的回调地址上，Webview 直接获取code即可（<em>redirect_uri</em>?code=abc&amp;state=xyz）</li>
			<li style="margin: 10px 0 0 20px;"><em>(D)</em>：应用服务器 或 Webview
				使用 <a href="/openapi/docs/oauth2_token">oauth2_token</a> API 向
				Cus认证服务器发送 用户授权码 以及 回调地址</li>
			<li style="margin: 10px 0 10px 20px;"><em>(E)</em>： OSChina
				认证服务器返回 AccessToken</li>
			<li>标注说明：</li>
			<li style="margin: 10px 0 0 20px;"><em>① client_id</em>：<a
				href="/openapi/client" target="_blank">应用管理</a> 应用列表中的 <em>应用ID</em><br>
			</li>
			<li style="margin: 10px 0 10px 20px;"><em>② redirect_uri</em>：<a
				href="/openapi/client" target="_blank">应用管理</a> 应用列表中的 <em>回调地址</em>
			</li>
			<li>应用通过 AccessToken 访问 OpenApi 使用用户数据。</li>
		</ul>
		<br>
		<div class="demos">
			<h2 style="margin: 10px 0; font-size: 20px;">Demo 应用</h2>
			<div>
				<p style="margin-bottom: 10px;">下面将介绍使用 OpenAPI 开发的两个示例应用：</p>
				<table>
					<thead>
						<tr>
							<th><a target="_blank" href="http://my.cus.net/android">Android客户端</a>
							</th>
							<th><a target="_blank" href="http://my.cus.net/ios">IOS客户端</a>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><img src="${image_path}/android.jpg" width="400px"
								height="379px;"></td>
							<td><img src="${image_path}/ios.jpg" width="400px"
								height="379px;" style="border: 1px solid #CCC;">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>



有疑问，请咨询 ：liuhaihua@59et.com.或者加群:${sitename}(223082909)


</body>
</html>