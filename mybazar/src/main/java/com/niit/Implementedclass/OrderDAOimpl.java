package com.niit.Implementedclass;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.OrderDAO;
import com.niit.Model.OrderDetails;

@Repository("orderdetaildao")
@Transactional
public class OrderDAOimpl implements OrderDAO {
	@Autowired 
	SessionFactory sfac;

	public boolean insertOrderDetail(OrderDetails orderDetail) {
		try
		{
			sfac.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateOrderDetail(String username) {
		
		try
		{
			Session session=sfac.getCurrentSession();
			Query query=session.createQuery("update CartItem set status='p' where username=:myusername and status='NA'");
			query.setParameter("myusername", username);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
			
		}
		
	}

	
	

	
}
