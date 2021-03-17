package com.oracle.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BookCategory extends AbstractEntity {
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
