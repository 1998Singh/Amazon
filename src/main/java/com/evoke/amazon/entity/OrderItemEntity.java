package com.evoke.amazon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Column(name = "quantity")
	private int quantity;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemEntity [itemId=" + itemId + ", quantity=" + quantity + "]";
	}


}
