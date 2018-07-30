package com.niit.Implementedclass;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAOinterfaces.SupplierDAO;
import com.niit.Model.SupplierModel;
@Repository(value="supplierdao")
@Transactional
public class SupplierDAOimpl implements SupplierDAO {
	@Autowired
	SessionFactory sf;
	
	public boolean addSupplier(SupplierModel supplier) {
		try
		{
		sf.getCurrentSession().save(supplier);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateSupplier(SupplierModel supplier) {
		try
		{
		sf.getCurrentSession().update(supplier);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean deleteSupplier(SupplierModel supplier) {
		try
		{
		sf.getCurrentSession().delete(supplier);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public SupplierModel getSupplier(int SupplierId) {
		Session session=sf.getCurrentSession();
		SupplierModel suppliermod=(SupplierModel) session.get(SupplierModel.class, SupplierId);
		return suppliermod;
	}

	
	public List<SupplierModel> listSupplier() {
		try{
		Session session=sf.getCurrentSession();
		Query query=session.createQuery("from SupplierModel");
		List<SupplierModel> list=query.list();
		return list;
	}
	catch(Exception e)
	{
		return null;
	}
		}
		
	}