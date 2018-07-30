package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAOinterfaces.ProductDAO;
import com.niit.DAOinterfaces.UserDAO;
import com.niit.Model.UserModel;

@Controller
public class UserController {

	@Autowired
	ProductDAO productdao;
	@Autowired
	UserDAO userdao;
@RequestMapping("/login_success")
	public String loginSuccess(Model m,HttpSession session)
	{
	String page="";
	boolean loggedIn=false;
	SecurityContext securityContext=SecurityContextHolder.getContext();
	Authentication authentication=securityContext.getAuthentication();
	String username=authentication.getName();
	Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
	for(GrantedAuthority role:roles)
	{
		session.setAttribute("role", role.getAuthority());
		if(role.getAuthority().equals("ROLE_USER"))
		{
			loggedIn=true;
			page="ProductDisplay";
			m.addAttribute("productlist",productdao.listProducts());
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username",username);
		}
		else
		{
			loggedIn=true;
			page="AdminHome";
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username",username);
		}
	}
	System.out.println("Login successflly");
	return page;
	}
@RequestMapping("/registration")
public String register(Model m,HttpSession session,@RequestParam("customername")String customerName,@RequestParam("username")String userName,@RequestParam("password")String pass,@RequestParam("phone")String mob,@RequestParam("address")String Add,@RequestParam("email")String email){
	
	UserModel user=new UserModel();
	user.setCustomerName(customerName);
	user.setUserName(userName);
	user.setEmail(email);
	user.setPassWord(pass);
	user.setMobile(mob);
	user.setRole("ROLE_USER");
	user.setAddress(Add);
	user.setEnabled("TRUE");
	userdao.registerUserDetail(user);
System.out.println("user registered successfully");
	
	return "Home";
}
	
}
