package com.iniitian.dao;

import java.util.List;

import com.iniitian.entity.Blog;
import com.iniitian.entity.UserProfile;

public interface BlogDAO {

	public Blog get(String id);	
	public List<Blog> getAll();
	public List<Blog> getBlogsByUser(String userId);
	public void add(Blog blog);
	public void remove(Blog blog);
	
}
