package com.masai.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

	@NotNull(message = "Product Id must Not be Null")
	Integer productId;
	
	
	@Min(0)
	@NotNull(message = "Product Id must not be Null")
	Integer requiredQuantity;


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getRequiredQuantity() {
		return requiredQuantity;
	}


	public void setRequiredQuantity(Integer requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}


	public ItemDTO(@NotNull(message = "Product Id must Not be Null") Integer productId,
			@Min(0) @NotNull(message = "Product Id must not be Null") Integer requiredQuantity) {
		super();
		this.productId = productId;
		this.requiredQuantity = requiredQuantity;
	}


	public ItemDTO() {
		super();
	}
	
	
	
}
