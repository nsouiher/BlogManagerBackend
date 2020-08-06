package com.blog.core.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.core.domain.Blog;
import com.blog.core.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired
	BlogRepository blogRepository;
	public List<Blog> findAllBlogs(){
		return blogRepository.findAll();
	}
	public Blog saveBlog(Blog blog){
		return blogRepository.save(blog);
	}
	public Blog editBlog(Blog blog){
		return blogRepository.saveAndFlush(blog);
	}
	public boolean deleteBlog(int id){
		
		try {
			blogRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
