package edu.nju.presentation.transformui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	private JTable table;
	private JTable table_1;
	public SendPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{104, 1, 107, 93, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"����", "�ռ���", "��ַ", "ʱ��"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton receiveButton = new JButton("\u586B\u5199\u6536\u4EF6\u5355");
		GridBagConstraints gbc_receiveButton = new GridBagConstraints();
		gbc_receiveButton.insets = new Insets(0, 0, 5, 0);
		gbc_receiveButton.gridx = 4;
		gbc_receiveButton.gridy = 2;
		add(receiveButton, gbc_receiveButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u6536\u4EF6\u5355");
		panel.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6536\u4EF6\u5355", "\u6536\u4EF6\u4EBA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton createButtom = new JButton("\u751F\u6210\u6536\u4EF6\u5355");
		GridBagConstraints gbc_createButtom = new GridBagConstraints();
		gbc_createButtom.anchor = GridBagConstraints.NORTH;
		gbc_createButtom.gridx = 4;
		gbc_createButtom.gridy = 5;
		add(createButtom, gbc_createButtom);
		

	}
}
