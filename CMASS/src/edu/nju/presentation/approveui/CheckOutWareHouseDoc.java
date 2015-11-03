package edu.nju.presentation.approveui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CheckOutWareHouseDoc extends JPanel{
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton button;
	public CheckOutWareHouseDoc() {
		String[] columnNames={"快递编号","出库日期","目的地","装运形式","中转单编号/装车单号"};
		String[][] data={
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				{"100031","20151031","北京","飞机","01202310"},
				
				
		};
		
		setBorder(new TitledBorder(null, "\u51FA\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 62, 218, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u51FA\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u4FEE\u6539");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		button = new JButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 3;
		gbc_button.gridy = 3;
		add(button, gbc_button);
	}

}
