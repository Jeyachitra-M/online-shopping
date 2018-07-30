package com.niit.DAOinterfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.CategoryModel;
public interface CategoryDAO {
	

	public boolean addCategory(CategoryModel category);
	public boolean updateCategory(CategoryModel category);
	public boolean deleteCategory(CategoryModel category);
	public CategoryModel getCategory(int CategoryId);
	public List<CategoryModel> listCategories();
		
}