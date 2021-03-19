package com.oracle.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Author findByName(String name);
}
