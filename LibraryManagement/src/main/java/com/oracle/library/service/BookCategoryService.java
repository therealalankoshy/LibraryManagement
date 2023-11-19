package com.oracle.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.Author;
import com.oracle.library.model.BookCategory;
import com.oracle.library.repository.BookCategoryRepository;

@Service
public class BookCategoryService {
	
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public BookCategory getCategory(String categoryName) {
		BookCategory s = bookCategoryRepository.findByName(categoryName);
		if (s == null) {
			s = new BookCategory();
			s.setName(categoryName);
		}
		return s;
	}

}
