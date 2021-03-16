package com.oracle.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class BookCopy extends AbstractEntity {

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JsonBackReference("book_copy")
	private Book book;

	@OneToOne
	private Shelf shelf;
}
