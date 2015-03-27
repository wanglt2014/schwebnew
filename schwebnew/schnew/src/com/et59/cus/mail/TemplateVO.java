package com.et59.cus.mail;
/**
 * 带替换的模板vo
 * @author liuhaihua
 *
 */
public class TemplateVO {
	/**
	 * 用户名字
	 */
	private String username;
	/**
	 * 带替换的用户民
	 */
	private String old_username="${username}";
	/**
	 * 待替换的邮箱
	 */
	private String email;
	/**
	 * 邮件url
	 */
	private String url;
	
	private String old_url="${url}";
	/**
	 * 带替换的邮箱
	 */
	private String old_email="${email}";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOld_username() {
		return old_username;
	}
	public void setOld_username(String old_username) {
		this.old_username = old_username;
	}
	public String getOld_email() {
		return old_email;
	}
	public void setOld_email(String old_email) {
		this.old_email = old_email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOld_url() {
		return old_url;
	}
	public void setOld_url(String old_url) {
		this.old_url = old_url;
	}
	
	
}
