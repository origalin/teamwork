package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Component;
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
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.white));
	}
	
	
}
