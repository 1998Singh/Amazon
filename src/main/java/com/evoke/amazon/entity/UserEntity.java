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
@Table(name = "person_details")
public class UserEntity {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "ph_number")
	private long phonenumber;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_cart_id", referencedColumnName = "id")
    private CartEntity cartEntity;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public CartEntity getCartEntity() {
		return cartEntity;
	}
	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + "]";
	}

}
