package com.oracle.library.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.Author;
import com.oracle.library.model.Book;
import com.oracle.library.model.BookCategory;
import com.oracle.library.model.BookCopy;
import com.oracle.library.model.Shelf;
import com.oracle.library.model.BookUIObject;
import com.oracle.library.repository.AuthorRepository;
import com.oracle.library.repository.BookCategoryRepository;
import com.oracle.library.repository.BookRepository;
import com.oracle.library.repository.ShelfRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryService bookCategoryService;

	@Autowired
	private ShelfRepository shelfRepository;
	
	@Autowired
	private AuthorService authorService;

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Book createBook(BookUIObject book) {
		try {
			Book newBook = new Book();
			newBook.setName(book.getBookName());
			List<BookCopy> copies = new LinkedList<BookCopy>();
			List<Author> authors = new LinkedList<Author>();
			book.getAuthors().forEach(auth -> {
				authors.add(authorService.getAuthor(auth));
			});
			newBook.setAuthors(authors);
			book.getShelfNames().forEach(copy -> {
				BookCopy bookCopy = new BookCopy();
				bookCopy.setBook(newBook);
				Shelf s = shelfRepository.findBySectionName(copy);
				if (s == null) {
					s = new Shelf();
					s.setSectionName(copy);
				}
				bookCopy.setShelf(s);
				copies.add(bookCopy);
			});
			newBook.setBookCategory(bookCategoryService.getCategory(book.getCategoryName()));
			newBook.setCopies(copies);
			return bookRepository.save(newBook);
		} catch (Exception e) {
			throw new IllegalStateException(
					"An error occured while creating a new Book");
		}
	}
}
