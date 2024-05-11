package com.LibraryManagementSystem.services;

import com.LibraryManagementSystem.entity.Book;

import java.util.List;

public interface BookService {

    boolean isBookExist(Long bookId);
    List<Book> getAllBooks();
    Book getBook(Long bookId);
    Book addBook(Book book);
    Book updateBook(Long bookId, Book book);
    void deleteBook(Long bookId);

}
