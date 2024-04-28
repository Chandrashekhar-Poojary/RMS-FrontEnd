package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.SalesRepository;

@RestController
public class SalesController {

  private final SalesRepository salesRepository;
 
  @Autowired
  public SalesController(SalesRepository salesRepository) {
    this.salesRepository = salesRepository;
  }
  @GetMapping("/salesSummariesForMonth")
  public Collection<Object[]> getSalesSummaries() {
    return salesRepository.findSalesSummaries();
  }
  @GetMapping("/salesSummariesForYear")
  public Collection<Object[]> getSalesSummariesperYear() {
    return salesRepository.findSalesSummariesperYear();
  }
  

}