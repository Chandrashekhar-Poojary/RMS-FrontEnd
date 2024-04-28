package com.example.demo.dto;

public class SalesSummaryMonth {

	
	private String category;
	private long totalQuantity;
	private String month;
	private int year;
	
	public SalesSummaryMonth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SalesSummaryMonth(String category, long totalQuantity, String month, int year) {
		super();
		this.category = category;
		this.totalQuantity = totalQuantity;
		this.month = month;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
