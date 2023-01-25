package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.AddressDto;

public interface AddressService {
	
	public AddressDto create(AddressDto address);

	public List<AddressDto> getAll();

	public AddressDto update(AddressDto AddressDto);

	public Boolean delete(Long id);

	public AddressDto getById(Long id);


}
