package com.myspringboot.other;

public enum MailContentTypeEnum {
	//html格式
	HTML("text/html;charset=UTF-8"), TEXT("test");
	
	private String value;
	
	MailContentTypeEnum(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
}
