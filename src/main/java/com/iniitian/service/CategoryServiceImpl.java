package com.iniitian.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iniitian.dao.CategoryDAO;
import com.iniitian.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
		
	@Override
	@Transactional
	public void add(Category category) {
		this.categoryDAO.add(category);
	}

	@Override
	@Transactional
	public void remove(Category category) {
		this.categoryDAO.remove(category);
	}

	@Override
	@Transactional
	public List<Category> getAll() {		
		return this.categoryDAO.getAll();
	}

	@Override
	public Map<String, String> getCategories() {		
		List<Category> categoryList = this.getAll();
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		for(Category category: categoryList) {
			map.put(category.getId(), category.getName());
		}		
		return map;
	}

}
