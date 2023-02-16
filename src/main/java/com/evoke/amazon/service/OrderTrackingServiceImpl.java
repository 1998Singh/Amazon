package com.evoke.amazon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.evoke.amazon.dto.OrderTrackingDto;
import com.evoke.amazon.entity.OrderTrackingEntity;
import com.evoke.amazon.exception.ApiRuntimeException;
import com.evoke.amazon.repository.OrderTrackingRepository;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

	private static final Logger log = LoggerFactory.getLogger(OrderTrackingServiceImpl.class);

	@Autowired
	private OrderTrackingRepository orderTrackingRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public OrderTrackingDto create(OrderTrackingDto orderTracking) {

		log.info("saving to database");

		try {

			ModelMapper mapper = new ModelMapper();
			OrderTrackingEntity orderTrackingEntity = mapper.map(orderTracking, OrderTrackingEntity.class);
			OrderTrackingEntity createdorderTracking = orderTrackingRepository.save(orderTrackingEntity);
			log.info("saved to database");
			orderTracking = mapper.map(createdorderTracking, OrderTrackingDto.class);
			return orderTracking;
		} catch (Exception e) {
			log.error("error-saving order to database: {}", e);
		}
		return null;
	}

	@Override
	public List<OrderTrackingDto> getAll() {

		List<OrderTrackingEntity> order = orderTrackingRepository.findAll();
		List<OrderTrackingDto> orderTrackingDtosList = new ArrayList<>();

		for (OrderTrackingEntity orderTrackingEntity : order) {

			OrderTrackingDto orderTrackingDto = mapper.map(orderTrackingEntity, OrderTrackingDto.class);
			orderTrackingDtosList.add(orderTrackingDto);
		}
		return orderTrackingDtosList;
	}

	@Override
	public OrderTrackingDto getById(Long id) {

		log.info("Getting OrderTracking details  for Id {}, ", id);
		Optional<OrderTrackingEntity> orderTrackingEntityOptional = orderTrackingRepository.findById(id);
		if (orderTrackingEntityOptional.isPresent()) {

			OrderTrackingEntity orderTrackingEntity = orderTrackingEntityOptional.get();
			OrderTrackingDto orderTrackingDto = mapper.map(orderTrackingEntity, OrderTrackingDto.class);
			return orderTrackingDto;
		}
		log.error("OrderTracking not found for Id : {}", id);
		throw new ApiRuntimeException("OrderTracking  Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);

	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting OrderTracking details  for Id {}, ", id);
			OrderTrackingDto orderTrackingDto = getById(id);
			OrderTrackingEntity ordertrackingEntity = mapper.map(orderTrackingDto, OrderTrackingEntity.class);
			orderTrackingRepository.delete(ordertrackingEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting OrderTracking details for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting OrderTracking details for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
