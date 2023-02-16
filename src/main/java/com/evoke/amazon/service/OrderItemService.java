package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.OrderItemDto;

public interface OrderItemService {
	
	public OrderItemDto create(OrderItemDto orderItemDto);

	public List<OrderItemDto> getAll();

}
