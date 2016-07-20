package com.iniitian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iniitian.entity.Post;
import com.iniitian.entity.UserProfile;
import com.iniitian.model.PostModel;
import com.iniitian.service.ForumService;
import com.iniitian.service.PostService;
import com.iniitian.service.UserProfileService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
		
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private ForumService forumService;
	
	@RequestMapping(value = "/post/all/{id}")
	public @ResponseBody Map<String,Object> getPosts(@PathVariable("id") String forumId) {	
		List<Post> posts = this.postService.getPostsByForum(forumId);			
		List<PostModel> postModelList = new ArrayList<PostModel>();  		
		
		PostModel postModel = null;
		UserProfile user = null;
		
		for(Post post: posts) {			
			postModel = new PostModel();
			user = this.userProfileService.get(post.getUserId());			
			postModel.setPostId(post.getId());
			postModel.setContent(post.getContent());
			postModel.setPostedAt(post.getPostedAt());
			postModel.setAvatar(user.getAvatar());					
			postModel.setUsername(user.getEmailAddress());
			postModelList.add(postModel);			
		}
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("forum", this.forumService.get(forumId));
		model.put("posts", postModelList);
		
		return model;				
	}
	
}
