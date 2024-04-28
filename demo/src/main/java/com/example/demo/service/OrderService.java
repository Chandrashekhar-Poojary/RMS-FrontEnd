package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

import jakarta.persistence.EntityManager;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private EntityManager entityManager;

	public Orders addOrder(Orders orders) {
		String orderStatus = orders.getOrderStatus();
		if(orderStatus.equalsIgnoreCase("delivered")) {
			orders.setOrderStatus(String.valueOf(0));
		}else if(orderStatus.equalsIgnoreCase("In-Process")) {
			orders.setOrderStatus(String.valueOf(1));
		}
		
		String productName=orders.getProductName();
		String category=orders.getCategoryName();
		Integer quantity=orders.getOrderQuantity();
		Double amount=orders.getTotalAmount();
		
		Double price = amount/quantity;
		
//		System.out.println(productName);
		Product product = new Product();
//		{
//		Product updatedProduct = product;
////		updateProductDetails(productName,price, product);
//		Product prod = productRepository.findByProductName(productName);
//		int id = prod.getProductId();
//		
//		Product optionalProduct = productRepository.findById(id);
//        if (optionalProduct.isPresent()) {
//            Product existingProduct = optionalProduct;
//            //this method is optional
////            updateFields(existingEmployee, updatedEmployee);
//            existingProduct.setCategoryName(updatedProduct.getCategoryName());
//            existingProduct.setPrice(updatedProduct.getPrice());
//            existingProduct.setProductName(updatedProduct.getProductName());
//            
//                
//            productRepository.save(existingProduct);
//        }
////		}
		if(productRepository.existsByProductName(productName))
		{
			System.out.println(product.toString());
			product.setPrice(price);
			productRepository.save(product);			
		}else{
			product.setProductName(productName);
			product.setCategoryName(category);
			product.setPrice(price);		
			product.setTotalRemainingQuantity(0);
			productRepository.save(product);			
		}
		Company company = companyRepository.findByCompanyName(orders.getCompanyName());
		orders.setCompany(company);
		return orderRepository.save(orders);
		
		
	}
//	public void updateProductDetails(String productName,Double price, Product updatedProduct) {
//		
//            
//       }
//	
	public void updateDeliveryStatus(Integer orderId,Orders orders)
	{
		String delivaryStatus=orders.getOrderStatus();
		Optional<Orders> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isPresent())
		{
			Orders order = optionalOrder.get();
			order.setOrderStatus(String.valueOf(0));
			
			orderRepository.save(order);
			
			if("delivered".equalsIgnoreCase(delivaryStatus)) {
				updateProductQuantity(orders);
			}
		}else {
			throw new RuntimeException("Order not found with ID: "+orderId);
		}
	}

	private void updateProductQuantity(Orders orders) {

		String productName=orders.getProductName();
		Integer orderedQuantity=orders.getOrderQuantity();
		
		Product product=productRepository.findByProductName(productName);
		
		Integer remainingQuantity=product.getTotalRemainingQuantity();
		Integer updatedQuatity=remainingQuantity+orderedQuantity;
		
		product.setTotalRemainingQuantity(updatedQuatity);
		
		productRepository.save(product);
		
	}
	
    public List<Orders> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return convertToDTOList(orders);
    }
 
    private List<Orders> convertToDTOList(List<Orders> orders) {
        List<Orders> ordersList = new ArrayList<>();
        for (Orders order : orders) {
        	Orders orders1 = new Orders();
        	orders1.setOrderId(order.getOrderId());
        	orders1.setCompanyName(order.getCompanyName());
        	orders1.setCategoryName(order.getCategoryName());
        	orders1.setProductName(order.getProductName());
        	orders1.setTotalAmount(order.getTotalAmount());
        	orders1.setOrderQuantity(order.getOrderQuantity());
        	orders1.setOrderStatus(getOrderStatusText(order.getOrderStatus())); // Convert status to text
        	
//        	Company company = companyRepository.findByCompanyName(order.getCompanyName());
//        	
//        	Company co = entityManager.find(Company.class, company.getCompanyId());
        	
        	ordersList.add(orders1);
        }
        return ordersList;
    }
 
    private String getOrderStatusText(String orderStatus) {
    	Integer os = Integer.parseInt(orderStatus);
        return os == 0 ? "Delivered" : "In Progress";
    }
}

