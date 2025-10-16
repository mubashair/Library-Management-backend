package com.prog.library_management.mapper;

import com.prog.library_management.dto.BookDTO;
import com.prog.library_management.entity.Book;

public class BookMapper {
	//coverting Book entity to BookDTO
	public static BookDTO convertToDTO(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setQuantity(book.getQuantity());
		dto.setIsbn(book.getIsbn());
		dto.setAvailable(book.getIsAvailable());
		
		return dto;
	}
	//covert dto to entity
	public static Book convertToEntity(BookDTO dto) {
		Book book = new Book();
		book.setId(dto.getId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setIsbn(dto.getIsbn());
		book.setQuantity(dto.getQuantity());
		book.setIsAvailable(dto.isAvailable());
		return book;
	}
}
