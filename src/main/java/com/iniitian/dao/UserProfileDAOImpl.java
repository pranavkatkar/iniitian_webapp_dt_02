package com.iniitian.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.UserProfile;
@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserProfile get(String id) {		
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserProfile.class, id);
	}

	@Override
	public void add(UserProfile profile) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profile);
	}

	@Override
	public void remove(UserProfile profile) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(profile);
	}

}
