<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!-- footer-->
<div id="footer">
	<div class="split_2px"></div>
		<p>
		<a target="_blank" href="#"><img src="${image_path}/rz01.jpg" width="120px" height="50px">
		</a> <a target="_blank" href="#"><img src="${image_path}/rz02.png" width="120px" height="50px">
		</a> <a target="_blank" href="#"><img src="${image_path}/rz03.png" width="120px" height="50px">
		</a> <a target="_blank" href="#"><img src="${image_path}/rz04.png" width="120px" height="50px">
		</a> <a target="_blank" href="#"><img src="${image_path}/rz05.png" width="120px" height="50px">
		</a> <a target="_blank" href="#"><img src="${image_path}/hy_124x47.png" width="120px" height="50px"> </a>
		
	</p>
	<div class="footer-link">
		<a href="#">${sitename}</a> | <a href="Login_job.shtm"
			target="_blank">人才招聘</a> | <a
			href="Login_linkus.shtm" target="_blank">联系我们</a> | <a
			href="Login_question.shtm" target="_blank">帮助中心</a> | <a id="ico_pp_a"
			target="_blank">意见反馈</a> | <a href="#"
			target="_blank">流量统计</a> | <a href="Login_team.shtm"" target="_blank">团队介绍</a>
				

	</div>

	<div style="margin-bottom: 5px; margin-top: 5px;"">
		Copyright Software &copy; 2012-2022 <a
			href="http://www.miibeian.gov.cn/" target="_blank">辽ICP备10000000</a>
	</div>

</div>
<!-- footer -->

<!-- 在线留言 -->
<div class='getForm' id='pop_ly_id_div'>
	<div>
		<dl>
			<dt>
				<span title='关闭'>x</span>提交留言
			</dt>
			<dd>
				<input type='text' id='name' name="name"
					onblur='if (this.value ==""){this.value="请输入您的称呼"}'
					onfocus='if (this.value =="请输入您的称呼"){this.value =""}'
					value='请输入您的称呼'> <b style='color: #f00'>* 必填项</b>
			</dd>
			<dd>
				<input type='text' id='email' name="email"
					onblur='if (this.value ==""){this.value="请输入您的邮箱"}'
					onfocus='if (this.value =="请输入您的邮箱"){this.value =""}'
					value='请输入您的邮箱'>
			</dd>
			<dd>
				<input type='text' id='telephone' name="telephone"
					onblur='if (this.value ==""){value="请输入您的电话"}'
					onfocus='if (this.value =="请输入您的电话"){this.value =""}'
					value='请输入您的电话'>
			</dd>
			<dd>
				<textarea id='message' name="message"
					onblur='if (this.value ==""){this.value="请输入留言内容"}'
					onfocus='if (this.value =="请输入留言内容"){value =""}'>请输入留言内容</textarea>
				<b style='color: #f00'>* 必填项</b>
			</dd>
			<dd>
				<input type='text' id='msg_vcode' name="msg_vcode"
					onblur='if (this.value ==""){this.value="请输入验证码"}'
					onfocus='if (this.value =="请输入验证码"){this.value =""}' value='请输入验证码'>	<img width="80" height="20" id="randimage" src="${request_path}/common/validate_img.jsp" align="absMiddle" border="0" alt="看不清楚?请点击刷新" style="cursor : pointer;" onclick="this.src='${request_path}/common/validate_img.jsp?'+ Math.random()"/>
			</dd>
			<dd>
				<button  name='msg_sub' class="normal_btn" id='msg_sub_button'>确
					定</button>
			</dd>
		</dl>
	</div>
</div>
