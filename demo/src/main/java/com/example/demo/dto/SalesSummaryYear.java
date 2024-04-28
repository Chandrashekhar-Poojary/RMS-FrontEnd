package com.example.demo.dto;

public class SalesSummaryYear {


	private String category;
	private long totalQuantity;
	private int year;
	
	public SalesSummaryYear() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SalesSummaryYear(String category, long totalQuantity, int year) {
		super();
		this.category = category;
		this.totalQuantity = totalQuantity;
		this.year = year;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
