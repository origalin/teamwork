package edu.nju.presentation.approveui;
import javax.swing.*;

import edu.nju.vo.OverDocVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
public class checkOverDoc extends JPanel{
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTable table;
	public checkOverDoc() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{48, 117, 0, 76, 0, 52, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u6536\u4EF6\u5355");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label);
		
		JLabel label_4 = new JLabel("\u6536\u4EF6\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		JLabel label_1 = new JLabel("\u6536\u4EF6\u65E5\u671F");
		panel_2.add(label_1);
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setEditable(false);
		textField.setColumns(20);
		
		JLabel label_2 = new JLabel("\u5FEB\u9012\u5458");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5FEB\u4EF6\u5355\u53F7", "\u6536\u4EF6\u4EBA"
			}
		));
		scrollPane.setViewportView(table);
	}
	public checkOverDoc(OverDocVO vo) {
		// TODO Auto-generated constructor stub
	}

}
