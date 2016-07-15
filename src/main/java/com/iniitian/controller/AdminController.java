package com.iniitian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iniitian.entity.Forum;
import com.iniitian.service.CategoryService;
import com.iniitian.service.ForumService;

@Controller
public class AdminController {

	@Autowired
	private ForumService forumService;
	
	
	@Autowired
	private CategoryService categoryService;
		
	
	@RequestMapping(value = {"/admin/forum/{operation}", "/admin/forum/{operation}/{id}"})
	public String forum(@PathVariable("operation") String operation, @PathVariable("id") String id, Model model) {
		String op = null;
		Forum forum = null;
		
		if(operation.equals("edit")) {
			op = "Edit";			
			forum = this.forumService.get(id);
		}
		else {
			op = "Create";
			forum = new Forum();
		}
		model.addAttribute("categories", this.categoryService.getCategories());
		model.addAttribute("operation", op);
		model.addAttribute("forum", forum);
				
		return "admin/cuForum";
	}
		
}
