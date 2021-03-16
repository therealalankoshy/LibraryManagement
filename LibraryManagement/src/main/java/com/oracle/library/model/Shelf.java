package com.oracle.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Shelf extends AbstractEntity {
	@Column
	private String sectionName;
}
