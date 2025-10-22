package com.prog.library_management.service;





import java.time.LocalDate;
import java.util.Optional;

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
	
	/*Steps*/
	//1-Validates user and book IDs
	//2-Ensure the book is available the qunatity >0
	//3-Create a new issue record
	//4-Decrease the book quantity
	//5-Save both issue record and updated book
	//6-Return the updated book
	
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
		record.setIsReturned(false);//Mark that this book has not been returned yet
		//✅ Result: A new IssueRecord object is ready to be saved.
		//update book quantity
		book.setQuantity(book.getQuantity()-1);//Every time a book is issued, its available quantity should decrease by 1.
//		If there were 5 copies before, now there will be 4.
//       We then save the updated book record back to the database.
		//Result the inventory is updated
		bookRepo.save(book);
		IssueRecord savedRecord = issueRecordRepo.save(record);//save the issue record
		return savedRecord;
		//finally we save the issue record, transaction log in the database
//		Which user borrowed which book,
//
//		On what date,
//
//		And that it’s not returned yet.
//		Summary
//		Step	Action	Purpose
//		1	Fetch User	Verify borrower exists
//		2	Fetch Book	Verify book exists
//		3	Create IssueRecord	Log who borrowed which book
//		4	Decrease Quantity	Update book stock
//		5	Save Record	Commit issue record to DB
	}//end method issueBook
	
	//Return a book
	public IssueRecord returnBook(Long issueRecordId) {
		//1-Find the issue record
		IssueRecord record = issueRecordRepo.findById(issueRecordId)
				.orElseThrow(()->new RuntimeException("Issue record not found with ID:"+issueRecordId));
		//2-Check if already returned
		if(record.getIsReturned()) {
			throw new RuntimeException("Book already returned");
		}
		//3-Mark as returned
		record.setIsReturned(true);
		record.setReturnDate(LocalDate.now());
		//4-Increase the book quantity
		Book book = record.getBook();//we get the book from issue record
		book.setQuantity(book.getQuantity()+1);
		//save the updated book details to DB
		//5-save the updated record
		return issueRecordRepo.save(record); 
	}
	
	

}
