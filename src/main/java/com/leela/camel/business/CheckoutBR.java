package com.leela.camel.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leela.camel.model.OrderInfo;
import com.leela.camel.repo.CheckoutRepository;

@Component
public class CheckoutBR {
	
	
	@Autowired
	  private CheckoutRepository repository;
	
	
	   public OrderInfo getOrderDetails(Long orderId) {
		   
		   OrderInfo order = 
			        repository.findByid(orderId);  
		   
	
		   order.setOrderTotal(order.getSubtotal()+ order.getTax());
		   
		   return order;
	   }
	   
	   

}
