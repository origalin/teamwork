package edu.nju.presentation.transformui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class YArrivalDocPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	public YArrivalDocPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{183, 295, 0};
		gridBagLayout.rowHeights = new int[]{248, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		panel_11.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u8425\u4E1A\u5385\u5230\u8FBE\u5355");
		panel.add(label);

		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u6C7D\u8FD0\u5355\u53F7");
		panel_6.add(label_10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_3 = new JPanel();
		panel_11.add(panel_3);
		

		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 295, 170);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);
		
		JPanel panel_13 = new JPanel();
		scrollPane.setColumnHeaderView(panel_13);
		
		JLabel label_1 = new JLabel("\u8FD0\u5355\u53F7");
		panel_13.add(label_1);
		
		JPanel panel_14 = new JPanel();
		scrollPane.setViewportView(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8FD0\u5355\u53F7"
			}
		));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		panel_14.add(table);
		
		textField_1 = new JTextField();
		textField_1.setColumns(15);
		textField_1.setBounds(47, 183, 126, 24);
		panel_1.add(textField_1);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(122, 211, 63, 27);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				tableModel.addRow(new Object[] {textField_1.getText()});
			}
		});
		panel_1.add(button);
		
		JLabel label_2 = new JLabel("\u8FD0\u5355\u53F7");
		label_2.setBounds(0, 187, 45, 18);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u72B6\u6001");
		label_3.setBounds(180, 186, 30, 18);
		panel_1.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u635F\u574F", "\u4E22\u5931"}));
		comboBox.setBounds(224, 183, 57, 24);
		panel_1.add(comboBox);
		
		JButton button_1 = new JButton("\u751F\u6210\u5230\u8FBE\u5355");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);
		
		JPanel panel_4 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_4);
		
		JLabel label_4 = new JLabel("\u6D3E\u4EF6\u5206\u914D");
		panel_4.add(label_4);
		
		JPanel panel_5 = new JPanel();
		scrollPane_1.setViewportView(panel_5);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		panel_5.add(table_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u5206\u914D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
		

	}
}
