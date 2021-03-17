package com.oracle.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.BookData;

@Service
public class BookDataService {

	@Autowired
	private BookDataRepository bookDataRepository;

	public List<BookData> getAllData() {
		return bookDataRepository.findAll();
	}
}
