package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", initialValue = 5001, allocationSize = 1)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_sequence")
	private Integer customerId;
	private String customerName;
	private String customerNumber;
	private String month;
	private Integer year;
	

	@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductList> productList;
	
	private Long totalAmount;
	public Customer() {
		}
	
	public Customer(String customerName, String customerNumber, String month, Integer year,
			List<ProductList> productList, Long totalAmount) {
		super();
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.month = month;
		this.year = year;
		this.productList = productList;
		this.totalAmount = totalAmount;
	}

	public Customer(Integer customerId, String customerName, String customerNumber, String month, Integer year,
			List<ProductList> productList, Long totalAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.month = month;
		this.year = year;
		this.productList = productList;
		this.totalAmount = totalAmount;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<ProductList> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerNumber="
				+ customerNumber + ", month=" + month + ", year=" + year + ", productList=" + productList
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
	
	

}
