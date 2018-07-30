package com.niit.DAOinterfaces;

import java.util.List;

import com.niit.Model.CategoryModel;
import com.niit.Model.SupplierModel;

public interface SupplierDAO {
	public boolean addSupplier(SupplierModel supplier);
	public boolean updateSupplier(SupplierModel supplier);
	public boolean deleteSupplier(SupplierModel supplier);
	public SupplierModel getSupplier(int SupplierId);
	public List<SupplierModel> listSupplier();
}