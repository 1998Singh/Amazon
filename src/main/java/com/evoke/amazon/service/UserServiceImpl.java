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
import com.evoke.amazon.dto.UserDto;
import com.evoke.amazon.entity.CartEntity;
import com.evoke.amazon.entity.UserEntity;
import com.evoke.amazon.exception.ApiRuntimeException;
import com.evoke.amazon.repository.CartRepository;
import com.evoke.amazon.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private CartRepository cartRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public UserDto create(UserDto UserDto) {

		ModelMapper mapper = new ModelMapper();
		UserEntity UserEntity = mapper.map(UserDto, UserEntity.class);
		UserEntity createditem = UserRepository.save(UserEntity);
		UserDto = mapper.map(UserEntity, UserDto.class);
		return UserDto;
	}

	@Override
	public List<UserDto> getAll() {

		List<UserEntity> persons = UserRepository.findAll();

		List<UserDto> UserDtosList = new ArrayList<>();

		for (UserEntity UserEntity : persons) {

			UserDto UserDto = mapper.map(UserEntity, UserDto.class);

			UserDtosList.add(UserDto);

		}
		return UserDtosList;
	}

	@Override
	public UserDto update(UserDto UserDto) {

		if (StringUtils.isEmpty(UserDto.getId())) {
			throw new ApiRuntimeException("Item ID cannot be NULL or Empty to UpdateItem", "NOT_FOUND",
					HttpStatus.NOT_FOUND);
		}

		log.info("updating item {}", UserDto.toString());
		UserEntity userEntity = mapper.map(UserDto, UserEntity.class);

		UserRepository.save(userEntity);
		log.info("Item updated successfully");

		UserDto updatedUserDto = mapper.map(userEntity, UserDto.class);
		return updatedUserDto;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			log.info("Deleting ItemDetails  for Id {}, ", id);
			UserDto userDto = getById(id);
			UserEntity userEntity = mapper.map(userDto, UserEntity.class);
			UserRepository.delete(userEntity);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting item for Id : {}", id);
			throw new ApiRuntimeException("Error while deleting item for Id " + id, "INTERNAL_ERROR",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public UserDto getById(Long id) {
		
		log.info("Getting ItemDetails  for Id {}, ", id);
		Optional<UserEntity> userEntityOptional = UserRepository.findById(id);
		if (userEntityOptional.isPresent()) {

			UserEntity userEntity = userEntityOptional.get();
			UserDto userDto = mapper.map(userEntity, UserDto.class);

			CartEntity cartEntity = userEntity.getCartEntity();
			if (cartEntity != null) {
				CartDto cartDto = mapper.map(cartEntity, CartDto.class);
				userDto.setCartdto(cartDto);
			}

			return userDto;
		}
		log.error("Item not found for Id : {}", id);
		throw new ApiRuntimeException("Item Not Found for ID: " + id, "NOT_FOUND", HttpStatus.NOT_FOUND);
	
	}
	

	@Override
	public UserDto assignCartToPerson(Long cartid, Long personid) {

		UserEntity UserEntity = UserRepository.findById(personid).get();
		CartEntity cartEntity = cartRepository.findById(cartid).get();
		UserEntity.setCartEntity(cartEntity);
		UserRepository.save(UserEntity);
		UserDto UserDto = mapper.map(UserEntity, UserDto.class);
		CartDto cartDto = mapper.map(cartEntity, CartDto.class);
		UserDto.setCartdto(cartDto);
		return UserDto;
	}
}
