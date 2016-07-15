package com.iniitian.service;

import java.util.List;

import com.iniitian.entity.Blog;

public interface BlogService {
	public Blog get(String id);
	public List<Blog> getAll();
	public List<Blog> getBlogsByUser(String userId);
	public void add(Blog blog);
	public void remove(Blog blog);
}
