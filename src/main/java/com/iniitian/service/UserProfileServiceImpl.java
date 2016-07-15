package com.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.UserProfileDAO;
import com.iniitian.entity.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired	
	private UserProfileDAO userProfileDAO;
	public void setUserProfileDAO(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}
	
	@Override
	@Transactional
	public UserProfile get(String id) {
		return this.userProfileDAO.get(id);
	}

	@Override
	@Transactional
	public void add(UserProfile profile) {
		this.userProfileDAO.add(profile);
	}

	@Override
	@Transactional
	public void remove(UserProfile profile) {		
		this.userProfileDAO.remove(profile);
	}

}
