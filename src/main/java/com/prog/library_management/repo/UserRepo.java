package com.prog.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.library_management.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
