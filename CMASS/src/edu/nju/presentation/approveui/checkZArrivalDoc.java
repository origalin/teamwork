package edu.nju.presentation.approveui;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import edu.nju.vo.ZArrivalDocVO;
import java.awt.FlowLayout;
public class checkZArrivalDoc extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_3;
	private JLabel label_3;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel label_4;
	private JTextField textField_5;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	public checkZArrivalDoc() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, -30, 47, 88, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 6;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		add(panel_5, gbc_panel_5);
		
		label_3 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		panel_5.add(label_3);
		
		label_4 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355\u7F16\u53F7");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		textField_5 = new JTextField();
		panel_2.add(textField_5);
		textField_5.setEditable(false);
		textField_5.setColumns(15);
		
		label_2 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		add(label_2, gbc_label_2);
		
		panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(20);
		
		JLabel label = new JLabel("\u5230\u8FBE\u65E5\u671F");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setEditable(false);
		textField.setColumns(15);
		
		JLabel label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 2;
		add(panel_4, gbc_panel_4);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BC4\u4EF6\u5355\u53F7", "\u5230\u8FBE\u72B6\u6001"
			}
		));
	}
	public checkZArrivalDoc(ZArrivalDocVO vo) {
		// TODO Auto-generated constructor stub
	}

}
