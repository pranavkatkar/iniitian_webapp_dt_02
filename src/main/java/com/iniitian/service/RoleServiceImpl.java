package com.iniitian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.RoleDAO;
import com.iniitian.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	@Override
	@Transactional
	public void add(Role role) {
		this.roleDAO.add(role);
	}

}
