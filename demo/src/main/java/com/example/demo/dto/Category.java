package com.example.demo.dto;

import java.util.List;

public class Category {
	
	private String category;
	private List<String> getProduct;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String category, List<String> getProduct) {
		super();
		this.category = category;
		this.getProduct = getProduct;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getGetProduct() {
		return getProduct;
	}
	public void setGetProduct(List<String> getProduct) {
		this.getProduct = getProduct;
	}
	@Override
	public String toString() {
		return "Category [category=" + category + ", getProduct=" + getProduct + "]";
	}
	
}
