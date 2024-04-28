package com.example.demo.dto;

public class Inventory {
	

	private String companyName;
	private String categoryName;
	private String productName;
	private Integer orderQuantity;
	private Integer totalRemainingQuantity;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(String companyName, String categoryName, String productName, Integer orderQuantity,
			Integer totalRemainingQuantity) {
		super();
		this.companyName = companyName;
		this.categoryName = categoryName;
		this.productName = productName;
		this.orderQuantity = orderQuantity;
		this.totalRemainingQuantity = totalRemainingQuantity;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Integer getTotalRemainingQuantity() {
		return totalRemainingQuantity;
	}
	public void setTotalRemainingQuantity(Integer totalRemainingQuantity) {
		this.totalRemainingQuantity = totalRemainingQuantity;
	}
	
}
