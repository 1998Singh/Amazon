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

import com.evoke.amazon.dto.OrderItemDto;
import com.evoke.amazon.service.OrderItemService;

@RestController
@RequestMapping("/api")
public class OrderItemController {

	private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping("/orderitem")
	public ResponseEntity<String> save(@RequestBody OrderItemDto orderItemDto) {
		log.info("creating order {}", orderItemDto);
		orderItemService.create(orderItemDto);
		return new ResponseEntity<String>("created successfully", HttpStatus.CREATED);

	}

	@GetMapping("/orderitem")
	public ResponseEntity<List<OrderItemDto>> getItems(OrderItemDto orderItemDto) {
		List<OrderItemDto> orderItemDtos = orderItemService.getAll();
		return new ResponseEntity<List<OrderItemDto>>(orderItemDtos, HttpStatus.OK);
	}

}
