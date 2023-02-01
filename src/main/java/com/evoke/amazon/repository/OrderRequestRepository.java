package com.evoke.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.amazon.entity.OrderRequestEntity;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequestEntity, Long> {

	
}
