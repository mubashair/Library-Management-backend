package com.prog.library_management.dto.issue;

import java.time.LocalDate;
/**
 * Data Transfer Object (DTO) for returning issue record details to the client.
 *
 * This is used as a response object when a book is issued or returned.
 * 
 * It helps to avoid exposing the full entity and keeps only safe, readable data.
 */

public class IssueRecordDTO {
	//Unique identifier of the issue record
	private Long id;
	//Book details- only title or id can be shown (not full entity)
	private Long bookId;
	private String bookTitle;
	//User details again minimal information for privacy
	private Long userId;
	private String username;
	
	//Date when the book was issued
	private LocalDate issueDate;
	//Date when the book should be returned
	private LocalDate dueDate;
	//Actual return date (if the book has been returned)
	private LocalDate returnDate;
	//Status -whether the book is returned or still borrowed
	private boolean isReturned;
	//Default constructor --required for spring and serialization
	public IssueRecordDTO() {
		
	}
	//parameterized constructor useful for manual mapping or testing
	public IssueRecordDTO(Long id, Long bookId, String bookTitle, Long userId, String username, LocalDate issueDate,
			LocalDate returnDate, boolean isReturned) {
		
		this.id = id;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.userId = userId;
		this.username = username;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.isReturned = isReturned;
	}
	//Getter and setters
	//Allow Spring and Jackson (JSON serializer) to read/write field values.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public boolean getIsReturned() {
		return isReturned;
	}
	public void setIsReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	

}
