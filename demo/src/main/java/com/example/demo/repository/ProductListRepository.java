package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductList;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Integer> {

}
