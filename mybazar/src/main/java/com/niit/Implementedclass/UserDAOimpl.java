package com.niit.Implementedclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.UserDAO;
import com.niit.Model.UserModel;

@Repository(value="usermodel")
@Transactional
public class UserDAOimpl implements UserDAO{
@Autowired
SessionFactory sf;


public boolean registerUserDetail(UserModel user) {
	 try
	 {
		 sf.getCurrentSession().save(user);
		 return true;
	 }
	 catch(Exception e)
	 {
		 return false;
	 }
}


public boolean updateUserDetail(UserModel user) {
	 try
	 {
		 sf.getCurrentSession().save(user);
		 return true;
	 }
	 catch(Exception e)
	 {
		 return false;
	 }}


public UserModel getUserDetail(String UserName) {
	try{
		Session session=sf.getCurrentSession();
	UserModel usermod=(UserModel) session.get(UserModel.class,UserName);
	return usermod;
	}
		catch(Exception e)
		{
			return null;
		}
}

}
