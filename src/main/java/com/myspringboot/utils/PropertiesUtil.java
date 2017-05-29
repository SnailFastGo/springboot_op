package com.myspringboot.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
	private final ResourceBundle resource;
	
	private final String fileName;
	
	public PropertiesUtil(String fileName){
		this.fileName = fileName;
		Locale locale = new Locale("zh", "CN");
		this.resource = ResourceBundle.getBundle(this.fileName, locale);
	}
	
	public String getValue(String key){
		String ans = this.resource.getString(key);
		return ans;
	}
	
	public static void main(String[] args) {
		PropertiesUtil u = new PropertiesUtil("mail");
		String value = u.getValue("mail.smtp.service");
		System.out.println(value);
	}
}
