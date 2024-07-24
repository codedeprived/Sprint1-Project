package com.project.dto;

import java.sql.Timestamp;

public class Cart {

	private int cart_id;
	private int user_id;
	private Timestamp created_at;
	private Timestamp last_updated;

	public int getCart_id() {
		return cart_id;
	}

	public Cart(int user_id, Timestamp created_at, Timestamp last_updated) {
		super();
		this.user_id = user_id;
		this.created_at = created_at;
		this.last_updated = last_updated;
	}

	public Cart(int cart_id, int user_id, Timestamp created_at, Timestamp last_updated) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.created_at = created_at;
		this.last_updated = last_updated;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Timestamp last_updated) {
		this.last_updated = last_updated;
	}

	@Override
	public String toString() {
		return "cart [cart_id=" + cart_id + ", user_id=" + user_id + ", created_at=" + created_at + ", last_updated="
				+ last_updated + "]";
	}

}
