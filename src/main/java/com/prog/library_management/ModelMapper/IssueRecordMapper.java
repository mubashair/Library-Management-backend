package com.prog.library_management.ModelMapper;

import com.prog.library_management.dto.issue.IssueRecordDTO;
import com.prog.library_management.entity.IssueRecord;

/**
 * Mapper class for converting between IssueRecord entity and IssueRecordDTO.
 * 
 * Mappers help separate database models (entities) from API models (DTOs),
 * ensuring we only expose safe and relevant fields to the frontend.
 */
/*
 * converts an IssueRecord entity (database model) into IssueRecordDTO API
 * friendly response object
 */
public class IssueRecordMapper {
	/**
     * Converts an IssueRecord entity (database model)
     * into an IssueRecordDTO (API-friendly response object).
     *
     * @param record IssueRecord entity from the database
     * @return IssueRecordDTO for sending in API response
     */
	public static IssueRecordDTO toDTO(IssueRecord record) {
		if(record == null) {
			return null;
		}
		IssueRecordDTO dto = new IssueRecordDTO();
		dto.setId(record.getId());
		dto.setIssueDate(record.getIssueDate());
		dto.setReturnDate(record.getReturnDate());
		dto.setIsReturned(record.getIsReturned());
		
		//user details defensive null checks
		if(record.getUser() != null) {
			dto.setUserId(record.getUser().getId());
			dto.setUsername(record.getUser().getUsername());
		}
		//Book details defensive null check
		if(record.getBook() != null) {
			dto.setBookId(record.getBook().getId());
			dto.setBookTitle(record.getBook().getTitle());
		}
		return dto;
		
	}
	/*
	 * Convert an IssueRecordDTO back into IssueRecord entity Usually used when
	 * saving a new issue record or updating an existing one.
	 * 
	 * @param dto IssueRecordDTO containing input data
	 * 
	 * @return IssueRecord entity for persistence
	 */
	public static IssueRecord toEntity(IssueRecordDTO dto) {
		if(dto == null) {
			return null;
		}
		IssueRecord record = new IssueRecord();
		record.setIssueDate(dto.getIssueDate());
		record.setReturnDate(dto.getReturnDate());
		record.setDueDate(dto.getReturnDate());
		record.setIsReturned(dto.getIsReturned());
		return record;
		// We don’t set User or Book here directly because
        // those are separate entities fetched by repository in the service layer.
	}
	

}
