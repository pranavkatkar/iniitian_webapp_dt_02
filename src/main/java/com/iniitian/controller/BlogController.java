package com.iniitian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iniitian.entity.Blog;
import com.iniitian.entity.Comment;
import com.iniitian.entity.UserProfile;
import com.iniitian.model.BlogBasicModel;
import com.iniitian.model.BlogViewModel;
import com.iniitian.model.CommentModel;
import com.iniitian.service.BlogService;
import com.iniitian.service.CommentService;
import com.iniitian.service.UserProfileService;

@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	
	@Autowired
	private UserProfileService userProfileService;
	
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/blogs/all")	
	public @ResponseBody List<BlogBasicModel> getAllBlogs() {				
		List<BlogBasicModel> blogListModel = new ArrayList<BlogBasicModel>();
		BlogBasicModel blogBasicModel = null;
		UserProfile profile = null;
		
		List<Blog> blogs = this.blogService.getAll();
		for(Blog blog: blogs) {			
			profile = this.userProfileService.get(blog.getUserId());
			blogBasicModel = new BlogBasicModel(blog, profile);			
			blogListModel.add(blogBasicModel);			
		}			
		return blogListModel;		
	}
		
	
	@RequestMapping(value = "/blogs/{id}")	
	public @ResponseBody List<Blog> getUserBlogs(@PathVariable("id") String userId) {		
		return this.blogService.getBlogsByUser(userId);		
	}
	
	@RequestMapping(value = "/blog/{id}")	
	
	public @ResponseBody BlogViewModel getBlog(@PathVariable("id") String blogId) {		
		BlogViewModel blogViewModel = null;	
		Blog blog = this.blogService.get(blogId);
		UserProfile profile = this.userProfileService.get(blog.getUserId());
		blogViewModel = new BlogViewModel(blog, profile);
		
		CommentModel commentModel = null;
		
		// Get all the comments
		List<Comment> comments = this.commentService.getComments(blogId);
		if(comments!=null) {
			for(Comment comment : comments) {
				profile = this.userProfileService.get(comment.getUserId());					
				commentModel = new CommentModel(comment, profile);
				blogViewModel.add(commentModel);
			}		
		}	
		return blogViewModel;		
	}
	
}
