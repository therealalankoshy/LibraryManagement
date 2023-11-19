package com.oracle.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	protected Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@CreationTimestamp
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	@UpdateTimestamp
	private Date lastUpdated;
}