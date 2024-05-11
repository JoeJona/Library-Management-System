package com.LibraryManagementSystem.services;

import com.LibraryManagementSystem.entity.BorrowingRecord;

public interface BorrowingService {

    boolean isBorrowed(Long bookId, Long patronId);
    BorrowingRecord borrowBook(Long bookId, Long patronId);
    BorrowingRecord returnBook(Long bookId, Long patronId);

}
