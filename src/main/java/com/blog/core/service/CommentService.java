package com.blog.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.core.domain.Comment;
import com.blog.core.repository.BlogRepository;
import com.blog.core.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	BlogRepository blogRepository;

	public List<Comment> findAllComments() {
		return commentRepository.findAll();
	}

	public Comment saveComment(Comment comment, int id) {
		blogRepository.findById(id).map(blog -> {
			comment.setBlog(blog);
			return commentRepository.save(comment);
		});
		return comment;
	}

	public Comment editComment(Comment comment) {
		return commentRepository.saveAndFlush(comment);
	}

	public boolean deleteComment(int id) {
		try {
			commentRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Comment> findCommentsByidBlog(int id) {
		return commentRepository.findByBlogId(id);
	}
}
