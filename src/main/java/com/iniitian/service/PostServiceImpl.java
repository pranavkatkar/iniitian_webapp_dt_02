package com.iniitian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.PostDAO;
import com.iniitian.entity.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	
	@Override
	@Transactional
	public void add(Post post) {
		this.postDAO.add(post);

	}

	@Override
	@Transactional
	public void remove(Post post) {
		this.postDAO.remove(post);
	}

	@Override
	@Transactional
	public List<Post> getPostsByForum(String forumId) {		
		return this.postDAO.getPostsByForum(forumId);
	}

	@Override
	@Transactional
	public Post get(String postId) {		
		return this.postDAO.get(postId);
	}

}
