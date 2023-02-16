package com.evoke.amazon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.amazon.dto.OrderTrackingDto;
import com.evoke.amazon.service.OrderTrackingService;


@RestController
@RequestMapping("/api")
public class OrderTrackingController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderTrackingController.class);
	
	
	@Autowired
	private OrderTrackingService orderTrackingService;

	@PostMapping("/ordertracking")
	public ResponseEntity<String> save(@RequestBody OrderTrackingDto orderTrackingDto) {
		log.info("creating order Tracking {}", orderTrackingDto);
        orderTrackingService.create(orderTrackingDto);
		return new ResponseEntity<String>("created successfully", HttpStatus.CREATED);

	}

	@GetMapping("/ordertracking")
	public ResponseEntity<List<OrderTrackingDto>> getItems(OrderTrackingDto orderTracking) {
		List<OrderTrackingDto> orderTrackingDtos = orderTrackingService.getAll();
		return new ResponseEntity<List<OrderTrackingDto>>(orderTrackingDtos, HttpStatus.OK);
	}
	
	@GetMapping("/ordertracking/{id}")
	public ResponseEntity<OrderTrackingDto> getById(@PathVariable("id") Long id) {
		OrderTrackingDto orderTracking = orderTrackingService.getById(id);
		return new ResponseEntity<OrderTrackingDto>(orderTracking, HttpStatus.OK);
	}

	@DeleteMapping("/ordertracking/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		orderTrackingService.delete(id);
		return new ResponseEntity<String>("orderTracking Details  Deleted Successfully", HttpStatus.OK);
	}

}
