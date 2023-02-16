package com.evoke.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evoke.amazon.entity.OrderTrackingEntity;

@Repository
public interface OrderTrackingRepository  extends JpaRepository<OrderTrackingEntity, Long>{

}
