package com.iniitian.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iniitian.entity.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(Post post) {		
		this.sessionFactory.getCurrentSession().saveOrUpdate(post);
	}

	@Override
	public void remove(Post post) {
		this.sessionFactory.getCurrentSession().remove(post);

	}

	@Override
	public List<Post> getPostsByForum(String forumId) {
/*		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Post p, UserProfile u WHERE p.userId = u.id and p.forumId = ?");
		query.setParameter(0, forumId);
		return query.list();
*/	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Post p WHERE p.forumId = ? order by p.postedAt desc");
		query.setParameter(0, forumId);
		return query.list(); 
	}

	@Override
	public Post get(String postId) {		
		return this.sessionFactory.getCurrentSession().get(Post.class, postId);
	}

}
