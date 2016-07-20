package com.iniitian.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iniitian.entity.Category;
import com.iniitian.entity.Forum;
import com.iniitian.entity.Post;
import com.iniitian.entity.UserProfile;
import com.iniitian.model.CommentModel;
import com.iniitian.model.ForumBasicModel;
import com.iniitian.model.ForumModel;
import com.iniitian.model.ForumViewModel;
import com.iniitian.model.PostModel;
import com.iniitian.service.CategoryService;
import com.iniitian.service.ForumService;
import com.iniitian.service.PostService;
import com.iniitian.service.UserProfileService;

@RestController
public class ForumController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserProfileService userProfileService;

	@RequestMapping(value = "/forum/all")
	public @ResponseBody List<ForumModel> getForums() {
		// Create a list of forum model
		List<ForumModel> list = new ArrayList<ForumModel>();
		List<Forum> forums = null;
		List<Category> categories = this.categoryService.getAll();
		ForumModel model = null;
		for(Category category: categories) {
			forums = this.forumService.getForumsByCategory(category.getId());
			model = new ForumModel();
			model.setCategory(category);
			model.setForums(forums);
			list.add(model);
		}
		
		return list;		
	}
	
	
	@RequestMapping(value = "/forums/all")
	public @ResponseBody List<ForumBasicModel> getPublicForums() {
		
		List<ForumBasicModel> listForumBasicModel = new ArrayList<ForumBasicModel>();
		// get all the categories first
		List<Category> categories = this.categoryService.getAll();
		
		ForumBasicModel forumBasicModel = null;
		List<Forum> forumList = null;
		
		for(Category category: categories) {
			// fetch all the forums based on categories
			forumList = this.forumService.getForumsByCategory(category.getId());
			
			if(forumList!=null) {				
				for(Forum forum: forumList) {
					forumBasicModel = new ForumBasicModel(category, forum);
					listForumBasicModel.add(forumBasicModel);
				}				
			}
			
		}
		
		return listForumBasicModel;		
	}
	
	@RequestMapping(value = "/get/forum/{forumId}")
	public @ResponseBody ForumViewModel getForumView(@PathVariable("forumId") String forumId) {		
		Forum forum = this.forumService.get(forumId);		
		ForumViewModel forumViewModel = new ForumViewModel(forum);
		
		PostModel postModel = null;
		UserProfile profile = null;
		// Get all the posts
		List<Post> posts = this.postService.getPostsByForum(forumId);
		if(posts!=null) {
			for(Post post: posts) {
				profile = this.userProfileService.get(post.getUserId());					
				postModel = new PostModel(post, profile);
				forumViewModel.add(postModel);
			}
		}
		 				
		return forumViewModel;
		
	}
	
	
}
