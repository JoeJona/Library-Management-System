package com.LibraryManagementSystem.services.impl;

import com.LibraryManagementSystem.entity.Book;
import com.LibraryManagementSystem.entity.BorrowingRecord;
import com.LibraryManagementSystem.entity.Patron;
import com.LibraryManagementSystem.repo.BookRepo;
import com.LibraryManagementSystem.repo.BorrowRepo;
import com.LibraryManagementSystem.repo.PatronRepo;
import com.LibraryManagementSystem.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    PatronRepo patronRepo;
    @Autowired
    BorrowRepo borrowRepo;

    @Override
    public boolean isBorrowed(Long bookId, Long patronId) {
        Book book = bookRepo.getBookById(bookId);
        Patron patron = patronRepo.getPatronById(patronId);
        BorrowingRecord borrowingRecord = borrowRepo.getBorrowingRecordByBookAndPatron(book, patron);
        if (borrowingRecord != null) {
            return true;
        }
            return false;
    }
    @Override
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {

        Book book = bookRepo.getBookById(bookId);
        Patron patron = patronRepo.getPatronById(patronId);
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());
        borrowRepo.save(borrowingRecord);
        return borrowingRecord;
    }

    @Override
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Book book = bookRepo.getBookById(bookId);
        Patron patron = patronRepo.getPatronById(patronId);
        BorrowingRecord borrowingRecord = borrowRepo.getBorrowingRecordByBookAndPatron(book, patron);
        borrowingRecord.setReturnDate(LocalDate.now());
        borrowRepo.save(borrowingRecord);
        return borrowingRecord;
    }

}
