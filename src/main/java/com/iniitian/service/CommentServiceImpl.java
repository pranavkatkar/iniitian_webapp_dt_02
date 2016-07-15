package com.iniitian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.CommentDAO;
import com.iniitian.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
		
	@Override
	@Transactional
	public Comment get(String id) {
		return this.commentDAO.get(id);
	}

	@Override
	@Transactional
	public List<Comment> getComments(String blogId) {
		return this.commentDAO.getComments(blogId);
	}

	@Override
	@Transactional
	public void add(Comment comment) {
		this.commentDAO.add(comment);
	}

	@Override
	@Transactional
	public void remove(Comment comment) {
		this.commentDAO.remove(comment);
	}
}
