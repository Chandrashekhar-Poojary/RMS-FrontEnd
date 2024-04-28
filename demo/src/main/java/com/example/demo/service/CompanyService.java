package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Product;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.ProductRepository;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}
	
	public List<Company> getCompany(){
		return companyRepository.findAll();
	}

	public Company addEmp(Company company) {
		
		String companyName=company.getCompanyName();
		String ownerName=company.getOwnerName();
		Long contactNumber=company.getContactNo();
		String category=company.getCategoryName();
		
		
		System.out.println(company.toString());
		List<String> productNames = company.getCompanyProductId();//We will get the names;
		List<String> productIds = new ArrayList<>();
		for(String name : productNames) {
			System.out.println(name);
//			Product product = productRepo.findAllProductName(name).orElse(null);
			Product product = productRepository.findByProductName(name);
//			System.out.println(product.toString());
			System.out.println(product);
//			productRepo.
			if(product != null) productIds.add(String.valueOf(product.getProductId())+",");
		}
//		Company c = new Company();
//		c.setProduct(productIds);
//		companyRepository.save(c);
//		System.out.println(productIds);
//		li=productIds;
		Company cp=new Company();
		cp.setCompanyName(companyName);
		cp.setOwnerName(ownerName);
		cp.setContactNo(contactNumber);
		cp.setCategoryName(category);
		cp.setCompanyProductId(productIds);
		
				
		
		return companyRepository.save(cp);
	}
//	public Company getDetails()
//	{
//		
//	}
	
	
	
}
