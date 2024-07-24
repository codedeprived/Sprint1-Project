package com.project.dto;

import java.sql.Timestamp;

public class CartItems {
	private int cart_item_id;
	private int cart_id;
	private int food_id;
	private int quantity;
	private double price;
	private Timestamp last_Updated;

	public CartItems(int cart_item_id, int cart_id, int food_id, int quantity, double price, Timestamp last_Updated) {
		super();
		this.cart_item_id = cart_item_id;
		this.cart_id = cart_id;
		this.food_id = food_id;
		this.quantity = quantity;
		this.price = price;
		this.last_Updated = last_Updated;
	}

	public CartItems(int cart_id, int food_id, int quantity, double price, Timestamp last_Updated) {
		super();
		this.cart_id = cart_id;
		this.food_id = food_id;
		this.quantity = quantity;
		this.price = price;
		this.last_Updated = last_Updated;
	}

	public int getCart_item_id() {
		return cart_item_id;
	}

	public void setCart_item_id(int cart_item_id) {
		this.cart_item_id = cart_item_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getLast_Updated() {
		return last_Updated;
	}

	public void setLast_Updated(Timestamp last_Updated) {
		this.last_Updated = last_Updated;
	}

	@Override
	public String toString() {
		return "CartItems [cart_item_id=" + cart_item_id + ", cart_id=" + cart_id + ", food_id=" + food_id
				+ ", quantity=" + quantity + ", price=" + price + ", last_Updated=" + last_Updated + "]";
	}

}
