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
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	public OutWareHouseDoc() {
		
		
		setLayout(new GridLayout(0, 1, 0, 10));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		scrollPane.setViewportView(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_6.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "\u51FA\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 15));
		
		JLabel label_5 = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_5);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		panel_4.add(textField_12);
		
		JLabel label_12 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		panel_4.add(textField_13);
		
		JLabel label_13 = new JLabel("\u76EE\u7684\u5730");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		panel_4.add(textField_14);
		
		JLabel label_14 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		panel_4.add(textField_15);
		
		JLabel label_15 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		panel_4.add(textField_16);
		
		JLabel label_16 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7/\u6C7D\u8FD0\u7F16\u53F7");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		panel_4.add(textField_17);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 15));
		
		JLabel label_17 = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		panel_5.add(textField_18);
		
		JLabel label_18 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		panel_5.add(textField_19);
		
		JLabel label_19 = new JLabel("\u76EE\u7684\u5730");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		panel_5.add(textField_20);
		
		JLabel label_20 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		panel_5.add(textField_21);
		
		JLabel label_21 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		panel_5.add(textField_22);
		
		JLabel label_22 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7/\u6C7D\u8FD0\u7F16\u53F7");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(label_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		panel_5.add(textField_23);
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "\u51FA\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(2, 0, 0, 15));
		
		JLabel label = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u51FA\u5E93\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setLayout(new GridLayout(2, 0, 0, 15));
		
		JLabel label_6 = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_3.add(textField_6);
		
		JLabel label_7 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_3.add(textField_7);
		
		JLabel label_8 = new JLabel("\u76EE\u7684\u5730");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_3.add(textField_8);
		
		JLabel label_9 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_3.add(textField_9);
		
		JLabel label_10 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_3.add(textField_10);
		
		JLabel label_11 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7/\u6C7D\u8FD0\u7F16\u53F7");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_3.add(textField_11);
	}

}
