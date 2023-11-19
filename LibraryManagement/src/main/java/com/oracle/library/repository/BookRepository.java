package com.oracle.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
