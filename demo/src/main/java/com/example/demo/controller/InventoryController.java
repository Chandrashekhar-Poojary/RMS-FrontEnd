package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Inventory;
import com.example.demo.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/inventorySummaries")
	public List<Inventory> getinventorySummaries() {
		return inventoryService.getInventoryDetails();
	}

}
