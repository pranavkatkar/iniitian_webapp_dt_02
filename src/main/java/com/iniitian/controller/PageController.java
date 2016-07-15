package com.iniitian.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iniitian.entity.Category;
import com.iniitian.entity.Role;
import com.iniitian.entity.User;
import com.iniitian.entity.UserProfile;
import com.iniitian.service.CategoryService;
import com.iniitian.service.RoleService;
import com.iniitian.service.UserProfileService;
import com.iniitian.service.UserService;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
		
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	
	@RequestMapping(value = {"/home", "/"})
	public String home() {
		return "guest/home";
	}

	@RequestMapping(value = "/contact")
	public String contact() {
		return "guest/contact";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "guest/about";
	}
	

	@RequestMapping(value = "/blogs")
	public String blogs() {
		return "blog/blogs";
	}		

	
	@RequestMapping(value = "/forums")
	public String forums() {
		return "forum/forums";
	}		

	
	@RequestMapping(value = "/user")
	public String user() {
		return "user/index";
	}		

	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin/index";
	}		

}

