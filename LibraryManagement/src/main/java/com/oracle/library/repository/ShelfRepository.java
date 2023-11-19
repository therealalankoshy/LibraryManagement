package com.oracle.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.library.model.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
	
	Shelf findBySectionName(String name);

}
