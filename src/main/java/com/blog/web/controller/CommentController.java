package com.blog.web.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.core.domain.Comment;
import com.blog.core.service.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	@Autowired
	CommentService commentService;

//	@GetMapping("/allcomments")
//	public List<Comment> findAllBlogs() {
//		return commentService.findAllComments();
//
//	}

	@PostMapping("/post/{id}/comment")
	public ResponseEntity<Comment> createBlog(@RequestBody Comment comment, @PathVariable int id)
			throws URISyntaxException {
		Comment result = null;
		try {
			result = commentService.saveComment(comment, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.created(new URI("/blog" + result.getIdComment())).body(result);
	}

	@GetMapping("/post/{id}/comments")
	public ResponseEntity<List<Comment>> findAllComments(@PathVariable int id) throws URISyntaxException {
		List<Comment> result = null;
		try {
			result = commentService.findCommentsByidBlog(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(result);
	}

	@PutMapping("/editComment")
	public ResponseEntity<Comment> editComment(@RequestBody Comment comment) throws URISyntaxException {
		Comment result = null;
		try {
			result = commentService.editComment(comment);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/post/{id}/comments")
	public ResponseEntity<Object> deleteComment(@PathVariable int id) throws URISyntaxException {
		boolean result = false;
		try {
			result = commentService.deleteComment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(result);
	}

}
