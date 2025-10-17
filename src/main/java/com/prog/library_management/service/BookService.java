package com.prog.library_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.library_management.ModelMapper.BookMapper;
import com.prog.library_management.dto.BookDTO;
import com.prog.library_management.entity.Book;
import com.prog.library_management.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	/*public BookDTO addBook(BookDTO bookDTO) {
		BookMapper bookMapper = new BookMapper();
		Book book = bookMapper.covertToEntity(bookDTO);
		Book savedEmployee = bookRepo.save(book);
		return bookMapper.covnertToDTO(savedEmployee);
		
	}*/

	public BookDTO addBook(BookDTO bookDTO) {
		Book book = BookMapper.convertToEntity(bookDTO);
		Book saved = bookRepo.save(book);
		
		return BookMapper.convertToDTO(saved);
	}

	public List<BookDTO> getAllBooks() {
		return bookRepo.findAll()
		        .stream() 
		        .map(BookMapper::convertToDTO)
		        .collect(Collectors.toList());
		
	}

	public BookDTO getBookById(Long id) {
		
		return null;
	}

	public BookDTO updateBook(Long id, BookDTO bookDTO) {
		
		return null;
	}

	public void deleteBook(Long id) {
		
		
	}

}
