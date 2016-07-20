package com.iniitian.dao;

import java.util.List;

import com.iniitian.entity.Forum;

public interface ForumDAO {
	public Forum get(String id);
	public void add(Forum forum);
	public void remove(Forum forum);
	public List<Forum> getAll();
	public List<Forum> getForumsByCategory(String categoryId);
}
