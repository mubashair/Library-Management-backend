package com.prog.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.library_management.entity.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	

}
