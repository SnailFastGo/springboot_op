package com.myspringboot.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.myspringboot.entity.MailEntity;
import com.myspringboot.utils.PropertiesUtil;

public class MailSender {
	private static MailEntity mail = new MailEntity();
	
	public MailSender setTitle(String title){
		this.mail.setTitle(title);
		return this;
	}
	
	public MailSender setContent(String content){
		this.mail.setContent(content);
		return this;
	}
	
	public MailSender contentType(MailContentTypeEnum typeEnum){
		this.mail.setContentType(typeEnum.getValue());
		return this;
	}
	
	public MailSender setSendAddress(List<String> address){
		this.mail.setSendAddress(address);
		return this;
	}
	
	public void send() throws Exception{
		if(this.mail.getContentType() == null){
			this.mail.setContentType(MailContentTypeEnum.HTML.getValue());
		}
		
		if(null == this.mail.getContent() || "".equals(this.mail.getContent())){
			throw new Exception("邮件内容没有设置");
		}
		
		if(null == this.mail.getTitle()|| "".equals(this.mail.getTitle())){
			throw new Exception("邮件标题没有设置");
		}
		
		if(null == this.mail.getSendAddress()|| this.mail.getSendAddress().isEmpty()){
			throw new Exception("邮件发送地址没有设置");
		}
		
		final PropertiesUtil util = new PropertiesUtil("mail");
		
		//设置邮件服务器登陆信息
		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", util.getValue("mail.smtp.service"));
		props.put("mail.smtp.port", util.getValue("mail.smtp.port"));
		props.put("mail.user", util.getValue("mail.from.address"));
		props.put("mail.password", util.getValue("mail.from.smtp.pwd"));
		
		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
		};
		
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		
	     // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        
        // 设置发件人昵称
        String nickName = MimeUtility.encodeText(util.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + " <" + props.getProperty("mail.user") + ">");
        message.setFrom(form);
        
        // 设置邮件标题
        message.setSubject(mail.getTitle());
        
        //html发送邮件
        if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            // 设置邮件内容
            message.setContent(mail.getContent(), mail.getContentType());
        }
        //文本发送邮件
        else if(mail.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
        	// 设置邮件内容
            message.setText(mail.getContent());
        }
        
        //发送邮箱地址
        List<String> targets = mail.getSendAddress();
        
        for(int i = 0;i < targets.size();i++){
            try {
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                // 最后当然就是发送邮件啦
                Transport.send(message);
            }catch (Exception e)
            {
            	e.printStackTrace();
            }

        }
	}
	
	public static void main(String[] args) throws Exception {
		List<String> sendAddress = new ArrayList<String>();
		sendAddress.add("18612424587@163.com");
		new MailSender().setTitle("测试邮件发送").setContent("发送成功了吗").setSendAddress(sendAddress).send();
	}
}









