package com.LibraryManagementSystem.controllers;

import com.LibraryManagementSystem.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity borrowBook(@PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId) {
        if (!borrowingService.isBorrowed(bookId, patronId)) {
            return new ResponseEntity(borrowingService.borrowBook(bookId, patronId), HttpStatus.OK);
        }else {
            return new ResponseEntity("Already Have Borrowed this Book", HttpStatus.OK);
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity returnPatron(@PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId) {
        if (borrowingService.isBorrowed(bookId, patronId)) {
            return new ResponseEntity(borrowingService.returnBook(bookId, patronId), HttpStatus.OK);
        }else {
            return new ResponseEntity("No Record Found", HttpStatus.NOT_FOUND);
        }
    }

}
