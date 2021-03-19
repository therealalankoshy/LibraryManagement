package com.oracle.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.library.model.Author;
import com.oracle.library.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public Author getAuthor(String author) {
		Author s = authorRepository.findByName(author);
		if (s == null) {
			s = new Author();
			s.setName(author);
		}
		return s;
	}
}
