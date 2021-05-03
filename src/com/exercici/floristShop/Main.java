package com.exercici.floristShop;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String args[]) {
		int choice;
		String input;
		String[] buttons;
		ArrayList<FloristShop> floristShopList = new ArrayList<FloristShop>();
		FloristShop floristShop;
		

		while (true) {
			buttons = new String[]{"Create Florist Shop", "Select Florist Shop", "Exit"};
			choice = showOptionMenu("Florist Shop Application", "What do you wanna do?", buttons, buttons[0]);
			switch (choice) {
				// Create shop
				case 0:
					input = showInputPrompt("Enter the name of the Florist Shop");
					FloristShop newFloristShop = new FloristShop(input);
					showMessage("New shop!", newFloristShop.getName() + " created!");
					floristShopList.add(newFloristShop);
					break;

				// Select shop
				case 1:
					if (floristShopList.isEmpty()) {
						break;
					}
					buttons = new String[floristShopList.size()];
					for (int i = 0; i < floristShopList.size(); i++) {
						buttons[i] = floristShopList.get(i).getName();
					}
					choice = showOptionMenu("Florist Shop List", "Select a shop", buttons, buttons[0]);
					floristShop = floristShopList.get(choice);
					boolean asking = true;
					while(asking) {
						buttons = new String[]{"Add tree", "Add flower", "Remove tree", "Remove flower", "List stocks", "Show total stock price", "Set decoration", "Back"};
						choice = showOptionMenu("Managing " + floristShop.getName(), "Select an option", buttons, buttons[0]);
						double price;
						switch (choice) {
							// Add tree
							case 0:
								input = showInputPrompt("Set the height of the tree");
								double height = Double.parseDouble(input);
								if (height == 0) {
									break;
								}
								input = showInputPrompt("Set the price of the tree");
								price = Double.parseDouble(input);
								if (price == 0) {
									break;
								}
								floristShop.addTree(new Tree(price, height));
								showMessage("New flower!", "Tree created!");
								break;

							//Add flower
							case 1:
								buttons = new String[]{"Red", "Blue", "Green"};
								choice = showOptionMenu("Creating flower", "Select color", buttons, buttons[0]);
								Flower.Color color;
								switch (choice) {
									case 0:
										color = Flower.Color.RED;
										break;
									case 1:
										color = Flower.Color.BLUE;
										break;
									case 2:
										color = Flower.Color.GREEN;
										break;
									default:
										throw new IllegalStateException("Unexpected value: " + choice);
								}
								input = showInputPrompt("Set the price of the flower");
								price = Double.parseDouble(input);
								if (price == 0) {
									break;
								}
								Flower newFlower = new Flower(price, color);
								floristShop.addFlower(newFlower);
								showMessage("New flower!", newFlower.getColor().name() + " flower created!");
								break;
							// Remove tree
							case 2:
								if (floristShop.getTreesListSize() == 0) {
									break;
								}
								buttons = new String[floristShop.getTreesListSize()];
								for (int i = 0; i < floristShop.getTreesListSize(); i++) {
									buttons[i] = floristShop.getTree(i).getHeight() + " Price:" + floristShop.getTree(i).getPrice();
								}
								choice = showOptionMenu("Removing tree", "Select a tree", buttons, buttons[0]);
								floristShop.removeTree(floristShop.getTree(choice));
								showMessage("Tree deleted!", "Tree deleted!");
								break;
							// Remove flower
							case 3:
								if (floristShop.getFlowersListSize() == 0) {
									break;
								}
								buttons = new String[floristShop.getFlowersListSize()];
								for (int i = 0; i < floristShop.getFlowersListSize(); i++) {
									buttons[i] = floristShop.getFlower(i).getColor() + " Price:" + floristShop.getFlower(i).getPrice();
								}
								choice = showOptionMenu("Removing flower", "Select a flower", buttons, buttons[0]);
								floristShop.removeFlower(floristShop.getFlower(choice));
								showMessage("Flower deleted!", "Flower deleted!");
								break;
							case 4:
								String stocks = "";
								for (int i = 0; i < floristShop.getTreesListSize(); i++) {
									stocks += "Tree: Height: " + floristShop.getTree(i).getHeight() + " Price: " + floristShop.getTree(i).getPrice() + "\n";
								}
								for (int i = 0; i < floristShop.getFlowersListSize(); i++) {
									stocks += "Flower: Color: " + floristShop.getFlower(i).getColor() + " Price: " + floristShop.getFlower(i).getPrice() + "\n";
								}
								showMessage("Stocks", stocks);
								break;
							case 5:
								double stocksPrice = 0;
								for (int i = 0; i < floristShop.getTreesListSize(); i++) {
									stocksPrice += floristShop.getTree(i).getPrice();
								}
								for (int i = 0; i < floristShop.getFlowersListSize(); i++) {
									stocksPrice += floristShop.getFlower(i).getPrice();
								}
								showMessage("Total Stock Price", "" + stocksPrice);
								break;
							case 6:
								buttons = new String[]{"Wood", "Plastic"};
								choice = showOptionMenu("Flower Shop Decoration", "Select a decoration", buttons, buttons[0]);
								switch (choice) {
									case 0:
										floristShop.setDecoration(FloristShop.Decoration.WOOD);
										break;
									case 1:
										floristShop.setDecoration(FloristShop.Decoration.PLASTIC);
								}
								break;
							case 7:
								asking = false;
								break;
						}
					}
					break;

				// Exit application
				case 2:
					return;

			}
		}

	}

	// Dialog boxes wrapper

	private static void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, 1);
	}

	private static int showOptionMenu(String title, String message, String[] options, String defaultOption) {
		return JOptionPane.showOptionDialog(null, title, message, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, defaultOption);
	}

	private static String showInputPrompt(String message) {
		String input;
		while (true) {
			input = JOptionPane.showInputDialog(message);
			if (!input.isEmpty() || input == null) {
				break;
			}
			JOptionPane.showMessageDialog(null, "Wrong input!");
		}
		return input;
	}
}
