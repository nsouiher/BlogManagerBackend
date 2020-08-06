package com.blog.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.core.domain.Blog;

@Repository

public interface BlogRepository extends JpaRepository<Blog, Serializable> {

}
