package com.niit.Implementedclass;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.CartDAO;
import com.niit.Model.CartItem;

@Transactional
@Repository(value = "cart")
public class ImplCart implements CartDAO {

@Autowired 
SessionFactory sessionfactory;

public boolean addCartItem(CartItem cartItem) {
	try
	{
		sessionfactory.getCurrentSession().save(cartItem);
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

public boolean updateCartItem(CartItem cartItem) {
	try
	{
		sessionfactory.getCurrentSession().update(cartItem);
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

public boolean deleteCartItem(CartItem cartItem) {
	try
	{
		sessionfactory.getCurrentSession().delete(cartItem);
	return true;
	}
	catch(Exception e)
	{
	return false;
	}
}

public List<CartItem> showCartItem(String username) {
	try
	{
		Session session=sessionfactory.getCurrentSession();
	Query query=session.createQuery("from CartItem where username=:myusername and status='NA'");
	query.setParameter("myusername",username);
	List<CartItem> listCartItem=(List<CartItem>)query.list();
	return listCartItem;
	}
	catch(Exception e)
	{
		return null;
	}
}

public CartItem getCartItem(int cartItemId) {
	try
	{
		Session session=sessionfactory.getCurrentSession();
		CartItem cartItem=(CartItem) session.get(CartItem.class, cartItemId);
		return cartItem;
	}
	catch(Exception e)
	{
		return null;
	}
}
	
}
