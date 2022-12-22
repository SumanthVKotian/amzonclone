package com.masai.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Orders")
public class Ordered {
	
	//WITH CUSTOMER
	//Order has ManyToOne relation with customer
	//One order can have one customer
	//One user can have multiple orders
	//Unidirectional from customer
	
	//WITH ITEM
	//Order can have multiple items
	//one item can only be in one order
	//Order has oneToMany unidirectional with item
	
	//WITH SHIPMENT
	//Order has one to one with shipment
	//One order can have one shipment
	//Uni directional with shipment as well
	
	//CHANGES TO MAKE WHEN ORDER IS PLACED
	//To Trigger --> Call the payment method
	
	//Once the payment is made 
	
	//--> Empty the cart and give the reference to the items
	//	  from this class object
	
	//--> Reduce the quantity of the products 
	
	//--> Add the placed order in the order list of the customer
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@Column(name = "items")
	private List<Item> orderedItems;
	
	@Column(name = "products_cost")
	private Double itemsCost;
	
	@Column(name = "gst")
	private Double gst;
	
	@Column(name = "delivery_charge")
	private Double deliveryCharge;
	
	@Column(name = "total_amount")
	private Double totalAmount;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "shippedFrom", column = @Column(name = "shipped_from_address")),
		  @AttributeOverride( name = "shippedTo", column = @Column(name = "shipped_to_address")),
		  @AttributeOverride( name = "expectedDate", column = @Column(name = "expected_delivery_date"))
		})
	private Shipment shipment;

	//Last 4 digits of card used to make the payment
	@Column(name = "card_used_for_payment")
	private String cardUsedForPayment;
	
	@Column(name = "order_date")
	private LocalDate orderDate;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Item> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<Item> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public Double getItemsCost() {
		return itemsCost;
	}

	public void setItemsCost(Double itemsCost) {
		this.itemsCost = itemsCost;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public String getCardUsedForPayment() {
		return cardUsedForPayment;
	}

	public void setCardUsedForPayment(String cardUsedForPayment) {
		this.cardUsedForPayment = cardUsedForPayment;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Ordered(Integer orderId, List<Item> orderedItems, Double itemsCost, Double gst, Double deliveryCharge,
			Double totalAmount, Shipment shipment, String cardUsedForPayment, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.orderedItems = orderedItems;
		this.itemsCost = itemsCost;
		this.gst = gst;
		this.deliveryCharge = deliveryCharge;
		this.totalAmount = totalAmount;
		this.shipment = shipment;
		this.cardUsedForPayment = cardUsedForPayment;
		this.orderDate = orderDate;
	}

	public Ordered() {
		super();
	}
	
}
