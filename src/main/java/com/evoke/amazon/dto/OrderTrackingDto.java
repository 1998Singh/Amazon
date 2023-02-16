package com.evoke.amazon.dto;

public class OrderTrackingDto {

	private Long Id;
	private String status;
	private String deliveryDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "OrderTrackingDto [Id=" + Id + ", status=" + status + ", deliveryDate=" + deliveryDate + "]";
	}

}
