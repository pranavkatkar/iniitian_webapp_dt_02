package com.iniitian.model;

import com.iniitian.entity.User;
import com.iniitian.entity.UserProfile;

public class UserModel {

	
	private UserProfile profile;
	private User user;
	
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
