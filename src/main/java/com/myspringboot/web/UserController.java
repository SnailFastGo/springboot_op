package com.myspringboot.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.entity.UserEntity;
import com.myspringboot.service.UserService;


@RestController
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userlist")
	public List<UserEntity> userList(){
		List<UserEntity> users = userService.list();
		logger.debug("debug : users : {}", users);
		logger.info("info : users : {}", users);
		logger.error("error : users : {}", users);
		return users;
	}
	
	@RequestMapping(value = "/finduserbyname")
	public List<UserEntity> findUserByName(String name){
		List<UserEntity> users = userService.findUserByName(name);
		return users;
	}
	
	@RequestMapping(value = "/deleteUserById")
	public void deleteUser(String id){
		userService.deleteUserById(id);
	}
	
	@RequestMapping(value = "/curpage")
	public List<UserEntity> curPage(int page){
		UserEntity user = new UserEntity();
		user.setSize(2);
		user.setPage(page);
		user.setSort("desc");
		Sort.Direction direction = Sort.Direction.DESC;
		Sort sort = new Sort(direction, "name");
		PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize(), sort);
		List<UserEntity> res = userService.curPage(pageRequest);
		return res;
	}
	
}
