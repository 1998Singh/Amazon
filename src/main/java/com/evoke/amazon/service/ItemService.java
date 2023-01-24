package com.evoke.amazon.service;

import java.util.List;

import com.evoke.amazon.dto.ItemDto;

public interface ItemService {
	
	public ItemDto create(ItemDto item);

	public List<ItemDto> getAll();

	public ItemDto update(ItemDto itemDto);

	public Boolean delete(Long id);

	public ItemDto getById(Long id);
	
	public ItemDto assignPriceToItem(Long itemId, Long priceId);
	

}
