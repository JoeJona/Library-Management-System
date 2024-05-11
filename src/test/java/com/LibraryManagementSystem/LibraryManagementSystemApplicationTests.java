package com.LibraryManagementSystem;

import com.LibraryManagementSystem.entity.Book;
import com.LibraryManagementSystem.repo.BookRepo;
import com.LibraryManagementSystem.services.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryManagementSystemApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	BookService bookService;

	@MockBean
	BookRepo bookRepo;

	@Test
	public void getAllBooks() {
		List<Book> books = Stream.of(
				new Book(1L,"The Bee Sting","Paul Murray", 2023, "132-1133-486"),
				new Book(2L,"To Kill a Mockingbird", "Harper Lee",1960, "153-5685-124"),
				new Book(3L,"Pride and Prejudice", "Jane Austen", 1883, "734-4689-584"))
				.collect(Collectors.toList());
		when(bookRepo.findAll()).thenReturn(books);
		assertEquals(books.size(), bookService.getAllBooks().size());
	}

	@Test
	public void getBook() {
		Book book = new Book(1L,"The Bee Sting","Paul Murray", 2023, "132-1133-486");
		when(bookRepo.getBookById(1L)).thenReturn((Book) book);
		assertEquals(book, bookService.getBook(1L));
	}

	@Test
	public void addBook() {
		Book book = new Book();
		book.setTitle("The Bee Sting");
		book.setAuthor("Paul Murray");
		book.setPublicationYear(2023);
		book.setIsbn("132-1133-486");
		when(bookRepo.save(book)).thenReturn(book);
		assertEquals(book, bookService.addBook(book));
	}

	@Test
	public void deleteBook() {
		Book book = new Book(1L,"The Bee Sting","Paul Murray", 2023, "132-1133-486");
		bookService.deleteBook(book.getId());
		verify(bookRepo, times(1)).deleteById(book.getId());
	}

}
