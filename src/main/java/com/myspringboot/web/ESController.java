package com.myspringboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.myspringboot.service.ESService;

@RestController
public class ESController {
	
	@Autowired
	private ESService esService;

	@RequestMapping("/esuser")
	public JSONObject queryUser(String index, String type, String id){
		JSONObject res = esService.queryUser(index, type, id);
		if(null != res){
			System.out.println(res);
		}else{
			System.out.println("查询的数据不存在");
		}
		return res;
	}
}
