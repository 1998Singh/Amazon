package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.OrderRequestDto;

public interface OrderRequestService {
	
	
	public OrderRequestDto create(OrderRequestDto orderRequestDto);

	public List<OrderRequestDto> getAll();

	//public Boolean delete(Long id); 

	//public OrderRequestDto getById(Long id);


}
