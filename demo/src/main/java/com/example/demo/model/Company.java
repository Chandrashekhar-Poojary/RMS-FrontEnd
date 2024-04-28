package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "company_sequence", sequenceName = "company_sequence", initialValue = 101, allocationSize = 1)
public class Company {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private int companyId;
	
	private String companyName;
	private Long contactNo;
	private String ownerName;
	private String categoryName;
	private List<String> companyProductId;
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> order;
	
	public Company() {
		super();
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getContactNo() {
		return contactNo;
	} 

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getCompanyProductId() {
		return companyProductId;
	}

	public void setCompanyProductId(List<String> companyProductId) {
		this.companyProductId = companyProductId;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", contactNo=" + contactNo + ", ownerName="
				+ ownerName + ", categoryName=" + categoryName + ", companyProductId=" + companyProductId + "]";
	}

	public Company(String categoryName, String companyName,Long contactNo, String ownerName,List<String> companyProductId,Integer companyId 
			) {
		super();
		this.categoryName = categoryName;
		this.companyName = companyName;
		this.contactNo = contactNo;
		this.ownerName = ownerName;
		this.companyProductId = companyProductId;
		this.companyId = companyId;
	}

	public Company(String categoryName, String companyName,Long contactNo, String ownerName,List<String> companyProductId) {
		super();
		this.categoryName = categoryName;
		this.companyName = companyName;
		this.contactNo = contactNo;
		this.ownerName = ownerName;
		this.companyProductId= companyProductId;
	}

	
}
