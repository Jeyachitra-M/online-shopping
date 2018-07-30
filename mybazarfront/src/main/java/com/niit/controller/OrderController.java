package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAOinterfaces.CartDAO;
import com.niit.Model.CartItem;
import com.niit.Model.OrderDetails;

@Controller
public class OrderController {
	@Autowired
	CartDAO cartdao;
	@RequestMapping(value="/checkout")
	public String checking(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<CartItem> cartItems=cartdao.showCartItem(username);
		m.addAttribute("cartItem",cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
		
	    return "MyOrder";
	}
	
	@RequestMapping(value="/ok")
	public String finalProcess()
	{
		
	    return "Thankyou";
	}
	
	
	@RequestMapping(value="/paymentprocess", method=RequestMethod.POST)
	public String paymentproces(Model m,HttpSession session,@RequestParam("paymenttype")String paymentmode)
	{
		String username=(String) session.getAttribute("username");

		OrderDetails order=new OrderDetails();
		order.setPaymentMode(paymentmode);
		order.setUsername(username);
		List<CartItem> cartItems=cartdao.showCartItem(username);
		m.addAttribute("cartItem",cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
		return "Receipt";
	}
	@RequestMapping(value="/payment")
	public String payment(Model m,HttpSession session)
	{
		String username=(String) session.getAttribute("username");
		List<CartItem> cartItems=cartdao.showCartItem(username);
		m.addAttribute("cartItem",cartItems);
		m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
		return "Payment";
	}
	
	public int calcTotalPurchaseAmount(List<CartItem> cartItems)
	{
		int totalPurchaseAmount=0;
		int deliveryCharge=50;
		int count=0;
		while(count<cartItems.size())
		{
			CartItem cartItem=cartItems.get(count);
			totalPurchaseAmount=totalPurchaseAmount+cartItem.getQuantity()*cartItem.getPrice()+deliveryCharge;
			count++;
		}
		return totalPurchaseAmount;
		
	}
	
	
}
