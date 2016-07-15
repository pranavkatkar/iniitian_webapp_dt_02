package com.iniitian.service;

import java.util.List;

import com.iniitian.entity.Forum;

public interface ForumService {
	public Forum get(String id);
	public void add(Forum forum);
	public void remove(Forum forum);
	public List<Forum> getAll();
	public List<Forum> getForumsByCategory(String categoryId);
}
