package com.LibraryManagementSystem.repo;

import com.LibraryManagementSystem.entity.Book;
import com.LibraryManagementSystem.entity.BorrowingRecord;
import com.LibraryManagementSystem.entity.Patron;
import org.springframework.data.repository.CrudRepository;

public interface BorrowRepo extends CrudRepository<BorrowingRecord, Long> {

    BorrowingRecord getBorrowingRecordByBookAndPatron(Book book, Patron patron);

}
