package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.OrderTrackingDto;

public interface OrderTrackingService {
	
	public OrderTrackingDto create(OrderTrackingDto orderTracking);

	public List<OrderTrackingDto> getAll();
	
	public OrderTrackingDto getById(Long id);
	
	public Boolean delete(Long id);


}
