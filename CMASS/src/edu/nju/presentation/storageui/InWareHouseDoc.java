package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InWareHouseDoc extends JPanel {
	private JTextField textField_42;
	private JTextField textField_43;
	private JTable table;
	public InWareHouseDoc() {
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
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable(data,columnNames);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel label_36 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label_36 = new GridBagConstraints();
		gbc_label_36.anchor = GridBagConstraints.EAST;
		gbc_label_36.insets = new Insets(0, 0, 5, 5);
		gbc_label_36.gridx = 1;
		gbc_label_36.gridy = 1;
		panel_7.add(label_36, gbc_label_36);
		
		textField_42 = new JTextField();
		GridBagConstraints gbc_textField_42 = new GridBagConstraints();
		gbc_textField_42.insets = new Insets(0, 0, 5, 5);
		gbc_textField_42.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_42.gridx = 2;
		gbc_textField_42.gridy = 1;
		panel_7.add(textField_42, gbc_textField_42);
		textField_42.setColumns(10);
		
		JLabel label_37 = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label_37 = new GridBagConstraints();
		gbc_label_37.anchor = GridBagConstraints.EAST;
		gbc_label_37.insets = new Insets(0, 0, 5, 5);
		gbc_label_37.gridx = 1;
		gbc_label_37.gridy = 2;
		panel_7.add(label_37, gbc_label_37);
		
		textField_43 = new JTextField();
		GridBagConstraints gbc_textField_43 = new GridBagConstraints();
		gbc_textField_43.insets = new Insets(0, 0, 5, 5);
		gbc_textField_43.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_43.gridx = 2;
		gbc_textField_43.gridy = 2;
		panel_7.add(textField_43, gbc_textField_43);
		textField_43.setColumns(10);
		
		JButton button_2 = new JButton("\u751F\u6210\u5165\u5E93\u5355");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 10;
		gbc_button_2.gridy = 4;
		panel_7.add(button_2, gbc_button_2);
	}
}
