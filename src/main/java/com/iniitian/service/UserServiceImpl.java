package com.iniitian.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.UserDAO;
import com.iniitian.entity.Role;
import com.iniitian.entity.User;
import com.iniitian.entity.UserProfile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public User get(String id) {		
		return this.userDAO.get(id);		
	}

	
	@Override
	@Transactional	
	public User getByUsername(String username) {		
		return this.userDAO.getByUsername(username);
	}
	
	
	
	@Override
	@Transactional
	public void add(UserProfile profile) {
		
		// Create a new user
		User user = new User();
		// Create a role
		
		// set the time-stamp
		profile.setCreatedAt(new Date());
		profile.setModifiedAt(new Date());
		
		// set the initial value for the user profile
		profile.setNoOfBlogs(new Long(0));
		profile.setNoOfPosts(new Long(0));
		profile.setNoOfFriends(new Long(0));
		
		if(profile.getGender() == 'M') {
			profile.setAvatar("default_male.jpg");
		}
		else {
			profile.setAvatar("default_female.jpg");
		}
		
		// set the user details from profile details
		user.setUsername(profile.getEmailAddress());
		user.setPassword(profile.getRegisterPassword());
		user.setEnabled(true);

		/*
		 * ---------------------------------------------------------
		 * Will shoot an email here to work with activation right
		 * now by default the user profile will be activated
		 * ---------------------------------------------------------
		 * */
		
		
		// set the details about user and profile to and from for bi-directional
		profile.setUser(user);
		user.setUserProfile(profile);
		
		// assign the role
		Role role = new Role();
		role.setId(user.getId());
		role.setUsername(profile.getEmailAddress());
		// Un-Comment the below line for adding an administrator and comment the below line
		//role.setAuthority("ROLE_ADMIN");
		// comment the above line and uncomment the below line for adding a normal user
		role.setAuthority("ROLE_USER");
		
		this.roleService.add(role);
		this.userDAO.add(user);
	}

	@Override
	@Transactional
	public void remove(User user) {
		this.userDAO.remove(user);
	}

}
