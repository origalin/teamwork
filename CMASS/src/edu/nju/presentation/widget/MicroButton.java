package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MicroButton extends JButton{
	ImageIcon icon = new ImageIcon("images/microIcon.png");
	public MicroButton() {
		// TODO Auto-generated constructor stub
		super();
		setUI(new MyButtonUI());
		this.setSize(70, 40);
		setMargin(new Insets(3, 15, 3, 15));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("幼圆", Font.BOLD, 17));
		setBackground(new Color(234, 234, 234));
		setForeground(new Color(58, 140,187));
		setIcon(icon);
		setOpaque(true);
	}
}
