package com.oracle.library.model;

import javax.persistence.OneToOne;

public class BookCopy extends AbstractEntity {

	@OneToOne
	private Book book;

	@OneToOne
	private Shelf shelf;
}
