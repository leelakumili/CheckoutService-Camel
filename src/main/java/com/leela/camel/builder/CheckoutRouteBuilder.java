package com.leela.camel.builder;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leela.camel.processor.OrderDetailsProcessor;

@Component
public class CheckoutRouteBuilder  extends RouteBuilder{

	@Autowired
	private OrderDetailsProcessor OrderDetailsProcessor;
	@Override
	public void configure() throws Exception {
		restConfiguration()
        .component("restlet")
        .host("localhost").port("9080")
        .bindingMode(RestBindingMode.auto);

/**
 * Configure the REST API (POST, GET, etc.)
 */
		 rest("/checkout/order/")
	      .get("/{id}").to("direct:orderDetails");
		 
		 from("direct:orderDetails")
         .process(OrderDetailsProcessor)
         .marshal().json(JsonLibrary.Jackson)
         .log("order Details body: ${body}");
		
	}

}
