package edu.nju.presentation.logispicqueryui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QueryFrame extends JFrame{
	JPanel pn1,pn2;
	JTextField itemID;
	JButton confirm;
	JTextArea textArea;
	public QueryFrame() {
		setSize(800, 300);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pn1 = new JPanel();
		pn2 = new JPanel();
		itemID = new JTextField(20);
		confirm = new JButton("确认");
		pn1.add(new JLabel("运单号"));
		pn1.add(itemID);
		pn1.add(confirm);
		textArea = new JTextArea();
		pn2.add(textArea);
		this.add(pn1);
		this.add(pn2);
		setLocationRelativeTo(null);
	}
	public void comeout() {
		setVisible(true);
	}
}
