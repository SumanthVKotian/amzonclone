package com.masai.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@NotNull(message = "Product name cannot be empty")
	private String productName;
	
	@NotNull(message = "Product should have discription")
	private String description;
	
	@Min(value = 1, message = "Product price should not be 0")
	private Double price;
	
//	private Double rating;
	
	@Min(value = 0, message = "Minimum quantity should be 1")
	private Integer quantity;
	
//	@NotNull(message = "Only ELECTRONICS, MOBILE, CLOTHES categories allowed")
	private ProductCategory category;
	
	private ProductStatus productStatus;
	
	 @ManyToOne(cascade = CascadeType.ALL) 
	 @JsonIgnoreProperties("products")
	 @JsonIgnore
	 private Seller seller;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product( @NotNull(message = "Product name cannot be empty") String productName,
			@NotNull(message = "Product should have discription") String description,
			@Min(value = 1, message = "Product price should not be 0") Double price,
			@Min(value = 0, message = "Minimum quantity should be 1") Integer quantity, ProductCategory category,
			ProductStatus productStatus, Seller seller) {
		super();
			this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.productStatus = productStatus;
		this.seller = seller;
	}

	public Product() {
		super();
	}
	
	 
	 
	 
	 
	
}
