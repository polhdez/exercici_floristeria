package com.exercici.floristShop;

import java.util.ArrayList;

public class FloristShop {

	public static enum Decoration {
		WOOD, PLASTIC
	}
	
	private String name;
	private ArrayList<Tree> trees;
	private ArrayList<Flower> flowers;
	private Decoration decoration;

	public FloristShop(String name) {
		this.name = name;
		this.trees = new ArrayList<Tree>();
		this.flowers = new ArrayList<Flower>();
	}

	public String getName() {
		return this.name;
	}

	public int getTreesListSize() {
		return this.trees.size();
	}

	public int getFlowersListSize() {
		return this.flowers.size();
	}

	public Tree getTree(int i) {
		return this.trees.get(i);
	}
	
	public Flower getFlower(int i) {
		return this.flowers.get(i);
	}
	
	public void addTree(Tree tree) {
		this.trees.add(tree);
	}
	
	public void addFlower(Flower flower) {
		this.flowers.add(flower);
	}
	
	public void removeTree(Tree tree) {
		this.trees.remove(tree);
	}
	
	public void removeFlower(Flower flower) {
		this.flowers.remove(flower);
	}
	
	public Decoration getDecoration() {
		return this.decoration;
	}
	
	public void setDecoration(Decoration decoration) {
		this.decoration = decoration;
	}
	
	public void getStock() {
		System.out.println(this.name.toUpperCase() + "'S STOCK");
		System.out.println("Trees: " + this.trees);
		System.out.println("Flowers: " + this.flowers);
		System.out.println(this.decoration);
	}
}
