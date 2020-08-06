package com.blog.core.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COMMENTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComment;
	private String content;
	private String username;
	private LocalDateTime createdAt;
	private LocalDateTime updateddAt;

	
	
	public int getIdComment() {
		return idComment;
	}

	public Comment(String content, String username, LocalDateTime createdAt, LocalDateTime updateddAt, Blog blog) {
		super();
		this.content = content;
		this.username = username;
		this.createdAt = createdAt;
		this.updateddAt = updateddAt;
		this.blog = blog;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="blog_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Blog blog;
 
	public Comment() {
		super();		
	}
}
