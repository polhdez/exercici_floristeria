package com.exercici.floristShop;

public class Tree extends Plant {
	private double height;
	
	public Tree(double price, double height) {
		super(price);
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
}
