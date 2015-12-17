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
		setMargin(new Insets(0, 0, 0, 0));// ���ñ߾�
		setContentAreaFilled(false);// �����ư�ť����
		setBorderPainted(false);// �����Ʊ߿�
		setIcon(icon1);// ����Ĭ��ͼƬ
		setRolloverIcon(icon2);// ������꾭��ͼƬ
		setPressedIcon(icon3);// ������갴��ͼƬ
		setIcon(icon1);
		setSelectedIcon(icon2);
		setPressedIcon(icon3);
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.CENTER);
	}
}
