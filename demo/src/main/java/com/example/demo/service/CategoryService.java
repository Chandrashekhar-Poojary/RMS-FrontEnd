package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public String addProduct(Category category)
	{
		String productCategery = category.getCategory();
		List<String> productName =  category.getGetProduct();
		for(String name : productName)
		{
			Product product = new Product();
			if(productRepository.existsByProductName(name))
			{
				continue;
			}else {
				product.setCategoryName(productCategery);
				product.setProductName(name);
				product.setPrice(0.0);
				product.setTotalRemainingQuantity(0);
				productRepository.save(product);
			}
		}
		return "Successfully updated";
	}

}
