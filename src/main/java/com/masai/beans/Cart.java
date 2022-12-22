package com.masai.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
	
	//@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items=new ArrayList<>();

	private Double cartTotal;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public Cart( List<Item> items, Double cartTotal) {
		super();
	//	this.cartId = cartId;
		this.items = items;
		this.cartTotal = cartTotal;
	}

	public Cart() {
		super();
	}
	
	

//	public List<Item> getItems() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
