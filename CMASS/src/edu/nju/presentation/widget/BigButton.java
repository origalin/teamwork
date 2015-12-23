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
		setMargin(new Insets(0, -2, 0, 0));// ���ñ߾�
		setContentAreaFilled(false);// �����ư�ť����
		setBorderPainted(false);// �����Ʊ߿�
		setIcon(icon1);// ����Ĭ��ͼƬ
		setRolloverIcon(icon2);// ������꾭��ͼƬ
		setPressedIcon(icon3);// ������갴��ͼƬ
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
		setFont(new Font("��Բ", Font.PLAIN, 16));
		
	}
	public void setNormal() {
		setIcon(icon1);// ����Ĭ��ͼƬ
		setRolloverIcon(icon2);// ������꾭��ͼƬ
		setPressedIcon(icon3);// ������갴��ͼƬ
		setForeground(Color.black);
	}
	public void setPressed() {
		setIcon(icon3);// ����Ĭ��ͼƬ
		setRolloverIcon(icon3);// ������꾭��ͼƬ
		setPressedIcon(icon3);// ������갴��ͼƬ
		setForeground(new Color(0, 196, 211));
	}
}
