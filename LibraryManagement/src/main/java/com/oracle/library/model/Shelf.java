package com.oracle.library.model;

import javax.persistence.OneToOne;

public class Shelf extends AbstractEntity {
	@OneToOne
	private String sectionName;
}
