package com.masai.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
		private String productName;
		
		private String description;
		
		@Min(value = 1, message = "Product price should not be 0")
		private Double price;
		
		@Min(value = 1, message = "Minimum quantity should be 1")
		private Integer quantity;
		
//		@NotNull(message = "Only ELECTRONICS, MOBILE, CLOTHES categories allowed")
		private ProductCategory category;

public ProductDTO(String productName, String description,
		@Min(value = 1, message = "Product price should not be 0") Double price,
		@Min(value = 1, message = "Minimum quantity should be 1") Integer quantity, ProductCategory category) {
	super();
	this.productName = productName;
	this.description = description;
	this.price = price;
	this.quantity = quantity;
	this.category = category;
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

public ProductDTO() {
	super();
}
		
		
}
