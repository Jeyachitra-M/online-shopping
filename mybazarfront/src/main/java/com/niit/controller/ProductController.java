package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAOinterfaces.CategoryDAO;
import com.niit.DAOinterfaces.ProductDAO;
import com.niit.DAOinterfaces.SupplierDAO;
import com.niit.Model.CategoryModel;
import com.niit.Model.ProductModel;
import com.niit.Model.SupplierModel;

@Controller
public class ProductController {

	@Autowired ProductDAO productdao;
	@Autowired CategoryDAO categorydao;
	@Autowired SupplierDAO supplierdao;
	@RequestMapping(value="/product")
public String showProduct(Model m)
{
	ProductModel product=new ProductModel();
	m.addAttribute("product1", product);
	m.addAttribute("categoryList",this.getcategory());
	m.addAttribute("supplierlist",this.getsupplier());
	m.addAttribute("productList",productdao.listProducts());
	return "ManageProduct";
}
	
	
	@RequestMapping(value="/totalProductInfo/{productId}")
	public String displayproduct(@PathVariable("productId")int productId,Model m)
	{
		ProductModel product1=productdao.getProduct(productId);
		m.addAttribute("supplier",supplierdao.getSupplier(product1.getSupplierId()).getShopName());
		m.addAttribute("category", categorydao.getCategory(product1.getCategoryId()).getCategoryName());
		m.addAttribute("product", product1);
		
	return "TotalDisplayProduct";
	}
	
@RequestMapping(value="/displayProduct")
	public String displayallproduct(Model m)
	{
	m.addAttribute("productlist",productdao.listProducts());
		
	return "ProductDisplay";
	}
	@RequestMapping(value="/productInsert",method=RequestMethod.POST)
public String insertProduct(@ModelAttribute("product1")ProductModel product,@RequestParam("pimage")MultipartFile imagefile,Model m)
{
	productdao.addProduct(product);
	m.addAttribute("categoryList",this.getcategory());
	m.addAttribute("supplierlist",this.getsupplier());
	ProductModel product2=new ProductModel();
	m.addAttribute("product1",product2);
	String path="E:\\MyMavenProject\\Mybazarfrontend\\src\\main\\webapp\\resources\\images\\";	
	path=path+String.valueOf(product.getProductId()+".jpg");
	File file=new File(path);
	if(!imagefile.isEmpty())
	{
		try
		{
			byte[] buf=imagefile.getBytes();
			FileOutputStream fos=new FileOutputStream(file);
			BufferedOutputStream b=new BufferedOutputStream(fos);
			b.write(buf);
			b.close();
			}
		catch(Exception e)
		{
			System.out.println("Exception occured"+e);
		}
	}
	else
	{
		m.addAttribute("Error Info", "system problem on image insertion");
	}
	
	m.addAttribute("productList",productdao.listProducts());
	System.out.println("product added");
	return "ManageProduct";
}
@RequestMapping(value="/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId")int productid,Model m)
{
	ProductModel p=productdao.getProduct(productid);
	productdao.deleteProduct(p);
	ProductModel product2=new ProductModel();
	m.addAttribute("product1",product2);
	m.addAttribute("productList",productdao.listProducts());	
return "ManageProduct";
}
@RequestMapping(value="/editProduct/{productId}")
public String editProduct(@PathVariable("productId")int productid,Model m)
{
	ProductModel product1=productdao.getProduct(productid);
	m.addAttribute("product",product1);
	m.addAttribute("categoryList",this.getcategory());
	m.addAttribute("supplierlist",this.getsupplier());
	
	m.addAttribute("productList",productdao.listProducts());
	return "UpdateProduct";
	
}
@RequestMapping(value="/updateProduct/{productId}",method=RequestMethod.POST)
public String updateP(@ModelAttribute("product")ProductModel product,Model m)
{
	System.out.println("--------------");
	boolean s = productdao.updateProduct(product);
	System.out.println("====="+s);
	ProductModel product2=new ProductModel();
	m.addAttribute("product1",product2);
	m.addAttribute("categoryList",this.getcategory());
	m.addAttribute("supplierlist",this.getsupplier());
	m.addAttribute("productList",productdao.listProducts());
return "ManageProduct";
}

public LinkedHashMap<Integer,String> getcategory()
{
	List<CategoryModel> listcategory=categorydao.listCategories();
	LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
	for(CategoryModel category:listcategory)
	{
		categoryData.put(category.getCategoryId(),category.getCategoryName());
	}
	return categoryData;
}
public LinkedHashMap<Integer,String> getsupplier()
{
	List<SupplierModel> supplierlist=supplierdao.listSupplier();
	LinkedHashMap<Integer,String> supfromcontroller=new LinkedHashMap<Integer,String>();
	for(SupplierModel supplier:supplierlist)
	{
		supfromcontroller.put(supplier.getSupplierId(),supplier.getShopName());
	}
	return supfromcontroller;
}






}
