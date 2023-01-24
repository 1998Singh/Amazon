package com.evoke.amazon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "itemCost")
	private int itemCost;
	
	@Column(name = "quantity")
	private int quantity;
	
	@OneToOne(mappedBy = "cartEntity")
	private UserEntity UserEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public UserEntity getUserEntity() {
		return UserEntity;
	}

	public void setUserEntity(UserEntity UserEntity) {
		this.UserEntity = UserEntity;
	}

}
