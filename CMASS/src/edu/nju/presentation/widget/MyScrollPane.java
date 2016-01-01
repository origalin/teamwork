package edu.nju.presentation.widget;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane{
	public MyScrollPane() {
		// TODO Auto-generated constructor stub
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 240, 240)));
		setViewportBorder(BorderFactory.createEmptyBorder());
		setOpaque(false);
		getViewport().setOpaque(false);
	}
}
