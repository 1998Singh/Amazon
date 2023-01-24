package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.UserDto;

public interface UserService {
	
	public UserDto create(UserDto UserDto);

	public List<UserDto> getAll();
	
	public UserDto update(UserDto UserDto);

	public Boolean delete(Long id);

	public UserDto getById(Long id);
	
	public UserDto assignCartToPerson(Long cartid, Long personid);



}
