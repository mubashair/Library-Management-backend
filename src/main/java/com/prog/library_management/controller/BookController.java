package com.prog.library_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.prog.library_management.service.BookService;

@RequestMapping("api/books")
public class BookController {
	private final BookService bookService;
	//constructor injection best practice
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	

}
