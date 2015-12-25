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
		setMargin(new Insets(3, 15, 3, 15));// ���ñ߾�
		setContentAreaFilled(false);// �����ư�ť����
		setBorderPainted(false);// �����Ʊ߿�
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("��Բ", Font.BOLD, 17));
		setBackground(new Color(234, 234, 234));
		setForeground(new Color(58, 140,187));
		setIcon(icon);
		setOpaque(true);
	}
}
