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
import org.springframework.util.StringUtils;

import com.evoke.amazon.dto.CartDto;
import com.evoke.amazon.entity.CartEntity;
import com.evoke.amazon.exception.ApiRuntimeException;
import com.evoke.amazon.repository.CartRepository;

@Service
public class CartServicePersonImpl implements CartService {

	private static final Logger log = LoggerFactory.getLogger(CartServicePersonImpl.class);

	@Autowired
	private CartRepository cartrepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public CartDto create(CartDto cartDto) {

		log.info("saving cartdetails to database");
		try {
			CartEntity cartentity = mapper.map(cartDto, CartEntity.class);
			CartEntity createCart = cartrepository.save(cartentity);
			log.info("saving cartdetails to database");
			cartDto = mapper.map(createCart, CartDto.class);

			return cartDto;

		} catch (Exception e) {

			log.info("error while creating object", e);

		}
		return null;
	}

	@Override
	public List<CartDto> getAll() {

		List<CartEntity> cart = cartrepository.findAll();
		List<CartDto> CartDtolist = new ArrayList<CartDto>();
		for (CartEntity Cartentity : cart) {

			CartDto cartdto = mapper.map(Cartentity, CartDto.class);

			CartDtolist.add(cartdto);
		}
		return CartDtolist;

	}

	@Override
	public CartDto update(CartDto cartDto) {

		if (StringUtils.isEmpty(cartDto.getId())) {
			throw new ApiRuntimeException("cartDto ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating cart {}", cartDto.toString());
		CartEntity cartEntity = mapper.map(cartDto, CartEntity.class);

		cartrepository.save(cartEntity);
		log.info("cart updated successfully");

		CartDto updatedCartDto = mapper.map(cartEntity, CartDto.class);
		return updatedCartDto;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting CartDetails  for Id {}, ", id);
			CartDto cartDto = getById(id);
			CartEntity cartEntity = mapper.map(cartDto, CartEntity.class);
			cartrepository.delete(cartEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting item for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public CartDto getById(Long id) {

		log.info("Getting CartDetails  for Id {}, ", id);
		Optional<CartEntity> cartEntityOptional = cartrepository.findById(id);

		if (cartEntityOptional.isPresent()) {
			CartEntity cartEntity = cartEntityOptional.get();
			CartDto cartDto = mapper.map(cartEntity, CartDto.class);
			return cartDto;
		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);

	}

}
