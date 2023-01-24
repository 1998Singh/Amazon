package com.evoke.amazon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_price")
public class ItemPriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "price")
	private double price;

	@Column(name = "discount_percentage")
	private double discountPercentage;

	@Column(name = "discount_amount")
	private double discountAmount;

	@Column(name = "net_amount")
	private double netAmount;

	@OneToOne(mappedBy = "itemPrice")
	private ItemEntity item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

}
