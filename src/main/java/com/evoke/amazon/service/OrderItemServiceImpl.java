package com.evoke.amazon.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.amazon.dto.OrderItemDto;
import com.evoke.amazon.entity.OrderItemEntity;
import com.evoke.amazon.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

	@Autowired
	private OrderItemRepository orderItemRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public OrderItemDto create(OrderItemDto orderItemDto) {

		try {

			ModelMapper mapper = new ModelMapper();
			OrderItemEntity orderItemEntity = mapper.map(orderItemDto, OrderItemEntity.class);

			OrderItemEntity createdOrder = orderItemRepository.save(orderItemEntity);
			log.info("saved Item to database");
			orderItemDto = mapper.map(createdOrder, OrderItemDto.class);
			return orderItemDto;
		} catch (Exception e) {
			log.error("error-saving order to database: {}", e);
		}
		return null;
	}

	@Override
	public List<OrderItemDto> getAll() {

		List<OrderItemEntity> order = orderItemRepository.findAll();

		List<OrderItemDto> orderItemDtosList = new ArrayList<>();

		for (OrderItemEntity orderItemEntity : order) {

			OrderItemDto orderItemDto = mapper.map(orderItemEntity, OrderItemDto.class);

			orderItemDtosList.add(orderItemDto);

		}
		return orderItemDtosList;
	}

}
