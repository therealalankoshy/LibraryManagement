package com.oracle.library.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.library.BookDataSpecificationsBuilder;
import com.oracle.library.SearchCriteria;
import com.oracle.library.model.Book;
import com.oracle.library.model.BookData;
import com.oracle.library.repository.BookDataService;
import com.oracle.library.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookDataService bookDataService;

	@GetMapping("api/books")
	@PermitAll
	public List<Book> findAllBooks() {
		return bookService.findAllBooks();
	}

	@GetMapping("/api/add")
	@PermitAll
	public Book addBook() {
		return bookService.addBook();
	}

	@GetMapping("/api/view/book")
	@PermitAll
	public List<BookData> findAllData() {
		return bookDataService.getAllData();
	}
	
	@GetMapping("/api/view/test")
	@PermitAll
	public List<BookData> test() {
		return bookDataService.test();
	}
	
	@PostMapping("/api/view/test2")
	@PermitAll
    public List<BookData> search(@RequestBody List<SearchCriteria> params) {
		return bookDataService.findWithSearch(params);

    }

}
