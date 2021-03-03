package com.test.assigment.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.assigment.dto.OrderDetailResponsne;
import com.test.assigment.dto.OrderSummaryResponse;
import com.test.assigment.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("customer/{custId}/order/summary")
	public List<OrderSummaryResponse> getCustomerOrderSummary(@PathVariable(value = "custId") String custId)
			throws ClientProtocolException, IOException {

		return orderService.getOrderSummary(custId);

	}

	@GetMapping("/order/{orderId}/detail")
	public OrderDetailResponsne getOrderDetail(@PathVariable(value = "orderId") Long orderId)
			throws ClientProtocolException, IOException {

		return orderService.getOrderDetails(orderId);

	}

}
