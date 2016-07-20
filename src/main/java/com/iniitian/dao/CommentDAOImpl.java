package com.iniitian.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.Blog;
import com.iniitian.entity.Comment;


@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ){
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public Comment get(String id) {
		return this.sessionFactory.getCurrentSession().get(Comment.class, id);
	}

	@Override
	public List<Comment> getComments(String blogId) {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE blogId=? ORDER BY commentedAt DESC").setParameter(0, blogId).list();
	}

	@Override
	public void add(Comment comment) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	@Override
	public void remove(Comment comment) {
		this.sessionFactory.getCurrentSession().remove(comment);
	}

}
