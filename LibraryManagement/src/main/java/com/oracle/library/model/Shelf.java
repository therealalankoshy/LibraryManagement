package com.oracle.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Shelf extends AbstractEntity {
	@Column
	private String sectionName;
	
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}
