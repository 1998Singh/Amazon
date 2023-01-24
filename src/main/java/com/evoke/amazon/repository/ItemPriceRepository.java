package com.evoke.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.amazon.entity.ItemPriceEntity;

@Repository
public interface ItemPriceRepository extends JpaRepository<ItemPriceEntity, Long> {

	
}
