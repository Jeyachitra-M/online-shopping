package com.niit.DAOinterfaces;

import java.util.List;

import com.niit.Model.CategoryModel;
import com.niit.Model.ProductModel;

public interface ProductDAO {
	public boolean addProduct(ProductModel product);
	public boolean updateProduct(ProductModel product);
	public boolean deleteProduct(ProductModel product);
	public ProductModel getProduct(int ProductId);
	public List<ProductModel> listProducts();
	public List<ProductModel> listProductsByCategory(int CategoryId);
}
