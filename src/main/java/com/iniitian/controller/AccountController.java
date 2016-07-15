package com.iniitian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iniitian.entity.User;
import com.iniitian.entity.UserProfile;
import com.iniitian.service.UserService;


@Controller
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam(value = "registration", required = false) String registration, Model model) {
		if(registration!=null) {
			model.addAttribute("registration", "Thanks for registering with us! Please login again to continue");
		}
		model.addAttribute("profile", new UserProfile());
		return "account/login";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register (@Valid @ModelAttribute("profile") UserProfile profile, BindingResult results, Model model) {
		if(results.hasErrors()) {
			return "account/login";
		}

		logger.error(profile.toString());
		this.userService.add(profile);
		
		return "redirect:login?registration=new";
	}	
	

	@RequestMapping(value="/user/dashboard", method = RequestMethod.GET)
	public String dashboard (Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		model.addAttribute("profile", profile);
		return "user/index";		
	}	
	
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	    return "redirect:/home";
	}	
	
}	
