package edu.nju.presentation.collectionui;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class CollertionPanel extends JPanel{
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
	public CollertionPanel() {
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel_11 = new JPanel();
		add(panel_11);
		panel_11.setLayout(new GridLayout(11, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_11.add(panel_1);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		panel_1.add(label_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		panel_1.add(label_3);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(20);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		panel_2.add(label_4);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(40);
		
		JPanel panel_3 = new JPanel();
		panel_11.add(panel_3);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel label_8 = new JLabel("\u5BC4\u4EF6\u4EBA");
		panel_3.add(label_8);
		
		JPanel panel_4 = new JPanel();
		panel_11.add(panel_4);
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		JLabel label_5 = new JLabel("\u59D3\u540D");
		panel_4.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_4.add(textField_4);
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		panel_4.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(20);
		panel_4.add(textField_5);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		panel_4.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		panel_4.add(textField_6);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		panel_5.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(40);
		panel_5.add(textField_7);
		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u6258\u8FD0\u8D27\u7269\u4FE1\u606F");
		panel_6.add(label_10);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u539F\u4EF6\u6570");
		panel_8.add(label_11);
		
		textField_8 = new JTextField();
		panel_8.add(textField_8);
		textField_8.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("\u91CD\u91CF");
		panel_8.add(lblNewLabel);
		
		textField_9 = new JTextField();
		panel_8.add(textField_9);
		textField_9.setColumns(5);
		
		JLabel label_12 = new JLabel("\u4F53\u79EF");
		panel_8.add(label_12);
		
		textField_10 = new JTextField();
		panel_8.add(textField_10);
		textField_10.setColumns(5);
		
		JLabel label_13 = new JLabel("*");
		panel_8.add(label_13);
		
		textField_11 = new JTextField();
		panel_8.add(textField_11);
		textField_11.setColumns(5);
		
		JLabel label_14 = new JLabel("*");
		panel_8.add(label_14);
		
		textField_12 = new JTextField();
		panel_8.add(textField_12);
		textField_12.setColumns(5);
		
		JPanel panel_9 = new JPanel();
		panel_11.add(panel_9);
		FlowLayout flowLayout_8 = (FlowLayout) panel_9.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		
		JLabel label_15 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		panel_9.add(label_15);
		
		JRadioButton radioButton = new JRadioButton("\u6728\u7BB1");
		panel_9.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u7EB8\u7BB1");
		panel_9.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u5FEB\u9012\u888B");
		panel_9.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u5176\u4ED6");
		panel_9.add(radioButton_3);
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		buttonGroup.add(radioButton_3);
		buttonGroup.add(radioButton);
		
		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		FlowLayout flowLayout_9 = (FlowLayout) panel_10.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		
		JLabel label_16 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		panel_10.add(label_16);
		
		JRadioButton radioButton_4 = new JRadioButton("\u7279\u5FEB\u5FEB\u9012");
		panel_10.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("\u6807\u51C6\u5FEB\u9012");
		panel_10.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("\u7ECF\u6D4E\u5FEB\u9012");
		panel_10.add(radioButton_6);
		buttonGroup2.add(radioButton_4);
		buttonGroup2.add(radioButton_5);
		buttonGroup2.add(radioButton_6);
		
		JPanel panel_7 = new JPanel();
		panel_11.add(panel_7);
		FlowLayout flowLayout_10 = (FlowLayout) panel_7.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		
		JLabel label_17 = new JLabel("\u79CD\u7C7B");
		panel_7.add(label_17);
		
		textField_13 = new JTextField();
		panel_7.add(textField_13);
		textField_13.setColumns(10);
	}
	
}
