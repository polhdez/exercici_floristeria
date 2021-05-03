package com.exercici.floristShop;

public abstract class Plant {
	private double price;
	
	public Plant(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
