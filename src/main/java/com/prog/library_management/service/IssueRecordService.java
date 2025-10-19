package com.prog.library_management.service;





import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.library_management.entity.Book;
import com.prog.library_management.entity.IssueRecord;
import com.prog.library_management.entity.User;
import com.prog.library_management.repo.BookRepo;
import com.prog.library_management.repo.IssueRecordRepo;
import com.prog.library_management.repo.UserRepo;
@Service
public class IssueRecordService {
	@Autowired
	private IssueRecordRepo issueRecordRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BookRepo bookRepo;
	
	//issue a book to user(borrow book)
	public IssueRecord issueBook(Long userId, Long bookId) {
		User user = userRepo.findById(userId)
				.orElseThrow(()->new RuntimeException("User not found with ID:"+userId));
		Book book = bookRepo.findById(bookId)
				.orElseThrow(()->new RuntimeException("Book not found with ID:"+bookId));
		if(book.getQuantity() <= 0) {
			throw new RuntimeException("Book not available right now!");
		}
		//creating an issue record
		IssueRecord record = new IssueRecord();
		//Now we prepare a new Issue Record, i.e., 
        //a record that links:Which user took which book and when.
		record.setUser(user);//Store who took the book
		record.setBook(book);//Store which book was taken
		record.setIssueDate(LocalDate.now());//Store the current date as the issue date
		record.setIsReturned(false);
		//✅ Result: A new IssueRecord object is ready to be saved.
		//update book quantity
		book.setQuantity(book.getQuantity()-1);//Every time a book is issued, its available quantity should decrease by 1.
//		If there were 5 copies before, now there will be 4.
//       We then save the updated book record back to the database.
		bookRepo.save(book);
		IssueRecord savedRecord = issueRecordRepo.save(record);//save the issue record
		return savedRecord;
		//finally we save the issue record, transaction log in the database
//		Which user borrowed which book,
//
//		On what date,
//
//		And that it’s not returned yet.
	}//end method issueBook

}
