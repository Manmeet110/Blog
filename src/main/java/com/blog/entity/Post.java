package com.blog.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	private LocalDate date;

	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Author> author;

	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Comment> comment;

	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Tag> tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public Post(int id, String title, String description, LocalDate date, List<Author> author, List<Comment> comment,
			List<Tag> tag) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.author = author;
		this.comment = comment;
		this.tag = tag;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", author="
				+ author + ", comment=" + comment + ", tag=" + tag + "]";
	}

}
