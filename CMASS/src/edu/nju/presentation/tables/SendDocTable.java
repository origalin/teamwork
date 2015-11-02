package edu.nju.presentation.tables;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class SendDocTable extends JPanel{
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_16;
	private JTextField textField_18;
	private JTextField textField_20;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_28;
	private JTextField textField_33;
	private JTextField textField_34;
	public SendDocTable() {
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {281, 224, 0};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JPanel panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.anchor = GridBagConstraints.WEST;
		gbc_panel_14.insets = new Insets(0, 0, 5, 5);
		gbc_panel_14.fill = GridBagConstraints.VERTICAL;
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 0;
		add(panel_14, gbc_panel_14);
		
		JLabel label_19 = new JLabel("\u7F16\u53F7");
		label_19.setFont(new Font("黑体", Font.BOLD, 15));
		panel_14.add(label_19);
		
		textField_31 = new JTextField();
		textField_31.setEnabled(false);
		textField_31.setEditable(false);
		panel_14.add(textField_31);
		textField_31.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.anchor = GridBagConstraints.WEST;
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.fill = GridBagConstraints.VERTICAL;
		gbc_panel_15.gridx = 1;
		gbc_panel_15.gridy = 0;
		add(panel_15, gbc_panel_15);
		
		JLabel label_20 = new JLabel("\u65E5\u671F");
		label_20.setFont(new Font("黑体", Font.BOLD, 15));
		panel_15.add(label_20);
		
		textField_32 = new JTextField();
		textField_32.setEnabled(false);
		panel_15.add(textField_32);
		textField_32.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		panel_1.add(label_1);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		panel_1.add(textField_6);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		panel_1.add(label_3);
		
		textField_17 = new JTextField();
		textField_17.setEnabled(false);
		textField_17.setColumns(20);
		panel_1.add(textField_17);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.anchor = GridBagConstraints.WEST;
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.VERTICAL;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 2;
		add(panel_11, gbc_panel_11);
		
		JLabel label_2 = new JLabel("\u624B\u673A");
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		panel_11.add(label_2);
		
		textField_16 = new JTextField();
		textField_16.setEnabled(false);
		textField_16.setColumns(20);
		panel_11.add(textField_16);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		panel_2.add(label_4);
		
		textField_18 = new JTextField();
		textField_18.setEnabled(false);
		panel_2.add(textField_18);
		textField_18.setColumns(40);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.WEST;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 4;
		add(panel_3, gbc_panel_3);
		
		JLabel label_5 = new JLabel("\u6536\u4EF6\u4EBA");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 5;
		add(panel_4, gbc_panel_4);
		
		JLabel label_6 = new JLabel("\u59D3\u540D");
		label_6.setFont(new Font("黑体", Font.BOLD, 15));
		panel_4.add(label_6);
		
		textField_19 = new JTextField();
		textField_19.setEnabled(false);
		textField_19.setColumns(10);
		panel_4.add(textField_19);
		
		JLabel label_8 = new JLabel("\u7535\u8BDD");
		label_8.setFont(new Font("黑体", Font.BOLD, 15));
		panel_4.add(label_8);
		
		textField_21 = new JTextField();
		textField_21.setEnabled(false);
		textField_21.setColumns(20);
		panel_4.add(textField_21);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.anchor = GridBagConstraints.WEST;
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.VERTICAL;
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 5;
		add(panel_12, gbc_panel_12);
		
		JLabel label_7 = new JLabel("\u624B\u673A");
		label_7.setFont(new Font("黑体", Font.BOLD, 15));
		panel_12.add(label_7);
		
		textField_20 = new JTextField();
		textField_20.setEnabled(false);
		textField_20.setColumns(20);
		panel_12.add(textField_20);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.WEST;
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 6;
		add(panel_5, gbc_panel_5);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		label_9.setFont(new Font("黑体", Font.BOLD, 15));
		panel_5.add(label_9);
		
		textField_22 = new JTextField();
		textField_22.setEnabled(false);
		textField_22.setColumns(40);
		panel_5.add(textField_22);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.WEST;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.VERTICAL;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 7;
		add(panel_7, gbc_panel_7);
		
		JLabel label_11 = new JLabel("\u539F\u4EF6\u6570  ");
		label_11.setFont(new Font("黑体", Font.BOLD, 15));
		panel_7.add(label_11);
		
		textField_23 = new JTextField();
		textField_23.setEnabled(false);
		textField_23.setColumns(5);
		panel_7.add(textField_23);
		
		JLabel label_12 = new JLabel("\u91CD\u91CF");
		label_12.setFont(new Font("黑体", Font.BOLD, 15));
		panel_7.add(label_12);
		
		textField_24 = new JTextField();
		textField_24.setEnabled(false);
		textField_24.setColumns(5);
		panel_7.add(textField_24);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.anchor = GridBagConstraints.WEST;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.fill = GridBagConstraints.VERTICAL;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 7;
		add(panel_13, gbc_panel_13);
		
		JLabel label_13 = new JLabel("\u4F53\u79EF");
		label_13.setFont(new Font("黑体", Font.BOLD, 15));
		panel_13.add(label_13);
		
		textField_25 = new JTextField();
		textField_25.setEnabled(false);
		textField_25.setColumns(5);
		panel_13.add(textField_25);
		
		JLabel label_14 = new JLabel("*");
		panel_13.add(label_14);
		
		textField_26 = new JTextField();
		textField_26.setEnabled(false);
		textField_26.setColumns(5);
		panel_13.add(textField_26);
		
		JLabel label_15 = new JLabel("*");
		panel_13.add(label_15);
		
		textField_27 = new JTextField();
		textField_27.setEnabled(false);
		textField_27.setColumns(5);
		panel_13.add(textField_27);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.anchor = GridBagConstraints.WEST;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.VERTICAL;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 8;
		add(panel_8, gbc_panel_8);
		
		JLabel label_16 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		label_16.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(label_16);
		
		textField_29 = new JTextField();
		textField_29.setEnabled(false);
		panel_8.add(textField_29);
		textField_29.setColumns(10);
		
		JLabel label_10 = new JLabel("\u79CD\u7C7B");
		label_10.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(label_10);
		
		textField_28 = new JTextField();
		textField_28.setEnabled(false);
		textField_28.setColumns(10);
		panel_8.add(textField_28);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.WEST;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.VERTICAL;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 8;
		add(panel_6, gbc_panel_6);
		
		JLabel label_18 = new JLabel("\u65F6\u95F4\u9884\u4F30");
		label_18.setFont(new Font("黑体", Font.BOLD, 15));
		panel_6.add(label_18);
		
		textField_33 = new JTextField();
		textField_33.setEnabled(false);
		panel_6.add(textField_33);
		textField_33.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.anchor = GridBagConstraints.WEST;
		gbc_panel_9.insets = new Insets(0, 0, 0, 5);
		gbc_panel_9.fill = GridBagConstraints.VERTICAL;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 9;
		add(panel_9, gbc_panel_9);
		
		JLabel label_17 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		label_17.setFont(new Font("黑体", Font.BOLD, 15));
		panel_9.add(label_17);
		
		textField_30 = new JTextField();
		textField_30.setEnabled(false);
		panel_9.add(textField_30);
		textField_30.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.anchor = GridBagConstraints.WEST;
		gbc_panel_10.fill = GridBagConstraints.VERTICAL;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 9;
		add(panel_10, gbc_panel_10);
		
		JLabel label_21 = new JLabel("\u4EF7\u683C");
		label_21.setFont(new Font("黑体", Font.BOLD, 15));
		panel_10.add(label_21);
		
		textField_34 = new JTextField();
		textField_34.setEnabled(false);
		panel_10.add(textField_34);
		textField_34.setColumns(10);
		
		
	}
	
}
