package com.oracle.library.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

}
