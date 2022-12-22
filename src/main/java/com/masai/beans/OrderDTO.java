package com.masai.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

	private List<Item> orderItems = new ArrayList<>();
	
	private double cost;
	
	private double gst;
	
	private double deliveryCost;
	
	private double totalCost;

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderDTO(List<Item> orderItems, double cost, double gst, double deliveryCost, double totalCost) {
		super();
		this.orderItems = orderItems;
		this.cost = cost;
		this.gst = gst;
		this.deliveryCost = deliveryCost;
		this.totalCost = totalCost;
	}

	public OrderDTO() {
		super();
	}
	
	
	
}
