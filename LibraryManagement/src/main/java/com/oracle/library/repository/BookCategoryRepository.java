package com.oracle.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.library.model.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

	BookCategory findByName(String name);
}
