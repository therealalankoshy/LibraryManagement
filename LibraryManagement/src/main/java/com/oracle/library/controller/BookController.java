package com.oracle.library.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.library.SearchCriteria;
import com.oracle.library.model.Book;
import com.oracle.library.model.BookData;
import com.oracle.library.model.BookUIObject;
import com.oracle.library.service.BookDataService;
import com.oracle.library.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookDataService bookDataService;

	@GetMapping("/api/books")
	@PermitAll
	public List<Book> findAllBooks() {
		return bookService.findAllBooks();
	}

	@PostMapping("/api/book/create")
	@PermitAll
	@Transactional
	public Book createBook(@RequestBody BookUIObject book) {
		return bookService.createBook(book);
	}

	@GetMapping("/api/book")
	@PermitAll
	public List<BookData> findAllData() {
		return bookDataService.getAllData();
	}

	@PostMapping("/api/book/search")
	@PermitAll
	public List<BookData> search(@RequestBody List<SearchCriteria> params) {
		return bookDataService.findWithSearch(params);

	}

}
