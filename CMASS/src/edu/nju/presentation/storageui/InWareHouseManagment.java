package edu.nju.presentation.storageui;

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
import javax.swing.JList;

public class InWareHouseManagment extends JPanel{
	private JTextField textField_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton button;
	private JPanel panel;
	private JList list;
	private JScrollPane scrollPane_1;
	public InWareHouseManagment() {
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
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5165\u5E93\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{79, 114, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{39, 217, 32, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		list = new JList(new Object[]{"中转单编号","装车编号"});
		list.setVisibleRowCount(1);
		scrollPane_1.setViewportView(list);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u751F\u6210\u5165\u5E93\u5355");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		button = new JButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 3;
		add(button, gbc_button);
		
	}
}
