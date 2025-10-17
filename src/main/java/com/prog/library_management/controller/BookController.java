package com.prog.library_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.library_management.dto.BookDTO;
import com.prog.library_management.service.BookService;

@RestController
@RequestMapping("/api/books")//base url for all book endpoints
public class BookController {
	private final BookService bookService;
	//constructor injection(best practice)
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	//add a new book
	@PostMapping
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO){
		BookDTO savedBook = bookService.addBook(bookDTO);
		return new ResponseEntity<BookDTO>(savedBook, HttpStatus.CREATED);
	}
	//Get all books
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAllBooks(){
		List<BookDTO> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}
	//Get a book by id
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
		BookDTO book = bookService.getBookById(id);
		return ResponseEntity.ok(book);
	}
	//update book details
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
		BookDTO updated = bookService.updateBook(id, bookDTO);
		return ResponseEntity.ok(updated);
		
	}
	//Delete book
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

}
