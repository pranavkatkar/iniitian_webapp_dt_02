package com.iniitian.dao;

import java.util.List;

import com.iniitian.entity.Blog;
import com.iniitian.entity.Comment;

public interface CommentDAO {

	public Comment get(String id);
	public List<Comment> getComments(String blogId);
	public void add(Comment comment);
	public void remove(Comment comment);
	
}
