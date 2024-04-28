package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
@SequenceGenerator(name = "productList_sequence", sequenceName = "productList_sequence", allocationSize = 1)
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productList_sequence")
	private Integer siNo;
	private String category;
	private String productName;
	private Integer quantitySold;
	private String month;
	private Integer year;
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sales(String category, String productName, Integer quantitySold, String month, Integer year) {
		super();
		this.category = category;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.month = month;
		this.year = year;
	}
	public Sales(Integer siNo, String category, String productName, Integer quantitySold, String month, Integer year) {
		super();
		this.siNo = siNo;
		this.category = category;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.month = month;
		this.year = year;
	}
	public Integer getSiNo() {
		return siNo;
	}
	public void setSiNo(Integer siNo) {
		this.siNo = siNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
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
	@Override
	public String toString() {
		return "Sales [siNo=" + siNo + ", category=" + category + ", productName=" + productName + ", quantitySold="
				+ quantitySold + ", month=" + month + ", year=" + year + "]";
	}
	
}
