package com.masai.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
//	@JsonIgnore
	private Cart cart;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Ordered> orders = new ArrayList<Ordered>();
	
	@OneToOne
	@JoinColumn(name = "card_Number")
	private Card cardDetails;
	
	@JsonIgnore
	public Card getCardDetails() {
		return this.cardDetails;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Ordered> getOrders() {
		return orders;
	}

	public void setOrders(List<Ordered> orders) {
		this.orders = orders;
	}

	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	public Customer(Cart cart, List<Ordered> orders, Card cardDetails) {
		super();
		this.cart = cart;
		this.orders = orders;
		this.cardDetails = cardDetails;
	}
	public Customer() {
		super();
	}
	
		
}

