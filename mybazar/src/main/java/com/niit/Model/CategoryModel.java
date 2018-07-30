package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Entity
@Table
public class CategoryModel {
	@Id
	@GeneratedValue
	int CategoryId;
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int ccategoryId) {
		CategoryId = ccategoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String ccategoryName) {
		CategoryName = ccategoryName;
	}
	public String getCategoryDesc() {
		return CategoryDesc;
	}
	public void setCategoryDesc(String ccategoryDesc) {
		CategoryDesc = ccategoryDesc;
	}
	String CategoryName;
	String CategoryDesc;
		
}

