package edu.nju.presentation.approveui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CheckInWareHouseDoc extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton button;
	public CheckInWareHouseDoc() {
		String[] columnNames={"快递编号","入库日期","目的地","区号","排号","架号","位号"};
		String[][] data={
				{"100031","20151031","北京","航运区","10","12","1"},
				{"100032","20151031","北京","航运区","10","12","1"},
				{"100033","20151031","北京","航运区","10","12","1"},
				{"100034","20151031","北京","航运区","10","12","1"},
				{"100035","20151031","北京","航运区","10","12","1"},
				{"100036","20151031","北京","航运区","10","12","1"},
				{"100037","20151031","北京","航运区","10","12","1"},
				{"100038","20151031","北京","航运区","10","12","1"},
				{"100039","20151031","北京","航运区","10","12","1"},
				{"100040","20151031","北京","航运区","10","12","1"},
				{"100041","20151031","北京","航运区","10","12","1"},
		};
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5165\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 114, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 130, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u5165\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
		
		button = new JButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 5;
		add(button, gbc_button);
		
	}
}
