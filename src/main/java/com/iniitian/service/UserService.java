package com.iniitian.service;

import com.iniitian.entity.User;
import com.iniitian.entity.UserProfile;

public interface UserService {
	public User get(String id);
	public User getByUsername(String username);
	public void add(UserProfile profile);
	public void remove(User user);		

}
