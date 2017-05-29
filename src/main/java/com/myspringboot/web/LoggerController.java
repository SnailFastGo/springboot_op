package com.myspringboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
	
	@RequestMapping(value = "/logtest")
	public String loggerTest(String param){
		System.out.println(param);
		return param;
	}
}
