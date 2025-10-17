package com.prog.library_management.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.library_management.ModelMapper.BookMapper;
import com.prog.library_management.dto.BookDTO;
import com.prog.library_management.entity.Book;
import com.prog.library_management.repo.BookRepo;

import jakarta.persistence.EntityNotFoundException;

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
		Book book = bookRepo.findById(id)
				.orElseThrow( ()->new RuntimeException("Book not found"));	
		return BookMapper.convertToDTO(book);
	}

	public BookDTO updateBook(Long id, BookDTO bookDTO) {
		Book existingBook = bookRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Book not found"));
		existingBook.setTitle(bookDTO.getTitle());
		existingBook.setAuthor(bookDTO.getAuthor());
		existingBook.setIsbn(bookDTO.getIsbn());
		existingBook.setQuantity(bookDTO.getQuantity());
		Book updated = bookRepo.save(existingBook);
		
		return BookMapper.convertToDTO(updated);
	}

	public void deleteBook(Long id) {
		
		if(!bookRepo.existsById(id)) {
			throw new EntityNotFoundException("Book not found with ID:" +id);
		}
		bookRepo.deleteById(id);
	}

}