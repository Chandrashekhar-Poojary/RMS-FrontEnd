package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "order_sequence", initialValue = 10001, allocationSize = 1)
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
	private Integer orderId;	
	
	private String companyName;
	private String categoryName;
	private String productName;
	private Integer orderQuantity;
	private Double totalAmount;
	private String orderStatus;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="company_id")
	public Company company;
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Integer orderId, String companyName, String categoryName, String productName,
			Integer orderQuantity, Double totalAmount, String orderStatus) {
		super();
		this.orderId = orderId;
//		this.orderCompanyId = orderCompanyId;
		this.companyName = companyName;
		this.categoryName = categoryName;
		this.productName = productName;
		this.orderQuantity = orderQuantity;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}
	public Orders(String companyName, String categoryName, String productName, Integer orderQuantity, Double totalAmount,
			String orderStatus) {
		super();
		this.companyName = companyName;
		this.categoryName = categoryName;
		this.productName = productName;
		this.orderQuantity = orderQuantity;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
//	public Integer getOrderCompanyId() {
//		return orderCompanyId;
//	}
//	public void setOrderCompanyId(Integer orderCompanyId) {
//		this.orderCompanyId = orderCompanyId;
//	}
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
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", companyName=" + companyName
				+ ", categoryName=" + categoryName + ", productName=" + productName + ", orderQuantity=" + orderQuantity
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
}
