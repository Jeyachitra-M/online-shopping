package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAOinterfaces.CategoryDAO;
import com.niit.Model.CategoryModel;

@Controller
public class CategoryController {
@Autowired
CategoryDAO categorydao;
boolean flag=false;	
@RequestMapping(value="/category")

public String showCategory(Model m)
{
	flag=false;
	List<CategoryModel> listCategories=categorydao.listCategories();
	m.addAttribute("categorylist",listCategories);
	m.addAttribute("flag",flag);
		return "Category";
}
@RequestMapping(value="/InsertCategory", method=RequestMethod.POST)
public String InsertCategory(@RequestParam("catname")String CategoryName,@RequestParam("catDesc")String CategoryDesc,Model m)
{	
	flag=false;
	CategoryModel catmod=new CategoryModel();
	catmod.setCategoryName(CategoryName);
	catmod.setCategoryDesc(CategoryDesc);
	categorydao.addCategory(catmod);
	List<CategoryModel> list=categorydao.listCategories();
	m.addAttribute("categorylist",list);
	m.addAttribute("flag",flag);
	return "Category";
}
@RequestMapping(value="/deleteCategory/{CategoryID}")
public String deleteCategory(@PathVariable("CategoryID")int CategoryId,Model m)
{
	flag=false;
	CategoryModel category=categorydao.getCategory(CategoryId);
	categorydao.deleteCategory(category);
	List<CategoryModel> list=categorydao.listCategories();
	m.addAttribute("categorylist",list);
	m.addAttribute("flag",flag);
	return "Category";
}

@RequestMapping(value="/editCategory/{categoryID}")
public String editCategory(@PathVariable("categoryID")int CategoryId,Model m)
{
	flag=true;
	CategoryModel category=categorydao.getCategory(CategoryId);
	m.addAttribute("categoryData", category);
	m.addAttribute("flag",flag);
	return "Category";
}
@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
public String updateCategory(@RequestParam("catid")int CategoryId,@RequestParam("catname")String CategoryName,@RequestParam("catDesc")String CategoryDesc,Model m)
{
	flag=false;
	CategoryModel category=categorydao.getCategory(CategoryId);
	category.setCategoryName(CategoryName);
	category.setCategoryDesc(CategoryDesc);
	categorydao.updateCategory(category);
	List<CategoryModel> list=categorydao.listCategories();
	m.addAttribute("categorylist",list);
	m.addAttribute("flag",flag);
	return "Category";
}




}


