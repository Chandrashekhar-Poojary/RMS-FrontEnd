package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService ;
	
	@GetMapping("/productSummaries")
	public Collection<Object[]> getproductSummaries() {
		return productRepository.findProductlist();
	}
	
	@PostMapping("/addProductDetails")
	public String addProduct(@RequestBody Category category){
		return categoryService.addProduct(category);
	}
	
	@PutMapping("/{productId}/editProduct")
	public void editProducts(@PathVariable Integer productId,@RequestBody Product product){
		productService.editProduct(productId,product);
		
	}
	
}
