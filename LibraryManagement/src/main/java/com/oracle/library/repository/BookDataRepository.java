package com.oracle.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.oracle.library.model.BookData;

public interface BookDataRepository extends JpaRepository<BookData, Integer>,JpaSpecificationExecutor<BookData> {
	

}
