package com.prog.library_management.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "issuerecords")
public class IssueRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate issueDate;//Date when the book is issued
	private LocalDate dueDate;//due date for returning book
	private LocalDate returnDate;//Date when the book is actually returned
	private Boolean isReturned;//Book is returned or not
	
	// @ManyToOne → Many issue records can belong to ONE user.
    // @JoinColumn → The column "user_id" will store the foreign key 
    // referencing the primary key of the 'users' table.
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;// Which user took the book.
	
	
	@ManyToOne
	@JoinColumn(name = "book_id")//join column shows this is owning side
	// @ManyToOne → Many issue records can belong to ONE book.
    // @JoinColumn → The column "book_id" will store the foreign key 
    // referencing the primary key of the 'books' table.
    private Book book; // Which book was issued.
	
	//Default constructor
	// Default constructor — required by JPA for creating entity objects.
	public IssueRecord() {
		
	}
	//life cycle call back -runs before inserting into DB
	//used to set default values for issueDate and isReturned
	@PrePersist
	public void prePersist() {
		if(this.issueDate == null) {
			this.issueDate = LocalDate.now();//set the current date
		}
		if(this.isReturned == null) {
			this.isReturned = false; //Default not returned yet
		}
	}
	/**
     * This method runs automatically BEFORE an existing record is updated.
     * If isReturned becomes TRUE, we set the return date to today.
     */
	@PreUpdate
	public void preUpdate() {
		if(Boolean.TRUE.equals(this.isReturned) && this.returnDate == null) {
			this.returnDate = LocalDate.now();
		}
	}
//	How it Works
//
//	When issuing a book (@PrePersist)
//
//	If you forget to set issueDate, it will automatically become today’s date.
//
//	If you forget to set isReturned, it will default to false.
//
//	When returning a book (@PreUpdate)
//
//	As soon as isReturned is set to true, returnDate will automatically be set to today’s date (if not already provided).
	
	
	//Getters

	public Long getId() {
		return id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public Boolean getIsReturned() {
		return isReturned;
	}

	public User getUser() {
		return user;
	}

	public Book getBook() {
		return book;
	}
	
    //Setters
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setIsReturned(Boolean isReturned) {
		this.isReturned = isReturned;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	

}
