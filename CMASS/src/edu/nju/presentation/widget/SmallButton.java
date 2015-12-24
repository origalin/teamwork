package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class SmallButton extends JButton{
	public SmallButton(String s) {
		super(s);
		setUI(new MyButtonUI());
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("幼圆", Font.PLAIN, 15));
		setBackground(new Color(234, 234, 234));
		setForeground(new Color(0, 196, 211));
		setOpaque(true);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setForeground(new Color(0, 196, 211));
				setBackground(new Color(234, 234, 234));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBackground(new Color(0, 196, 211));
				setForeground(new Color(234, 234, 234));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
