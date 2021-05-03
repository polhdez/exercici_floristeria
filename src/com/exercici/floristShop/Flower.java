package com.exercici.floristShop;

public class Flower extends Plant {
	
	public static enum Color {
		RED, BLUE, GREEN
	}
	
	private Color color;
	
	public Flower(double price, Color color) {
		super(price);
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
}
