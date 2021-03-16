package com.oracle.library.model;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class BookCopy extends AbstractEntity {

//    @ManyToOne(cascade = {CascadeType.REFRESH})
//    @JsonBackReference("book_copy")
	private Book book;

	@OneToOne
	private Shelf shelf;
}
