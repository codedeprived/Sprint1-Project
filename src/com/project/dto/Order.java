package com.project.dto;

import java.sql.Timestamp;

public class Order {
	private int order_id;
	private int user_id;
	private int cart_id;
	private Timestamp order_date;
	private double total_price;
	private int quantity;

	public Order(int order_id, int user_id, int cart_id, Timestamp order_date, double total_price, int quantity) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.cart_id = cart_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.quantity = quantity;
	}

	public Order(int user_id, int cart_id, Timestamp order_date, double total_price, int quantity) {
		super();
		this.user_id = user_id;
		this.cart_id = cart_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.quantity = quantity;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", cart_id=" + cart_id + ", order_date="
				+ order_date + ", total_price=" + total_price + ", quantity=" + quantity + "]";
	}

}
