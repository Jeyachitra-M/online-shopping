package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SupplierModel {
	@Id
	@GeneratedValue
	int SupplierId;
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierAddr() {
		return SupplierAddr;
	}
	public void setSupplierAddr(String supplierAddr) {
		SupplierAddr = supplierAddr;
	}
	String SupplierName;
	String SupplierAddr;
	String ShopName;
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
}
