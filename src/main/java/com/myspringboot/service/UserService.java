package com.myspringboot.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.myspringboot.entity.UserEntity;

public interface UserService {
	 List<UserEntity> list(String param);
	 
	 List<UserEntity> findUserByName(String name);
	 
	 void deleteUserById(String id);
	 
	 List<UserEntity> curPage(PageRequest pageRequest);
}
