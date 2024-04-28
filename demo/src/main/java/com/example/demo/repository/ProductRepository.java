package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Integer>{

	public Product findByProductName(String name);
	
	public Product findById(int n);


	@Query(value = "SELECT category_name, product_name, price FROM project.product", nativeQuery = true)
	List<Object[]> findProductlist();

	public boolean existsByProductName(String name);

	public Optional<Product> findByProduct(String productName);

	
}
