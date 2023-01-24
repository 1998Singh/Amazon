package com.evoke.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.amazon.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}
