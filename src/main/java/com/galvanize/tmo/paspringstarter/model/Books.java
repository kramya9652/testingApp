package com.galvanize.tmo.paspringstarter.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Books implements Serializable {

	public Books(Integer id, String author, String title, Integer yearPublished) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.yearPublished = yearPublished;
	}
	private Integer id;
	private String  author;
	private String  title;
	private Integer yearPublished;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}
}
