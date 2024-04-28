package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductEmployee;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductEmployee> findProductlist() {
		List<Object[]> productSummariesData = productRepository.findProductlist();
		List<ProductEmployee> productSummaries = new ArrayList<>();
		for (Object[] productSummaryData : productSummariesData) {
			ProductEmployee productSummary = new ProductEmployee();
			productSummary.setCategoryName((String) productSummaryData[0]);
			productSummary.setProductName((String) productSummaryData[1]);
			productSummary.setQuantity(1);
			productSummary.setPrice((int) productSummaryData[2]);
			productSummaries.add(productSummary);
		}
		return productSummaries;
	}

	public void editProduct(Integer productId, Product product) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            
            existingProduct.setProductName(product.getProductName()); 
            existingProduct.setCategoryName(product.getCategoryName()); 
            existingProduct.setPrice(product.getPrice()); 
            existingProduct.setTotalRemainingQuantity(product.getTotalRemainingQuantity());       
            
            productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
		
	}
}