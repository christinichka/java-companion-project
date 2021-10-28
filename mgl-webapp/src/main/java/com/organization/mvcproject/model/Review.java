package com.organization.mvcproject.model;

public class Review {
	
	private String body;
	private String author;
	private Integer rating;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReviewBody() {
		return body;
	}

	public void setReviewBody(String reviewBody) {
		this.body = reviewBody;
	}
}
