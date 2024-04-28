package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;


	@PostMapping("/addOrder")
	public Orders addCustomer(@RequestBody Orders orders) {
		return orderService.addOrder(orders);
	}

	@PutMapping("/{OrderId}/delivery")
	public ResponseEntity<Orders> updateDeliveryStatus(@PathVariable Integer OrderId, @RequestBody Orders orders) {
		orderService.updateDeliveryStatus(OrderId, orders);
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/all")
	public List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}
}
