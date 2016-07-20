package com.iniitian.controller;

import java.io.File;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.iniitian.entity.Blog;
import com.iniitian.entity.Comment;
import com.iniitian.entity.Post;
import com.iniitian.entity.UserProfile;
import com.iniitian.service.BlogService;
import com.iniitian.service.CommentService;
import com.iniitian.service.PostService;
import com.iniitian.service.UserProfileService;
import com.iniitian.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value ="/user/blogs")
	public String userBlogs(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		model.addAttribute("profile", profile);				
		return "user/blogs";		
	}
	
	
	@RequestMapping(value = "/user/view/blog/{id}")
	public String userBlog(@PathVariable("id") String blogId, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		model.addAttribute("profile", profile);
		model.addAttribute("blogId", blogId);				
		return "user/blog";
	}		
	
	
	@RequestMapping(value = "/user/blog/add")
	public String addBlog(Model model) { 		
		String op = "Create";
		Blog blog = new Blog();
		blog.setNewBlog(true);
		model.addAttribute("operation", op);
		model.addAttribute("blog", blog);
		return "user/cuBlog";				
	}
	
	@RequestMapping(value = "/user/blog/edit/{id}")
	public String editForum(@PathVariable(value = "id") String id, Model model) {
		String op = "Edit";
		Blog blog = this.blogService.get(id);
		model.addAttribute("operation", op);
		model.addAttribute("blog", blog);
		return "user/cuBlog";
	}
	
	
	@RequestMapping(value = "/user/blog/save", method = RequestMethod.POST)
	public String saveForum(@Valid @ModelAttribute("blog") Blog blog, BindingResult results, Model model) {
		if(results.hasErrors()) {			
			return "user/cuBlog";
		}		
		logger.debug(blog.toString());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		blog.setUserId(profile.getId());		
		this.blogService.add(blog);
		return "redirect:/user/blogs?operation=success";		
	}
		

	@RequestMapping(value = "/user/comment/save/{blogId}", method = RequestMethod.POST)
	public String saveComment(@PathVariable("blogId") String blogId, @Valid @ModelAttribute("comment") Comment comment, BindingResult results, Model model) {
		if(results.hasErrors()) {			
			return "blog/viewBlog";
		}		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		comment.setUserId(profile.getId());		
		comment.setBlogId(blogId);
		comment.setCommentedAt(new Date());
		this.commentService.add(comment);
		return "redirect:/view/blog/"+blogId;		
	}

	
	@RequestMapping(value = "/user/post/save/{forumId}", method = RequestMethod.POST)
	public String savePost(@PathVariable("forumId") String forumId, @Valid @ModelAttribute("forumPost") Post post, BindingResult results, Model model) {
		if(results.hasErrors()) {			
			return "forum/viewForum";
		}		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserProfile profile = this.userService.getByUsername(username).getUserProfile();
		post.setUserId(profile.getId());		
		post.setForumId(forumId);
		post.setPostedAt(new Date());
		this.postService.add(post);
		return "redirect:/public/view/forum/"+forumId;		
	}	
	
	
	@RequestMapping(value = "/user/edit/{userId}")
	public String editUser(@PathVariable("userId") String userId, Model model) {
		UserProfile profile = this.userService.get(userId).getUserProfile();
		model.addAttribute("profile", profile);
		model.addAttribute("operation", "Edit");
		return "user/editProfile";		
	}		
	
	
	@RequestMapping(value = "/user/profile/save", method = RequestMethod.POST)
	public String saveProfile(@Valid @ModelAttribute("profile") UserProfile profile, BindingResult results, Model model) { 
		if(results.hasErrors()) {
			return "user/editProfile";
		}
		
		// call to upload the file
		if(!(profile.getFile().getOriginalFilename().equals(""))) {
			profile.setAvatar(uploadImage(profile.getFile(), profile.getId()));
		}
		
		profile.setModifiedAt(new Date());
		this.userProfileService.add(profile);		
				
		return "redirect:/user/dashboard";
		
	}
	
	
	// helper to upload the file
	protected String uploadImage(MultipartFile multipartFile, String userId) {
		
		String folderToUpload = "/resources/images/profile/";
		
		//1. get the filename
		String filename = multipartFile.getOriginalFilename();
		
		// 2. get the real path and create the directory
		// if it does not exists
		String realPath = request.getServletContext().getRealPath(folderToUpload);
		if(!new File(realPath).exists()) {
			new File(realPath).mkdirs();
		}
						
		// 3. transfer the file
		String filePath = realPath + "\\" + userId + filename.substring(filename.lastIndexOf("."));
		File destination = new File(filePath);
		try { multipartFile.transferTo(destination);	}
		catch(Exception ex) {}
		
		// 4. Return the filename
		return userId + filename.substring(filename.lastIndexOf("."));		
		
	}
		
	
	@RequestMapping(value = "/user/remove/blog/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeUserBlog(@PathVariable("id") String blogId, Principal principal) {		
		Blog blog = this.blogService.get(blogId);

		// First remove all the comments associated with the blog
		List<Comment> comments  = this.commentService.getComments(blogId);
		if(comments !=null) {
			for(Comment comment: comments) {
				this.commentService.remove(comment);
			}
		}		
		// remove the blog
		this.blogService.remove(blog);	
	}		
	
	
}
