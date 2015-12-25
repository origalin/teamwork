package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.metal.MetalComboBoxUI;

public class MyComboBox extends JComboBox {
	public MyComboBox() {
		setUI(new MyComboboxUI());
		setRenderer(new MyComboboxRenderer());
		setFont(new Font("свт╡", Font.BOLD, 15));
		setForeground(new Color(58, 140,187));
		setBackground(new Color(234, 234, 234));
		setBorder(BorderFactory.createLineBorder(new Color(234, 234, 234), 5));
		
	}
	
	
}
