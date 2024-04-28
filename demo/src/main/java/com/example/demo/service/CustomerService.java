package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.ProductList;
import com.example.demo.model.Sales;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductListRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SalesRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductListRepository productListRepository;
	
	@Autowired
	private SalesRepository salesRepository;
	
	public Customer addCustomer(Customer customer) {
		System.out.println(customer);
	    customerRepository.save(customer);
	    String category="null";
		String month=customer.getMonth();
		Integer quantity=0;
		Integer year=customer.getYear();				
		
		List<ProductList> productList = customer.getProductList();
		System.out.println("jhfj"+productList);
		
//		Subtracting quantity from product
		for(ProductList name : productList) {			
			String productName=name.getProductName();
			category=name.getCategoryName();
			quantity=name.getQuantity();	
			
			System.out.println(productName + " " + category);
			
			Product product = productRepository.findByProductName(productName); 
			System.out.println("Product " + product.toString());
			product.setTotalRemainingQuantity(product.getTotalRemainingQuantity() - name.getQuantity());
//			product.setCustomer();
			productRepository.save(product);
		}
		
//		Adding sales data in sales table
		for(ProductList name : customer.getProductList()) {			
			String productName=name.getProductName();
			
			
			if(salesRepository.existsByProductName(productName))
			{
				Sales sale = salesRepository.findByProductName(productName); 	
				sale.setQuantitySold(sale.getQuantitySold() + name.getQuantity());
				salesRepository.save(sale);
			}else {
				Sales newSale = new Sales();
				newSale.setProductName(productName);
				newSale.setCategory(category);
				newSale.setQuantitySold(quantity);
				newSale.setMonth(month);
				newSale.setYear(year);
				
				salesRepository.save(newSale);
				
			}
		}	

		for(ProductList prod: customer.getProductList())
		{
			prod.setCustomer(customer);
			productListRepository.save(prod);
		}
		
		
		
    	return customer;
    	
	}
	
	
}
