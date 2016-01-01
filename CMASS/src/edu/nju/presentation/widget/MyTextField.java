package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyTextField extends JTextField{
	public MyTextField() {
		// TODO Auto-generated constructor stub
		super();
//		setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		setBackground(new Color(250, 250, 250));
		setPreferredSize(new Dimension(0, 30));;
		addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
				setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
//				setBorder(BorderFactory.createLineBorder(new Color(96, 174, 219), 2));
				
				setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(96, 174, 219)));
			}
		});
	}
}
