package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyTextField extends JTextField{
	public MyTextField() {
		// TODO Auto-generated constructor stub
		super();
		setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
		setBackground(new Color(250, 250, 250));
		setPreferredSize(new Dimension(0, 30));;
	}
}
