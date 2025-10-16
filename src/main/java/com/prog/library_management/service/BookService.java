package com.prog.library_management.service;

import org.springframework.stereotype.Service;

import com.prog.library_management.repo.BookRepo;
@Service
public class BookService {
	private final BookRepo repo;
	//constructor injection
	public BookService(BookRepo repo) {
		this.repo = repo;
	}
}