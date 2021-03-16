package com.oracle.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BookCategory extends AbstractEntity {
	@Column
	private String name;
}
