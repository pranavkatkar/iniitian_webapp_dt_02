package com.iniitian.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.Category;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ){
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void add(Category category) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Override
	public void remove(Category category) {
		this.sessionFactory.getCurrentSession().remove(category);
	}

	@Override
	public List<Category> getAll() {		
		return this.sessionFactory.getCurrentSession().createQuery("FROM Category").list();
	}

}
