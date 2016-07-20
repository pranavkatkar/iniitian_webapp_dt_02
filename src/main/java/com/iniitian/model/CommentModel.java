package com.iniitian.model;

import java.util.Date;

import com.iniitian.entity.Comment;
import com.iniitian.entity.UserProfile;

public class CommentModel {
	
	private String firstName;
	private String lastName;	
	private String content;
	private Date commentedAt;
	
	
	public CommentModel() {}
	
	public CommentModel(Comment comment, UserProfile profile) {
		this.firstName = profile.getFirstName();
		this.lastName = profile.getLastName();
		this.content = comment.getContent();
		this.commentedAt = comment.getCommentedAt();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentedAt() {
		return commentedAt;
	}
	public void setCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
	}
				
}
