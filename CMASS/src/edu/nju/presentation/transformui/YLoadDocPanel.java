package edu.nju.presentation.transformui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ScrollPaneConstants;

public class YLoadDocPanel extends JPanel{
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new YLoadDocPanel());
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public YLoadDocPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		panel_11.setBorder(null);
		panel_11.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u8425\u4E1A\u5385\u88C5\u8F66\u5355");
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel label_4 = new JLabel("\u8425\u4E1A\u5385\u7F16\u53F7");
		panel_2.add(label_4);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(40);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel label_9 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7  ");
		panel_5.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(40);
		panel_5.add(textField_7);
		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u5230\u8FBE\u5730    ");
		panel_6.add(label_10);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u8F66\u8F86\u4EE3\u53F7  ");
		panel_8.add(label_11);
		
		textField_8 = new JTextField();
		panel_8.add(textField_8);
		textField_8.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);
		
		textField_9 = new JTextField();
		panel_8.add(textField_9);
		textField_9.setColumns(5);
		
		JLabel label_12 = new JLabel("\u62BC\u8FD0\u5458");
		panel_8.add(label_12);
		
		textField_10 = new JTextField();
		panel_8.add(textField_10);
		textField_10.setColumns(5);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JButton button_1 = new JButton("\u751F\u6210\u8425\u4E1A\u5385\u88C5\u8F66\u5355");
		panel_12.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);
		
		JPanel panel_13 = new JPanel();
		scrollPane.setColumnHeaderView(panel_13);
		
		JLabel label_1 = new JLabel("\u8FD0\u5355\u53F7");
		panel_13.add(label_1);
		
		JPanel panel_14 = new JPanel();
		scrollPane.setViewportView(panel_14);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_2 = new JTextField();
		panel_14.add(textField_2);
		textField_2.setColumns(30);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		textField_1 = new JTextField();
		panel_9.add(textField_1);
		textField_1.setColumns(15);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		JButton button_2 = new JButton("\u6DFB\u52A0");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				panel_14.add(new JLabel(textField_1.getText()));
			}
		});
		panel_10.add(button_2);
	}
}
