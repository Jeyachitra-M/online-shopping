package com.niit.Implementedclass;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.ProductDAO;
import com.niit.Model.CategoryModel;
import com.niit.Model.ProductModel;
@Repository(value="productmodel")
@Transactional
public class ProductDAOimpl implements ProductDAO{

	@Autowired
	SessionFactory sf;
	
	public boolean addProduct(ProductModel product) {
		try
		{
			sf.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateProduct(ProductModel product) {
		try
		{
			sf.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	
	public boolean deleteProduct(ProductModel product) {
		try
		{
			sf.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public ProductModel getProduct(int ProductId) {
try
{
	Session session=sf.getCurrentSession();
		ProductModel productget=(ProductModel) session.get(ProductModel.class, ProductId);
		return productget;
}

	catch(Exception e)
{
		return null;
		}
}

	
	public List<ProductModel> listProducts() {
		try
		{
			Session session=sf.getCurrentSession();
			Query query=session.createQuery("from ProductModel");
			List<ProductModel> listproduct=query.list();
			return listproduct;
		}
		catch(Exception e)
		{
			return null;
		}
	}


	public List<ProductModel> listProductsByCategory(int CategoryId) {
		try
		{
			Session session=sf.getCurrentSession();
			Query query=session.createQuery("from ProductModel where CategoryId=:catId");
			query.setParameter("catId",CategoryId);
			List<ProductModel> listproduct=query.list();
			return listproduct;
		}
		catch(Exception e)
		{
			return null;
		}
			
		}
	}
