
var SMS_TIMEOUT = 60;

$(document).ready(function(){
	$('input:text').addClass('text_style');
	
	var $navTitle = $('.nav_title');
	$navTitle.hover(
		function(){
			if ( $(this).hasClass("nav_focus") ){
				return;
			}
			$(this).addClass("nav_hover");
		},
		function(){
			$(this).removeClass("nav_hover");
		}
	);
	$navTitle.click(function(){
		$this = $(this);
		var id = $this.attr('id');
		if (id == 'nav_link_index'){
			location.href = 'Login_init.shtm';
		}else if (id == 'nav_link_tongzhi'){
			location.href = 'Article_toNoticePage.shtm';
		}else if (id == 'nav_link_zhidu'){
			location.href = 'Article_toRegulationPage.shtm';
		}else if (id == 'nav_link_download') {
			location.href = 'Download_toDownloadPage.shtm';
		}else if (id == 'nav_link_teacher') {
			location.href = 'Teacher_toTeacherPage.shtm';
		}else if (id == 'nav_link_plan') {
			location.href = 'TrainingPlan_toPlanPage.shtm';
		}else if (id == 'nav_link_result') {
			location.href = 'Article_toTrainingResultPage.shtm';
		}else if (id == 'nav_link_bbs') {
			location.href = 'http://localhost:8080/schoolbbs';
		}else if (id == 'nav_link_downloadinfo') {
			location.href = 'Download_toDownloadPage.shtm';
		}
	});
	
	var $accountMenu = $('.menu_item');
	$accountMenu.hover(
		function(){
			$(this).addClass("menu_hover");
		},
		function(){
			$(this).removeClass("menu_hover");
		}
	);
	$accountMenu.click(function(){
		$this = $(this);
		var id = $this.attr('id');
		if (id == 'menu_index'){
			location.href = 'AccountManage_queryUnPay';
		}else if (id == 'menu_balance'){
			location.href = 'Trade_toTradeQuery';
		}else if(id == 'menu_setting'){
			location.href = 'UserCenter_toUserInfo';
		}else if(id == 'menu_updatepasswd'){
			location.href = 'UserCenter_toupdatepasswd';
		}
		
		
	});
	
});
