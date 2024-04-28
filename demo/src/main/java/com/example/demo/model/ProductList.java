package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table
@Entity
@SequenceGenerator(name = "productList_sequence", sequenceName = "productList_sequence", allocationSize = 1)
public class ProductList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productList_sequence")
	private Integer siNo;
	private String productName;
	private String categoryName;
	private Integer quantity;
	private Integer price;
	private Long sumAmount;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ProductList() {
	}
	
	public ProductList(String productName, String categoryName, Integer quantity, Integer price, Long sumAmount,
			Customer customer) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.price = price;
		this.sumAmount = sumAmount;
		this.customer = customer;
	}
	public Integer getSiNo() {
		return siNo;
	}
	public ProductList(Integer siNo, String productName, String categoryName, Integer quantity, Integer price,
			Long sumAmount, Customer customer) {
		super();
		this.siNo = siNo;
		this.productName = productName;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.price = price;
		this.sumAmount = sumAmount;
		this.customer = customer;
	}
	public void setSiNo(Integer siNo) {
		this.siNo = siNo;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(Long sumAmount) {
		this.sumAmount = sumAmount;
	}
	@Override
	public String toString() {
		return "ProductList [siNo=" + siNo + ", productName=" + productName + ", categoryName=" + categoryName
				+ ", quantity=" + quantity + ", price=" + price + ", sumAmount=" + sumAmount + ", customer=" + customer
				+ "]";
	}
	
	
	
}
