package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Inventory;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class InventoryService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Inventory> getInventoryDetails() {
//		List<Object[]> inventorySummariesData = inventoryRepository.getInventoryDetails();
		List<Product> product = productRepository.findAll();
		List<Orders> orders = orderRepository.findAll();
		List<Inventory> inventorySummaries = new ArrayList<>();
		
//		for (Object[] inventorySummaryData : inventorySummaries) {
//			Inventory inventorySummary = new Inventory();
			for(Product p : product)
			{
				Inventory inventorySummary = new Inventory();
				inventorySummary.setTotalRemainingQuantity(p.getTotalRemainingQuantity());
				inventorySummaries.add(inventorySummary);
			}
			for(Orders o : orders)
			{
				Inventory inventorySummary = new Inventory();
				inventorySummary.setCompanyName(o.getCompanyName());
				inventorySummary.setCategoryName(o.getCategoryName());
				inventorySummary.setProductName(o.getProductName());
				inventorySummary.setOrderQuantity(o.getOrderQuantity());
				
				inventorySummaries.add(inventorySummary);
			}
			
			return inventorySummaries;
		}
	}
