	package com.masai.beans;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer addressId;
	
	@NotNull(message = "city cannot be null")
	private String city;
	
	@NotNull(message = "state cannot be null")
	private String state;
	
	@NotNull(message = "address cannot be null")
	private String address;
	
	@NotNull
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pincode;

	@ManyToOne(cascade=CascadeType.ALL) 
	@JsonIgnoreProperties("addresses")
	@JsonIgnore
	private User user;
	
	@Override
	public String toString() {
		return this.city + ", " + this.state + ", " + this.pincode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address(Integer addressId, @NotNull(message = "city cannot be null") String city,
			@NotNull(message = "state cannot be null") String state,
			@NotNull(message = "address cannot be null") String address,
			@NotNull @Pattern(regexp = "[0-9]{6}", message = "Only Valid for 6 digit indian pincode") String pincode,
			User user) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.address = address;
		this.pincode = pincode;
		this.user = user;
	}

	public Address() {
		super();
	}
	
	 
}


