package com.LibraryManagementSystem.services.impl;

import com.LibraryManagementSystem.entity.Book;
import com.LibraryManagementSystem.repo.BookRepo;
import com.LibraryManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Override
    public boolean isBookExist(Long bookId) {
        return bookRepo.findById(bookId).isPresent();
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        return bookRepo.getBookById(bookId);
    }

    @Override
    public Book addBook(Book book) {
        Book newBook = new Book();
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setPublicationYear(book.getPublicationYear());
        newBook.setIsbn(book.getIsbn());
        bookRepo.save(newBook);
        return newBook;
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book updatedBook = bookRepo.getBookById(bookId);
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPublicationYear(book.getPublicationYear());
        updatedBook.setIsbn(book.getIsbn());
        bookRepo.save(updatedBook);
        return updatedBook;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepo.deleteById(bookId);
    }

}
