package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

public class OutWareHouseDoc extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	public OutWareHouseDoc() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 547, 340);
		scrollPane.setViewportBorder(new TitledBorder(null, "\u51FA\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		scrollPane.setViewportView(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_6.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(0, 2, 0, 15));
		
		JLabel label = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(8);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u5E93\u65E5\u671F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u76EE\u7684\u5730");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_2);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_3);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7/\u6C7D\u8FD0\u7F16\u53F7");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_4);
		
		textField_5 = new JTextField();
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 15));
		
		JLabel label_5 = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(8);
		panel_1.add(textField_6);
		
		JLabel label_6 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_1.add(textField_7);
		
		JLabel label_7 = new JLabel("\u76EE\u7684\u5730");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_1.add(textField_8);
		
		JLabel label_8 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_1.add(textField_9);
		
		JLabel label_9 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_1.add(textField_10);
		
		JLabel label_10 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7/\u6C7D\u8FD0\u7F16\u53F7");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_1.add(textField_11);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 350, 547, 114);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("\u65B0\u5EFA\u51FA\u5E93\u8BB0\u5F55");
		btnNewButton.setBounds(370, 30, 136, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FDD\u5B58");
		btnNewButton_1.setBounds(370, 74, 136, 23);
		panel_2.add(btnNewButton_1);
	}
}
