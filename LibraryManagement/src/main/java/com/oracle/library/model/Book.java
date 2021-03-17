package com.oracle.library.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book extends AbstractEntity {
	@Column
	private String name;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;
	
	@JsonManagedReference("book_copy")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<BookCopy> copies;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private BookCategory bookCategory;
	
	
	
	
	
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}

}
