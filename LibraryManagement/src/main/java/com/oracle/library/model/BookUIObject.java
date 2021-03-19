package com.oracle.library.model;

import java.util.List;

public class BookUIObject {

	private String bookName;
	private List<String> authors;
	private String categoryName;
	private List<String> shelfNames;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getShelfNames() {
		return shelfNames;
	}
	public void setShelfNames(List<String> shelfNames) {
		this.shelfNames = shelfNames;
	}
}
