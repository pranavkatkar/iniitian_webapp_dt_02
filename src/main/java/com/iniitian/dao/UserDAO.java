package com.iniitian.dao;

import com.iniitian.entity.User;

public interface UserDAO {
	public User get(String id);
	public User getByUsername(String username);
	public void add(User user);
	public void remove(User user);		

}
