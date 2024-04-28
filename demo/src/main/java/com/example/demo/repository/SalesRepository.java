package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer>{

	boolean existsByProductName(String productName);

	Sales findByProductName(String productName);
	
	//Month
	@Query(value = "SELECT category, month, year, SUM(quantity_sold) AS total_quantity FROM project.sales GROUP BY category, month, year", nativeQuery = true)
	  List<Object[]> findSalesSummaries();
	  
	//Year
    @Query(value = "SELECT category, year, SUM(quantity_sold) AS total_quantity FROM project.sales GROUP BY category, year", nativeQuery = true)
	  List<Object[]> findSalesSummariesperYear();


}
