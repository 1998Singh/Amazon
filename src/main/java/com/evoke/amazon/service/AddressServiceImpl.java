package com.evoke.amazon.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.amazon.dto.AddressDto;
import com.evoke.amazon.entity.AddressEntity;
import com.evoke.amazon.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressRepository addressRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public AddressDto create(AddressDto address) {
		
		try {
			log.info("Address saved successfully");
			AddressEntity userAddress = mapper.map(address, AddressEntity.class);
			AddressEntity addressEntity = addressRepository.save(userAddress);
			AddressDto addressDto = mapper.map(addressEntity, AddressDto.class);
			return addressDto;
		
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	@Override
	public List<AddressDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDto update(AddressDto AddressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
