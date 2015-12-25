package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class MyComboboxUI extends BasicComboBoxUI{

	@Override
	protected JButton createArrowButton() {
		return super.createArrowButton();
	}
	
	
	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		
		g.setColor(Color.white);
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.fill(bounds);
		
	}
}
