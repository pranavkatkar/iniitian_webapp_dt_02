package com.iniitian.model;

import java.util.List;

import com.iniitian.entity.Category;
import com.iniitian.entity.Forum;

public class ForumModel {

	private Category category;
	private List<Forum> forums;

	
	public List<Forum> getForums() {
		return forums;
	}
	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
