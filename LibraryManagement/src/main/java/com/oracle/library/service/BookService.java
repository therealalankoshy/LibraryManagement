package com.oracle.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.Author;
import com.oracle.library.model.Book;
import com.oracle.library.model.BookCategory;
import com.oracle.library.repository.BookCategoryRepository;
import com.oracle.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book addBook() {

		List<Author> authors = new ArrayList<Author>();
		Author author = new Author();
		author.setName("R L Stevenson");
		authors.add(author);

		Book book = new Book();
		book.setName("Treasure Island");

		BookCategory category = bookCategoryRepository.findByName("FANTASY");
		book.setAuthors(authors);
		book.setBookCategory(category);
		return bookRepository.save(book);
	}
}
