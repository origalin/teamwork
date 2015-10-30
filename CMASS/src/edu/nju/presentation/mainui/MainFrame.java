package edu.nju.presentation.mainui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class MainFrame extends JFrame{
	public MainFrame(){
		setSize(800, 600);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void comeout() {
		this.setVisible(true);
	}
}