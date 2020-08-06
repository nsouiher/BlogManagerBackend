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

import com.blog.core.domain.Blog;
import com.blog.core.service.BlogService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {
	@Autowired
	BlogService blogService;

	
	@GetMapping("/allBlogs")
	public ResponseEntity<List<Blog>> findAllBlogs() throws URISyntaxException {
		List<Blog> result = null;
		try {
			result = blogService.findAllBlogs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
                .ok()
                .body(result);
	}
	
	@PostMapping("/createblog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) throws URISyntaxException {
		Blog result = null;
		try {
			result = blogService.saveBlog(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
                .created(new URI("/blog" + result.getIdBlog()))
                .body(result);
	}
	@PutMapping("/editBlog")
	public ResponseEntity<Blog> editBlog(@RequestBody Blog blog) throws URISyntaxException {
		Blog result = null;
		try {
			result = blogService.editBlog(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
                .ok()
                .body(result);
	}
	@DeleteMapping("/deleteBlog/{id}")
	public ResponseEntity<Object> deleteBlog(@PathVariable int id) throws URISyntaxException {
		boolean result = false;
		try {
			result = blogService.deleteBlog(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity
                .ok()
                .body(result);
	}
	
}
