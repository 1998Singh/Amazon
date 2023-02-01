package com.evoke.amazon.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.amazon.dto.OrderRequestDto;
import com.evoke.amazon.entity.OrderRequestEntity;
import com.evoke.amazon.repository.OrderRequestRepository;

@Service
public class OrderRequestServiceImpl implements OrderRequestService {

	private static final Logger log = LoggerFactory.getLogger(OrderRequestServiceImpl.class);

	@Autowired
	private OrderRequestRepository orderRequestRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public OrderRequestDto create(OrderRequestDto order) {
		try {

			log.info("Address saved successfully");
			OrderRequestEntity orderRequestEntity = mapper.map(order, OrderRequestEntity.class);
			OrderRequestEntity orders = orderRequestRepository.save(orderRequestEntity);
			OrderRequestDto orderRequestDto = mapper.map(orders, OrderRequestDto.class);
			return orderRequestDto;

		} catch (Exception e) {
			log.error("", e);

		}
		return null;
	}

	
	@Override
	public List<OrderRequestDto> getAll() {

		List<OrderRequestEntity> order = orderRequestRepository.findAll();

		List<OrderRequestDto> orderRequestDtosList = new ArrayList<>();

		for (OrderRequestEntity orderRequestEntityRepository : order) {

			OrderRequestDto orderRequestDto = mapper.map(orderRequestEntityRepository, OrderRequestDto.class);

			orderRequestDtosList.add(orderRequestDto);

		}
		return orderRequestDtosList;
	}

}
