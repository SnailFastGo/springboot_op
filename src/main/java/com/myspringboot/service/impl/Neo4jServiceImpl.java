package com.myspringboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.entity.neo4j.UserGraphEntity;
import com.myspringboot.repository.neo4j.UserGraphEntityRepository;
import com.myspringboot.service.Neo4jService;

@Service
public class Neo4jServiceImpl implements Neo4jService{
	
	@Autowired
	private UserGraphEntityRepository userGraphRepository;

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public UserGraphEntity createUser(UserGraphEntity userGraphEntity) {
		UserGraphEntity res = userGraphRepository.save(userGraphEntity);
		return res;
	}

	@Override
	public Iterable<UserGraphEntity> findAllUser() {
		Iterable<UserGraphEntity> res = userGraphRepository.findAll();
		return res;
	}

	
}
