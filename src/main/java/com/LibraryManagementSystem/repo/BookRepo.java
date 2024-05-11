package com.LibraryManagementSystem.repo;

import com.LibraryManagementSystem.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
    Book getBookById(Long bookId);

}
