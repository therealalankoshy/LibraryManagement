package com.oracle.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.Author;
import com.oracle.library.model.Book;
import com.oracle.library.model.BookCategory;
import com.oracle.library.model.BookCopy;
import com.oracle.library.model.Shelf;
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
		Author author1 = new Author();
		author1.setName("God");
		
		Author author2 = new Author();
		author2.setName("Man");
		authors.add(author1);
		authors.add(author2);

		Book book = new Book();
		book.setName("The Bible");

		BookCategory religion = new BookCategory();
		religion.setName("Religion");
		
		book.setAuthors(authors);
		book.setBookCategory(religion);
		
		BookCopy copy1 = new BookCopy();
		copy1.setBook(book);
		
		BookCopy copy2 = new BookCopy();
		copy2.setBook(book);
		
		List<BookCopy> copies = new ArrayList<BookCopy>();
		copies.add(copy1);
		copies.add(copy2);
		book.setCopies(copies);
		
		Shelf s = new Shelf();
		s.setSectionName("F1");
		copy1.setShelf(s);
		copy2.setShelf(s);
		
		return bookRepository.save(book);
	}
}
