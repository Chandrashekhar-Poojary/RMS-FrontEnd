package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalesSummaryMonth;
import com.example.demo.dto.SalesSummaryYear;
import com.example.demo.repository.SalesRepository;

@Service
public class SalesService {

  @Autowired
  private SalesRepository salesRepository;

  //Month
  public List<SalesSummaryMonth> findSalesSummaries() {
    List<Object[]> salesSummariesData = salesRepository.findSalesSummaries();
    List<SalesSummaryMonth> salesSummaries = new ArrayList<>();

    for (Object[] salesSummaryData : salesSummariesData) {
    	SalesSummaryMonth salesSummary = new SalesSummaryMonth();
      salesSummary.setCategory((String) salesSummaryData[0]);
      salesSummary.setMonth((String) salesSummaryData[1]);
      salesSummary.setYear((int) salesSummaryData[2]);
      salesSummary.setTotalQuantity((Long) salesSummaryData[3]);
      salesSummaries.add(salesSummary);
    }

    return salesSummaries;
  }
  
  //Year
  public List<SalesSummaryYear> findSalesSummariesperYear(){
	  
	    List<Object[]> salesSummariesData = salesRepository.findSalesSummariesperYear();
	    List<SalesSummaryYear> salesSummaries = new ArrayList<>();

	    for (Object[] salesSummaryData : salesSummariesData) {
	    	SalesSummaryYear salesSummaryYear = new SalesSummaryYear();
	    	salesSummaryYear.setCategory((String) salesSummaryData[0]);
	    	salesSummaryYear.setYear((int) salesSummaryData[1]);
	    	salesSummaryYear.setTotalQuantity((Long) salesSummaryData[2]);
	      salesSummaries.add(salesSummaryYear);
	    }

	    return salesSummaries;
	  }

}