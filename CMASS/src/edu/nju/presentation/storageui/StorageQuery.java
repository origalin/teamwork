package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import javax.swing.JTable;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class StorageQuery extends JPanel{
	String[] columnNames={"快递编号","入库日期","目的地","区","排号","架号","位号"};
	String[][] rowData={
			{"1002520","20151031","北京","航运区","31","21","12"},
			{"1002521","20151031","北京","航运区","31","21","12"},
			{"1002522","20151031","北京","航运区","31","21","12"},
			{"1002523","20151031","北京","航运区","31","21","12"},
			{"1002524","20151031","北京","航运区","31","21","12"},
			{"1002525","20151031","北京","航运区","31","21","12"},
			{"1002526","20151031","北京","航运区","31","21","12"}
	};
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public StorageQuery() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5E93\u5B58\u76D8\u70B9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{584, 0};
		gridBagLayout.rowHeights = new int[]{104, 106, 106, 47, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u822A\u8FD0\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6C7D\u8FD0\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable(rowData,columnNames);
		scrollPane_1.setViewportView(table_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u8D27\u8FD0\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable(rowData,columnNames);
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{38, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton = new JButton("\u5BFC\u51FA");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 15;
		gbc_btnNewButton.gridy = 0;
		panel_3.add(btnNewButton, gbc_btnNewButton);
	}
	

}
