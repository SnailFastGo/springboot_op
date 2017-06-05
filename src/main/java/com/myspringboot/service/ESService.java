package com.myspringboot.service;

import com.alibaba.fastjson.JSONObject;

public interface ESService {
	void insertDoc(String index, String type, String id, JSONObject data);
	
	JSONObject queryUser(String index, String type, String id);
}
