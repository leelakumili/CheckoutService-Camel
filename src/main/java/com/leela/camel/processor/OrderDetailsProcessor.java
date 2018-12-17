package com.leela.camel.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leela.camel.Controller.ShippingService;
import com.leela.camel.business.CheckoutBR;
import com.leela.camel.model.OrderInfo;

@Component
public class OrderDetailsProcessor implements Processor {

	@Autowired
	private CheckoutBR checkoutBR;

	@Autowired

	private ShippingService shippingService;

	private final Logger logger = LogManager.getLogger(OrderDetailsProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		final long startTime = System.currentTimeMillis();
		logger.debug("Processing exchange - " + exchange.toString());
		final Map<String, Object> headers = exchange.getIn().getHeaders();

		final Object id = headers.get("id");
		logger.debug("ID: " + id);

		Long orderNumber = Long.parseLong(id.toString());

		OrderInfo order = checkoutBR.getOrderDetails(orderNumber);

		Double shippingCharges = shippingService.calculateShippingCharges(order.getShipping());

		order.setOrderTotal(order.getOrderTotal() + shippingCharges);

		exchange.getOut().setHeaders(exchange.getIn().getHeaders());
		exchange.getOut().setBody(order);
		logger.info("OrderDetailsProcessor process() completed in " + (System.currentTimeMillis() - startTime) + " ms");

	}

}
