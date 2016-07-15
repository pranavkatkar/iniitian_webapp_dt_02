package com.iniitian.service;

import java.util.List;
import java.util.Map;

import com.iniitian.entity.Category;

public interface CategoryService {
	public void add(Category category);	
	public void remove(Category category);
	public List<Category> getAll();	
	public Map<String,String> getCategories();
}
