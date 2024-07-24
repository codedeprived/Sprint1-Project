package com.project.dto;

public class Food {
	private int food_id;
	private String food_name;
	private double price;
	private String f_info;

	public Food(int food_id, String food_name, double price, String f_info) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.price = price;
		this.f_info = f_info;
	}

	public Food(String food_name, double price, String f_info) {
		super();
		this.food_name = food_name;
		this.price = price;
		this.f_info = f_info;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getF_info() {
		return f_info;
	}

	public void setF_info(String f_info) {
		this.f_info = f_info;
	}

	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_name=" + food_name + ", price=" + price + ", f_info=" + f_info
				+ "]";
	}

}
