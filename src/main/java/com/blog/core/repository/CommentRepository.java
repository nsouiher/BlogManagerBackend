package com.blog.core.repository;

import java.io.Serializable;
import java.util.List;

import com.blog.core.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Serializable>{
	
	public List<Comment> findByBlogId(int id);

}
