package com.iniitian.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.Category;
import com.iniitian.entity.Forum;

@Repository
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ){
		this.sessionFactory = sessionFactory;
	}
		
	
	@Override
	public Forum get(String id) {		
		return this.sessionFactory.getCurrentSession().get(Forum.class, id);
	}

	@Override
	public void add(Forum forum) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(forum);		
	}

	@Override
	public void remove(Forum forum) {
		this.sessionFactory.getCurrentSession().remove(forum);		
	}

	@Override
	public List<Forum> getAll() {		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Forum").list();
	}

	@Override
	public List<Forum> getForumsByCategory(String categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Forum WHERE categoryId = ?");
		query.setParameter(0, categoryId);
		return query.list();
	}

}
