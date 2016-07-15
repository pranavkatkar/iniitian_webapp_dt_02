package com.iniitian.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.Blog;
import com.iniitian.entity.UserProfile;

@Repository
public class BlogDAOImpl implements BlogDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Blog get(String id) {		
		return this.sessionFactory.getCurrentSession().get(Blog.class, id);
	}

	@Override
	public List<Blog> getAll() {		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Blog").list();
	}

	@Override
	public List<Blog> getBlogsByUser(String userId) {		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE userId=?").setParameter(0, userId).list();
	}

	@Override
	public void add(Blog blog) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Override
	public void remove(Blog blog) {
		this.sessionFactory.getCurrentSession().remove(blog);
	}

}
