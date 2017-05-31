package com.myspringboot.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String author;
	
	private String summary;
	
	@Column(name = "public_time")
	private Timestamp publicTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Timestamp getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(Timestamp publicTime) {
		this.publicTime = publicTime;
	}
}
