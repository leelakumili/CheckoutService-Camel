package com.leela.camel.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leela.camel.model.OrderInfo.ShippingOptins;

@RestController
public class ShippingService {

	  @GetMapping("/checkout/shippingcharges/{option}")
	  @ResponseBody
	  public Double calculateShippingCharges
	    (@PathVariable String option){
	    
		  Double charge =0.0;
	      if(ShippingOptins.EXPRESS.toString().equalsIgnoreCase(option)) {
	    	  charge = 5.0;
	      }else  if(ShippingOptins.NEXTDAY.toString().equalsIgnoreCase(option)) {
	    	 charge = 10.0;
	      }
	      return charge;
	  }
}
