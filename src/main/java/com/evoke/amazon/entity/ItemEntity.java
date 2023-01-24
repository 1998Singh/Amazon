package com.evoke.amazon.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "color")
	private String color;

	@Column(name = "brand")
	private String brand;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "avzilable_Qty")
	private int availableQuantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_price_id", referencedColumnName = "id")
	private ItemPriceEntity itemPrice;

	
	public ItemEntity() {
		super();

	}

	public ItemEntity(String name, String description, String category, String color, String brand, int quantity,
			int availableQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.color = color;
		this.brand = brand;
		this.quantity = quantity;
		this.availableQuantity = availableQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public ItemPriceEntity getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPriceEntity itemPrice) {
		this.itemPrice = itemPrice;
	}

}
