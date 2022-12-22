package com.masai.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
	
	private String shippedFrom;
	
	private String shippedTo;
	
	private LocalDate expectedDate;
	
	private DeliveryStatus deliveryStatus = DeliveryStatus.IN_TRANSIT;

	public String getShippedFrom() {
		return shippedFrom;
	}

	public void setShippedFrom(String shippedFrom) {
		this.shippedFrom = shippedFrom;
	}

	public String getShippedTo() {
		return shippedTo;
	}

	public void setShippedTo(String shippedTo) {
		this.shippedTo = shippedTo;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Shipment(String shippedFrom, String shippedTo, LocalDate expectedDate, DeliveryStatus deliveryStatus) {
		super();
		this.shippedFrom = shippedFrom;
		this.shippedTo = shippedTo;
		this.expectedDate = expectedDate;
		this.deliveryStatus = deliveryStatus;
	}

	public Shipment() {
		super();
	}
	
	
	
		
}
