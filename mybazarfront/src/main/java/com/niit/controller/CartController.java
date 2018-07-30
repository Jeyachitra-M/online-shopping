
package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAOinterfaces.CartDAO;
import com.niit.DAOinterfaces.ProductDAO;
import com.niit.Model.CartItem;
import com.niit.Model.ProductModel;

@Controller
public class CartController {
@Autowired ProductDAO productdao;
@Autowired CartDAO cartdao;
@RequestMapping("/Addtocart/{productId}")
public String addCartItem(@RequestParam("quantity")int quantity,@PathVariable("productId")int productId,HttpSession session,Model m)
{
	ProductModel product=productdao.getProduct(productId);
	String username=(String) session.getAttribute("username");
	CartItem cartItem=new CartItem();
	cartItem.setProductId(product.getProductId());
	cartItem.setProductName(product.getProductName());
	cartItem.setQuantity(quantity);
	cartItem.setPrice(product.getPrice());
	cartItem.setStatus("NA");
	cartItem.setUsername(username);
	cartdao.addCartItem(cartItem);
	List<CartItem> cartItems=cartdao.showCartItem(username);
	m.addAttribute("cartItem",cartItems);
	m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
	return "Cart";
}
@RequestMapping(value="/updateCartItem/{cartItemId}")
public String updateCartItem(@RequestParam("quantity")int quantity,@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m)
{
	CartItem cartItem=cartdao.getCartItem(cartItemId);
	String username=(String)session.getAttribute("username");
	cartItem.setQuantity(quantity);
	cartdao.updateCartItem(cartItem);
	List<CartItem> cartItems=cartdao.showCartItem(username);
	m.addAttribute("cartItem",cartItems);
	m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
	return "Cart";
}

@RequestMapping(value="/deleteCartItem/{cartItemId}")
public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m)
{
	CartItem cartItem=cartdao.getCartItem(cartItemId);
	String username=(String)session.getAttribute("username");
	cartdao.deleteCartItem(cartItem);
	List<CartItem> cartItems=cartdao.showCartItem(username);
	m.addAttribute("cartItem",cartItems);
	m.addAttribute("totalPurchaseAmount", this.calcTotalPurchaseAmount(cartItems));
	return "Cart";
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

@RequestMapping(value="/continueShopping")
public String continueShopping(Model m){
	m.addAttribute("productList",productdao.listProducts());
	return "ProductDisplay";
}

}
