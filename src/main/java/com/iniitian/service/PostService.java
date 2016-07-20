package com.iniitian.service;

import java.util.List;

import com.iniitian.entity.Post;

public interface PostService {

	public void add(Post post);
	public void remove(Post post);
	public List<Post> getPostsByForum(String forumId);
	public Post get(String postId);	
	
	
}
