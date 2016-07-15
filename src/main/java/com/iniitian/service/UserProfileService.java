package com.iniitian.service;

import com.iniitian.entity.UserProfile;

public interface UserProfileService {
	public UserProfile get(String id);
	public void add(UserProfile profile);
	public void remove(UserProfile profile);
}
