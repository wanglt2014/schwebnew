package com.et59.cus.test;

import com.et59.cus.mail.MailSenderInfo;
import com.et59.cus.mail.ReadReplaceFile;
import com.et59.cus.mail.SimpleMailSender;
import com.et59.cus.mail.TemplateVO;

public class TestMail {
	public static void main(String[] args){
	         //这个类主要是设置邮件
		  MailSenderInfo mailInfo = new MailSenderInfo(); 
		  mailInfo.setMailServerHost("smtp.ym.163.com"); 
		  mailInfo.setMailServerPort("25"); 
		  mailInfo.setValidate(true); 
		  mailInfo.setUserName("service@59et.com"); 
		  mailInfo.setPassword("123456");//您的邮箱密码 
		  mailInfo.setFromAddress("service@59et.com"); 
		  mailInfo.setNick("点滴工作室");
		  mailInfo.setToAddress("jxausea@163.com"); 
		  mailInfo.setSubject("密码找回"); 
		  TemplateVO  templateVO =new TemplateVO();
		  templateVO.setOld_username("${username}");
	      templateVO.setUsername("liuhaihua");
	      templateVO.setOld_email("${email}");
	      templateVO.setEmail("liuhaihua@59et.com");
		  String template =ReadReplaceFile.replaceTemplateByStr(templateVO);
		  mailInfo.setContent(template); 
	         //这个类主要来发送邮件
		  SimpleMailSender sms = new SimpleMailSender();
	         // sms.sendTextMail(mailInfo);//发送文体格式 
		  
	          sms.sendHtmlMail(mailInfo);//发送html格式
		}
	
}

