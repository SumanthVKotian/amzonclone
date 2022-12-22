package com.masai.beans;


import java.util.List;

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
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	

	@OneToOne
	@JsonIgnoreProperties(value={
			"rating",
			"productId",
			"seller",
			"quantity"
			
	})
	
	private Product product;
	
	private Double itemPrice;
	
	private Integer requiredQuantity;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getRequiredQuantity() {
		return requiredQuantity;
	}

	public void setRequiredQuantity(Integer requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

	public Item(Integer itemId, Product product, Double itemPrice, Integer requiredQuantity) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.itemPrice = itemPrice;
		this.requiredQuantity = requiredQuantity;
	}

	public Item() {
		super();
	}
	
	
}
