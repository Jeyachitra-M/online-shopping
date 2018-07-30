package com.niit.Implementedclass;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.CategoryDAO;
import com.niit.Model.CategoryModel;

@Transactional
@Repository(value="categorymodel")
public class CategoryDAOimpl implements CategoryDAO
{
	
	
@Autowired
SessionFactory sessionfactory;


	public boolean addCategory(CategoryModel category) {
		try
		{
			sessionfactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public boolean updateCategory(CategoryModel category) {
		try
		{
			sessionfactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
			}

	
	public boolean deleteCategory(CategoryModel category) {
		try
		{
			sessionfactory.getCurrentSession().delete(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}


	public CategoryModel getCategory(int CategoryId) {
		try
		{
			Session session=sessionfactory.getCurrentSession();
			CategoryModel category=(CategoryModel) session.get(CategoryModel.class, CategoryId);
		return category;
		}
		catch(Exception e)
		{
		return null;
		}	}

	
	public List<CategoryModel> listCategories() {
		try
		{
			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery(" from CategoryModel");
			List<CategoryModel> listcategories=query.list();
			
			return listcategories;
		}
		catch(Exception e)
		{
		return null;
		}
	}

		

	
}
