package com.prog.library_management.dto.issue;

import java.util.Date;

/**
 * DTO (Data Transfer Object) for issuing a book.
 * 
 * This class is used to receive data from the client (frontend / Postman)
 * when a user requests to issue a book.
 * 
 * It carries only the required fields — not the full Book or User entities.
 */
public class IssueBookRequest {
	//ID of the user who wants to issue the book
	private Long userId;
	//ID of the book that needs to be issued
	private Long bookId;
	//Date when the book is due to be returned
	private Date dueDate;
	
	public IssueBookRequest() {
		
	}

	public IssueBookRequest(Long userId, Long bookId, Date dueDate) {
	
		this.userId = userId;
		this.bookId = bookId;
		this.dueDate = dueDate;
	}
	// Getters and setters — required for Spring to map JSON request data
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
