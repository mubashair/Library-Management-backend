package com.prog.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.library_management.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
