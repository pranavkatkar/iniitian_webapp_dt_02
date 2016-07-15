package com.iniitian.dao;

import com.iniitian.entity.UserProfile;

public interface UserProfileDAO {
	public UserProfile get(String id);
	public void add(UserProfile profile);
	public void remove(UserProfile profile);		
}
