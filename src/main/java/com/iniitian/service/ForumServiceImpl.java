package com.iniitian.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.ForumDAO;
import com.iniitian.entity.Forum;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumDAO forumDAO;
	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}

	@Override
	@Transactional
	public Forum get(String id) {
		return this.forumDAO.get(id);
	}

	@Override
	@Transactional
	public void add(Forum forum) {
		if(forum.isNewForum()) {
			forum.setCreatedAt(new Date());
		}
		forum.setModifiedAt(new Date());
		this.forumDAO.add(forum);
	}

	@Override
	@Transactional
	public void remove(Forum forum) {
		this.forumDAO.remove(forum);
	}

	@Override
	@Transactional
	public List<Forum> getAll() {
		return this.forumDAO.getAll();
	}

	@Override
	@Transactional
	public List<Forum> getForumsByCategory(String categoryId) {
		return this.forumDAO.getForumsByCategory(categoryId);
	}

}
