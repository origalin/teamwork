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

public class TransferDocPanel_Plane extends JPanel{
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	public TransferDocPanel_Plane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{418, 168, 0};
		gridBagLayout.rowHeights = new int[]{248, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		panel_11.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u7A7A\u8FD0\u4E2D\u8F6C\u5355");
		panel.add(label);

		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u5230\u8FBE\u5730  ");
		panel_6.add(label_10);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u67DC\u53F7  ");
		panel_2.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u822A\u73ED\u53F7  ");
		panel_8.add(label_11);
		
		textField_8 = new JTextField();
		panel_8.add(textField_8);
		textField_8.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);
		
		textField_9 = new JTextField();
		panel_8.add(textField_9);
		textField_9.setColumns(5);
		

		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JButton button_1 = new JButton("\u751F\u6210\u7A7A\u8FD0\u4E2D\u8F6C\u5355");
		panel_12.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 168, 170);
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
		textField_1.setBounds(14, 183, 126, 24);
		panel_1.add(textField_1);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(49, 211, 63, 27);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				tableModel.addRow(new Object[] {textField_1.getText()});
			}
		});
		panel_1.add(button);
		

	}
}
