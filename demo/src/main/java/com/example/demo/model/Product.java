package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@SequenceGenerator(name = "company_sequence", sequenceName = "company_sequence", initialValue = 15001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
	private Integer productId;
	private String productName;
	private String categoryName;
	private Double price;
	private Integer totalRemainingQuantity;
	public Product(String productName, String categoryName, Double price, Integer totalRemainingQuantity) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		this.totalRemainingQuantity = totalRemainingQuantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getTotalRemainingQuantity() {
		return totalRemainingQuantity;
	}
	public void setTotalRemainingQuantity(Integer totalRemainingQuantity) {
		this.totalRemainingQuantity = totalRemainingQuantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryName=" + categoryName + ", price="
				+ price + ", totalRemainingQuantity=" + totalRemainingQuantity + "]";
	}
	public Product() {
		super();
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
