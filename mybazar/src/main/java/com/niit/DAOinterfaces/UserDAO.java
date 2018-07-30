package com.niit.DAOinterfaces;

import com.niit.Model.UserModel;

public interface UserDAO {
	public boolean registerUserDetail(UserModel user);
	public boolean updateUserDetail(UserModel user);
	public UserModel getUserDetail(String UserName);

}
