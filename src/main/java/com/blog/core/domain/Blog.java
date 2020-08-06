package com.blog.core.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BLOG")
public class Blog implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String content;
	private String title;
	private String owner;
	private LocalDateTime createdAt;
	private LocalDateTime updateddAt;
	@OneToMany(mappedBy="blog")
	
	private List<Comment> comments;
	public int getIdBlog() {
		return id;
	}
	
	
	public Blog(String content, LocalDateTime createdAt, LocalDateTime updateddAt,String title,String owner, List<Comment> comments) {
		super();
		this.content = content;
		this.title = title;
		this.owner = owner;
		this.createdAt = createdAt;
		this.updateddAt = updateddAt;
		this.comments = comments;
	}

	

	public Blog() {
		super();		
	}

	public void setIdBlog(int idBlog) {
		this.id = idBlog;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdateddAt() {
		return updateddAt;
	}
	public void setUpdateddAt(LocalDateTime updateddAt) {
		this.updateddAt = updateddAt;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	 
	 
}
