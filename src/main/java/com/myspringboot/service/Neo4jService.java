package com.myspringboot.service;

import java.util.List;

import com.myspringboot.entity.neo4j.UserGraphEntity;

public interface Neo4jService {
	
	UserGraphEntity createUser(UserGraphEntity userGraphEntity);
	
	Iterable<UserGraphEntity> findUser(String id);
}
