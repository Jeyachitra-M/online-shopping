package com.niit.DAOinterfaces;

import com.niit.Model.OrderDetails;

public interface OrderDAO {

	public boolean insertOrderDetail(OrderDetails orderDetail);
	public boolean updateOrderDetail(String username);

}
