package com.moviesurl.springboot.controller;

public class MovieObject {
	private String name;
	private String crew;
	private String rating;
	private String rank;
	private String year;
	private String link;

	public MovieObject() {
	}

	public MovieObject(String name, String crew, String rating, String rank, String year, String link) {
		this.setName(name);
		this.setCrew(crew);
		this.setRating(rating);
		this.setRank(rank);
		this.setYear(year);
		this.setLink(link);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}
}
