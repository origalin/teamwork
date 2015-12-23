package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BigButton extends JButton{
	ImageIcon icon1 = new ImageIcon("images/BigButton1.png");
	ImageIcon icon2 = new ImageIcon("images/BigButton2.png");
	ImageIcon icon3 = new ImageIcon("images/BigButton3.png");

	
	public BigButton(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		setUI(new MyButtonUI());
		this.setSize(icon2.getIconWidth(), icon2.getIconHeight());
		setMargin(new Insets(0, -2, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setIcon(icon1);// 设置默认图片
		setRolloverIcon(icon2);// 设置鼠标经过图片
		setPressedIcon(icon3);// 设置鼠标按下图片
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("幼圆", Font.PLAIN, 16));
		
	}
	public void setNormal() {
		setIcon(icon1);// 设置默认图片
		setRolloverIcon(icon2);// 设置鼠标经过图片
		setPressedIcon(icon3);// 设置鼠标按下图片
		setForeground(Color.black);
	}
	public void setPressed() {
		setIcon(icon3);// 设置默认图片
		setRolloverIcon(icon3);// 设置鼠标经过图片
		setPressedIcon(icon3);// 设置鼠标按下图片
		setForeground(new Color(0, 196, 211));
	}
}
