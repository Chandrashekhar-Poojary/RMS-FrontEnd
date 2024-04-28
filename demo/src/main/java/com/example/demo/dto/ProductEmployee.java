package com.example.demo.dto;

public class ProductEmployee {


	private String productName;
	private String categoryName;
	private int price;
	private int quantity;
	public ProductEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductEmployee(String productName, String categoryName, int price, int quantity) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
