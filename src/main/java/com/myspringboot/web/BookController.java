package com.myspringboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.entity.BookEntity;
import com.myspringboot.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/booklist")
	public List<BookEntity> booklist(){
		List<BookEntity> res = bookservice.list();
		return res;
	}
}
