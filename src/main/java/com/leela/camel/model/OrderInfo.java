package com.leela.camel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderInfo {
	
	 @Id
	private Long id;
	
	 @Column(name="customername")
	private String customerName;
	
	 @Column(name="ordertotal")
	private Double orderTotal;
	
	 @Column(name="tax")
	private double tax;
	
	 @Column(name="subtotal")
	private double subtotal;
	
	 
	public enum ShippingOptins {STANDARD, EXPRESS,NEXTDAY}
	
	 @Column(name="shipping")
	private String shipping;

	public Long getOrderNumber() {
		return id;
	}

	public void setOrderNumber(Long orderNumber) {
		this.id = orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public OrderInfo() {
	    
	  }
	  
	public OrderInfo(Long orderNumber, String customerName, Double orderTotal, double tax, double subtotal,
			ShippingOptins shipping) {
		super();
		this.id = orderNumber;
		this.customerName = customerName;
		this.orderTotal = orderTotal;
		this.tax = tax;
		this.subtotal = subtotal;
		this.shipping = shipping.toString();
	};
	
	
	public OrderInfo(Long orderNumber, String customerName, double tax, double subtotal,
			ShippingOptins shipping) {
		super();
		this.id = orderNumber;
		this.customerName = customerName;
		this.orderTotal = 0.0;
		this.tax = tax;
		this.subtotal = subtotal;
		this.shipping = shipping.toString();
	};

	
}
