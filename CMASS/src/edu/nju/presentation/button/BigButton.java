package edu.nju.presentation.button;

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
		this.setSize(icon1.getIconWidth(), icon1.getIconHeight());
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setIcon(icon1);// 设置默认图片
		setRolloverIcon(icon2);// 设置鼠标经过图片
		setPressedIcon(icon3);// 设置鼠标按下图片
		setIcon(icon1);
		setSelectedIcon(icon2);
		setPressedIcon(icon3);
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
	}
}
