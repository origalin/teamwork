package edu.nju.presentation.transformui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	private JTextField itemIDField;
	private JTextField receiverField;
	private JTable table;
	public SendPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{104, 1, 107, 93, 0, 0};
		gridBagLayout.rowHeights = new int[]{41, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton confirmButton = new JButton("\u786E\u8BA4\u6536\u4EF6");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JLabel label_3 = new JLabel("\u6D3E\u4EF6\u5355");
		panel_1.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JLabel label = new JLabel("\u6D3E\u4EF6\u5355");
		panel.add(label);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"单号", "收件人", "地址", "时间"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton receiveButton = new JButton("\u586B\u5199\u6536\u4EF6\u5355");
		GridBagConstraints gbc_receiveButton = new GridBagConstraints();
		gbc_receiveButton.insets = new Insets(0, 0, 5, 0);
		gbc_receiveButton.gridx = 4;
		gbc_receiveButton.gridy = 2;
		add(receiveButton, gbc_receiveButton);
		
		JLabel label_1 = new JLabel("\u6536\u4EF6\u7F16\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		itemIDField = new JTextField();
		GridBagConstraints gbc_itemIDField = new GridBagConstraints();
		gbc_itemIDField.gridwidth = 2;
		gbc_itemIDField.insets = new Insets(0, 0, 5, 5);
		gbc_itemIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemIDField.gridx = 1;
		gbc_itemIDField.gridy = 3;
		add(itemIDField, gbc_itemIDField);
		itemIDField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6536\u4EF6\u4EBA");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		receiverField = new JTextField();
		GridBagConstraints gbc_receiverField = new GridBagConstraints();
		gbc_receiverField.insets = new Insets(0, 0, 5, 0);
		gbc_receiverField.fill = GridBagConstraints.HORIZONTAL;
		gbc_receiverField.gridx = 4;
		gbc_receiverField.gridy = 3;
		add(receiverField, gbc_receiverField);
		receiverField.setColumns(10);
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.insets = new Insets(0, 0, 5, 0);
		gbc_confirmButton.anchor = GridBagConstraints.NORTH;
		gbc_confirmButton.gridx = 4;
		gbc_confirmButton.gridy = 4;
		add(confirmButton, gbc_confirmButton);
		
		JButton createButtom = new JButton("\u751F\u6210\u6536\u4EF6\u5355");
		GridBagConstraints gbc_createButtom = new GridBagConstraints();
		gbc_createButtom.anchor = GridBagConstraints.NORTH;
		gbc_createButtom.gridx = 4;
		gbc_createButtom.gridy = 5;
		add(createButtom, gbc_createButtom);
		

	}
}
