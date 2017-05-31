package com.myspringboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.entity.BookEntity;
import com.myspringboot.repository.book.BookRepository;
import com.myspringboot.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookEntity> list() {
		return bookRepository.findAll();
	}
	
}
