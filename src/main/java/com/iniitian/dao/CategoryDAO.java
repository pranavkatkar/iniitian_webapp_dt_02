package com.iniitian.dao;

import java.util.List;

import com.iniitian.entity.Category;

public interface CategoryDAO {
	public void add(Category category);	
	public void remove(Category category);	
	public List<Category> getAll();
}
