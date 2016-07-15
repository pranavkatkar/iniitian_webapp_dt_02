package com.iniitian.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	
	@Override
	public User get(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);		
	}

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void remove(User user) {
		sessionFactory.getCurrentSession().remove(user);
	}


	@Override
	public User getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User AS u WHERE u.username=?");
		query.setParameter(0, username);
		return (User)query.uniqueResult();
	}

}
