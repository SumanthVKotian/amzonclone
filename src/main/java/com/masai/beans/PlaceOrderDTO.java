package com.masai.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDTO {
	
	@Pattern(regexp="[0-9]{3}", message = "CVV must be 3 digits")
	@NotNull
	private String cvv;
	
	@NotNull
	private int addressId;

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public PlaceOrderDTO(@Pattern(regexp = "[0-9]{3}", message = "CVV must be 3 digits") @NotNull String cvv,
			@NotNull int addressId) {
		super();
		this.cvv = cvv;
		this.addressId = addressId;
	}

	public PlaceOrderDTO() {
		super();
	}
	
}
