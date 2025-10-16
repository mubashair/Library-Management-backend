
package com.prog.library_management.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="users")//maps to "users" table in mysql
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment ID
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	/**
     * Roles define permissions for the user (e.g., ADMIN, USER).
     * @ElementCollection means this will be stored in a separate table.
     * FetchType.EAGER means roles will be loaded immediately with the user.
     */
//	Means roles is not a separate entity but a collection of values stored in another table.
//
//	Eager fetching means when we load a User, we immediately load its roles.
	@ElementCollection(fetch=FetchType.EAGER)
//	Stores roles like ADMIN or USER.
//
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
//	Set is used instead of List to avoid duplicate roles.
    private Set<String> roles;
	//Relations
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)//mappedBy is showing non owning side
	private Set<IssueRecord> issueRecords;
	//Default constructor required by JPA
	public User() {
		
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Set<String> getRoles() {
		return roles;
	}
	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	

}
