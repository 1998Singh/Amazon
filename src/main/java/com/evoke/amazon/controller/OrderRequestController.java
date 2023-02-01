package com.evoke.amazon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.amazon.dto.OrderRequestDto;
import com.evoke.amazon.service.OrderRequestService;

@RestController
@RequestMapping("/api")
public class OrderRequestController {

	private static final Logger log = LoggerFactory.getLogger(OrderRequestController.class);
	
	@Autowired
	private OrderRequestService orderRequestService;

	
	@PostMapping("/orderitem")
	public ResponseEntity<String> save(@RequestBody OrderRequestDto orderRequestDto) {
		log.info("creating order {}", orderRequestDto);

		orderRequestService.create(orderRequestDto);
		return new ResponseEntity<String>("order created successfully", HttpStatus.CREATED);

	}

	
	@GetMapping("/orderitem")
	public ResponseEntity<List<OrderRequestDto>> getOrders() {
		List<OrderRequestDto> orderCreationDtos = orderRequestService.getAll();
		log.info("Get order");
		return new ResponseEntity<List<OrderRequestDto>>(orderCreationDtos, HttpStatus.OK);
	}

}
