package com.prog.library_management.dto;

public class BookDTO {
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private Integer quantity;
	private Boolean isAavailable;
	//Default constructor
	public BookDTO() {}
	//parametrized constructor for easy conversion
	public BookDTO(Long id, String title, String author, String isbn, Integer quantity, Boolean isAavailable) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.quantity = quantity;
		this.isAavailable = isAavailable;
	}
	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Boolean getIsAavailable() {
		return isAavailable;
	}
	public void setIsAavailable(Boolean isAavailable) {
		this.isAavailable = isAavailable;
	}
	

}
