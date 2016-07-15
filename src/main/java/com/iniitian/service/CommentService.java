package com.iniitian.service;

import java.util.List;

import com.iniitian.entity.Comment;

public interface CommentService {
	public Comment get(String id);
	public List<Comment> getComments(String blogId);
	public void add(Comment comment);
	public void remove(Comment comment);
}
