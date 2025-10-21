package com.prog.library_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prog.library_management.entity.IssueRecord;
import com.prog.library_management.service.IssueRecordService;

@RestController
@RequestMapping("api/issues")
public class IssueRecordController{
	@Autowired
	IssueRecordService issueRecordService;
	@PostMapping("/issue")
	public ResponseEntity<IssueRecord> issueBook(@RequestParam Long userId, @RequestParam Long bookId){
		IssueRecord issueBook = issueRecordService.issueBook(userId, bookId);
		return ResponseEntity.ok(issueBook);
		
	}
	@PostMapping("/return")
	public ResponseEntity<IssueRecord> returnBook(@RequestParam Long issueRecordId){
		IssueRecord returnBook = issueRecordService.returnBook(issueRecordId);
		return ResponseEntity.ok(returnBook);
	}
	

}
