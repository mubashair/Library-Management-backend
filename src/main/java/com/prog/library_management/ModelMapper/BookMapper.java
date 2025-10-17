package com.prog.library_management.ModelMapper;

import com.prog.library_management.dto.BookDTO;
import com.prog.library_management.entity.Book;

public class BookMapper {
	//coverting entity to dto
	public static BookDTO convertToDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setIsAavailable(book.getIsAvailable());
		bookDTO.setQuantity(bookDTO.getQuantity());
		bookDTO.setTitle(book.getTitle());
		return bookDTO;
	}
	//converting dto to entity
	public static Book convertToEntity(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setAuthor(bookDTO.getAuthor());
		book.setIsbn(bookDTO.getIsbn());
		book.setIsAvailable(bookDTO.getIsAavailable());
		book.setTitle(bookDTO.getTitle());
		book.setQuantity(bookDTO.getQuantity());
		return book;
	}

}
