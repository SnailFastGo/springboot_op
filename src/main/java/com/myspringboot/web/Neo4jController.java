package com.myspringboot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.entity.neo4j.UserGraphEntity;
import com.myspringboot.service.Neo4jService;

@RestController
public class Neo4jController {

	@Autowired
	private Neo4jService neo4jService;
	
	@RequestMapping("/create_user_node")
	public void createUser(){
		//Id字段是由neo4j内部来维护的，千万不能给该字段赋值，不然写不进去数据
//		user.setId(1L);
		long start  = System.currentTimeMillis();
		for(int i = 1; i <= 10000; i ++){
			UserGraphEntity user = new UserGraphEntity();
			user.setUserId("" + i);
			user.setName("zhangsan" + i);
			user.setPhone("" + i);
			neo4jService.createUser(user);
		}
		long end  = System.currentTimeMillis();
		System.out.println("create success, 耗时: " + (end - start));
	}
	
	@RequestMapping("/user_nodes")
	public List<UserGraphEntity> findUsers(String id){
		Iterable<UserGraphEntity> users = neo4jService.findAllUser();
		List<UserGraphEntity> res = new ArrayList<UserGraphEntity>();
		for(UserGraphEntity u : users){
			res.add(u);
		}
		return res;
	}
}
