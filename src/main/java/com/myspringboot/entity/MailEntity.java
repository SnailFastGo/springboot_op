package com.myspringboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MailEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//SMTP服务器
	private String smtpService;
	
	//设置端口号
	private String smtpPort;
	
	//设置发送邮箱地址
	private String fromMailAddress;
	
	//设置发送邮箱密码
	private String fromMailSmtpPwd;
	
	//设置邮件标题
	private String title;
	
	//设置邮件内容
	private String content;
	
	//设置邮件内容格式
	private String contentType;
	
	//设置邮件接收地址集合
	private List<String> sendAddress = new ArrayList<String>();

	public String getSmtpService() {
		return smtpService;
	}

	public void setSmtpService(String smtpService) {
		this.smtpService = smtpService;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getFromMailAddress() {
		return fromMailAddress;
	}

	public void setFromMailAddress(String fromMailAddress) {
		this.fromMailAddress = fromMailAddress;
	}

	public String getFromMailSmtpPwd() {
		return fromMailSmtpPwd;
	}

	public void setFromMailSmtpPwd(String fromMailSmtpPwd) {
		this.fromMailSmtpPwd = fromMailSmtpPwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<String> getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(List<String> sendAddress) {
		this.sendAddress = sendAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}



