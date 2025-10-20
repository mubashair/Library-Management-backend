package com.prog.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.library_management.entity.IssueRecord;
@Repository
public interface IssueRecordRepo extends JpaRepository<IssueRecord, Long>{
	

}
