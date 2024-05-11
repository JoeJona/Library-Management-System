package com.LibraryManagementSystem.controllers;

import com.LibraryManagementSystem.entity.Book;
import com.LibraryManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity getBook(@PathVariable("bookId") Long bookId) {
        if (bookService.isBookExist(bookId)) {
            return new ResponseEntity(bookService.getBook(bookId), HttpStatus.OK);
        }else {
            return new ResponseEntity("Book Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        if (bookService.isBookExist(bookId)) {
            return new ResponseEntity(bookService.updateBook(bookId, book), HttpStatus.OK);
        }else {
            return new ResponseEntity("Book Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") Long bookId) {
        if (bookService.isBookExist(bookId)) {
            bookService.deleteBook(bookId);
            return new ResponseEntity("book deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity("Book Not Found", HttpStatus.NOT_FOUND);
        }
    }

}
