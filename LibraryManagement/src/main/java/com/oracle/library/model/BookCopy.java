package com.oracle.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class BookCopy extends AbstractEntity {

	@ManyToOne(cascade = { CascadeType.ALL })
	@JsonBackReference("book_copy")
	private Book book;

	@OneToOne(cascade = { CascadeType.ALL })
	private Shelf shelf;
	
	
	
	
	
	
	
	
	
	
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
}
