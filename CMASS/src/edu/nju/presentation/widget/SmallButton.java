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
		this.setSize(70, 40);
		setMargin(new Insets(5, 15, 5, 15));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("黑体", Font.BOLD, 17));
		setBackground(new Color(234, 234, 234));
		setForeground(new Color(0, 196, 211));
		setOpaque(true);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				setBackground(new Color(0, 186, 200));
				setForeground(new Color(234, 234, 234));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				setBackground(new Color(0, 200, 221));
				setForeground(new Color(234, 234, 234));
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
				setBackground(new Color(0, 186, 200));
				setForeground(new Color(234, 234, 234));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
