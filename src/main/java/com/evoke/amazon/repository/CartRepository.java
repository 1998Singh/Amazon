package com.evoke.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.amazon.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

	
}
