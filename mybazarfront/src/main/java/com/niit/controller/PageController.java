package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
@RequestMapping(value={"/","Header"})
public String show()
{
	System.out.println("Header invoked!!!");
	return "Header";
}
@RequestMapping(value="/home")
public String showHome()
{
	return "Home";
}
@RequestMapping(value="/login")
public String showLoginPage()
{
	return "Login";
}

@RequestMapping(value="/logout")
public String LoginPage(HttpSession session)
{
	boolean loggedIn = false;
	session.setAttribute("loggedIn", loggedIn);
	return "Login";
}

@RequestMapping(value="/register")
public String showRegisterPage()
{
	return "Register";
}

@RequestMapping(value="/contactus")
public String showContactUs()
{
	return "ContactUs";
}

@RequestMapping(value="/aboutus")
public String showAboutUs()
{
	return "AboutUs";
}

	
}
