package com.iniitian.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.BlogDAO;
import com.iniitian.entity.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAO blogDAO;
	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
		
	@Override
	@Transactional
	public Blog get(String id) {
		return this.blogDAO.get(id);
	}

	@Override
	@Transactional
	public List<Blog> getAll() {
		return this.blogDAO.getAll();
	}

	@Override
	@Transactional
	public List<Blog> getBlogsByUser(String userId) {
		return this.blogDAO.getBlogsByUser(userId);
	}

	@Override
	@Transactional
	public void add(Blog blog) {
		if(blog.isNewBlog()) {
			blog.setCreatedAt(new Date());
		}
		blog.setModifiedAt(new Date());		
		this.blogDAO.add(blog);
	}

	@Override
	@Transactional
	public void remove(Blog blog) {
		this.blogDAO.remove(blog);
	}

}
