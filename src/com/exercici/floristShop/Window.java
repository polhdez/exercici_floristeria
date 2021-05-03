package com.exercici.floristShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;

public class Window {

	private JFrame frame;
	private JTextField textField;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New shop name:");
		lblNewLabel.setBounds(12, 12, 95, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 10, 104, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCreate = new JButton("Create!");
		btnCreate.setBounds(241, 7, 77, 25);
		frame.getContentPane().add(btnCreate);
		
		list = new JList();
		list.setBounds(12, 39, 95, 160);
		frame.getContentPane().add(list);
		
		JButton btnSelectShop = new JButton("Select shop");
		btnSelectShop.setFont(new Font("Dialog", Font.BOLD, 10));
		btnSelectShop.setBounds(12, 212, 95, 25);
		frame.getContentPane().add(btnSelectShop);
	}
	public JList getList() {
		return list;
	}
}
