package com.myspringboot.service.impl;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.myspringboot.service.ESService;

@Service
public class ESServiceImpl implements ESService{
	
	@Autowired
	private TransportClient esClient;

	@Override
	public void insertDoc(String index, String type, String id, JSONObject data) {
		esClient.prepareIndex(index, type).setSource(data.toJSONString()).setId("1").execute().actionGet();
	}

	@Override
	public JSONObject queryUser(String index, String type, String id) {
		GetResponse getResponse = esClient.prepareGet(index, type, id).get(); 
		String sourceAsString = getResponse.getSourceAsString();
		JSONObject res = JSONObject.parseObject(sourceAsString);
		return res;
	}
}
